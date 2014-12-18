package web;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.AuthenticationService;
import service.GuideService;
import service.SearchService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@SessionAttributes("login")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;
    @Autowired
    private SearchService searchService;
    @Autowired
    private GuideService guideService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public @ResponseBody Response registration(
                                                  @RequestParam("login") String login,
                                                  @RequestParam("password") String password,
                                                  @RequestParam("name") String name,
                                                  @RequestParam("confirmation_password") String confirmationPassword,
                                                  @RequestParam("age") String ageString,
                                                  @RequestParam("town") String town,
                                                  @RequestParam("email") String email,
                                                  @RequestParam("phone") String phone,
                                                  HttpServletRequest request, HttpServletResponse response
                                            ) throws IOException {
        System.out.println("AuthenticationController.registration");

        System.out.println("name = " + name);
        System.out.println("login = " + login);
        System.out.println("password = " + password);
        System.out.println("town = " + town);
        System.out.println("email = " + email);
        System.out.println("phone = " + phone);

        Response result = new Response();


        if (ageString == null || ageString.trim().isEmpty()|| !AuthorizationHelper.isAgeValid(Integer.valueOf(ageString.trim()))) {
            result.setText("<h2>Поле Возраст имеет неверный формат. Минимальный (максимальный) возраст для регистрации на сайте 15 (90)</h2>");
            return result;
        }

           Integer age = Integer.valueOf(ageString);

        if (name == null || name.trim().isEmpty()) {
            result.setText("</h2>Поле ФИО имеет неверный формат</h2>");
            return result;
        }

        if (login == null || login.trim().isEmpty()|| !AuthorizationHelper.isLoginValid(login)) {
            result.setText("<h2>Поле Логин имеет неверный формат</h2>");
            return result;
        }

        if (password == null || password.trim().isEmpty()) {
            result.setText("<h2>Поле Пароль имеет неверный формат</h2>");
            return result;
        }

        if (confirmationPassword == null || confirmationPassword.trim().isEmpty()){
            result.setText("<h2>Поле Подтверждение пароля имеет неверный формат</h2>");
            return result;
        }

        if(!confirmationPassword.equals(password)){
            result.setText("<h2>Пароли не совпадают!</h2>");
            return result;
        }

        if (town == null || town.trim().isEmpty()) {
             result.setText("<h2>Поле Город имеет неверный формат</h2>");
             return result;
        }

        if (email == null || email.trim().isEmpty()|| !AuthorizationHelper.isEmailValid(email)) {
            result.setText("<h2>Поле Email имеет неверный формат</h2>");
            return result;
        }

        if (phone == null || phone.trim().isEmpty()|| !AuthorizationHelper.isPhoneValid(phone)) {
            result.setText("<h2>Phone имеет неверный формат</h2>");
            return result;
        }

        if(!authenticationService.checkForTheExistenceLogin(login)){
            result.setText("<h2>Логин уже кем-то занят</h2>");
            return result;
        }
        if(!authenticationService.checkForTheExistenceEmail(email)){
            result.setText("<h2>Такой Email уже используется</h2>");
            return result;
        }

            User user = new User(login,AuthorizationHelper.md5(password), name, age, town, email, phone);
            boolean isAdded = authenticationService.addUser(user);
            if(!isAdded)  result.setText("<h2>Cбой при записи в БД</h2>");
            else  result.setText("<h3>Вы успешно зарегистрированы!</h3>");

        return result;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
     public ModelAndView authorization(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        System.out.println("login = " + login);
        ModelAndView modelAndView = new ModelAndView();

        if (request.getParameter("registration") != null) response.sendRedirect("signup.jsp");

        boolean isAuthorizated = authenticationService.checkAuthorization(login, AuthorizationHelper.md5(password));
        if (!isAuthorizated) modelAndView.addObject("messageError", "Неверная комбинация логин-пароль");
        else {
            int user_id= guideService.getIdUser(login);
            String typeName=guideService.getTypeName(user_id);
            if(typeName.equals("guide")){
                modelAndView.addObject("user_id",user_id);
                modelAndView.addObject("login",login);
                modelAndView.setViewName("guide_page");
                return  modelAndView;
            }
            if(typeName.equals("admin")){
                modelAndView.addObject("user_id",user_id);
                modelAndView.addObject("login",login);
                modelAndView.setViewName("admin_page");
                return  modelAndView;
            }
            List<String> towns = searchService.getTowns();
            System.out.println("towns = " + towns);

            request.setAttribute("towns", towns);

            modelAndView.addObject("login", login);
            modelAndView.setViewName("homePage");
        }

        return modelAndView;
        }

    }