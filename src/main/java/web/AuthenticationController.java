package web;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import service.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@SessionAttributes("login")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;
    String message = "";
    String messageError = "";

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView registration(HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("AuthenticationController.registration");
        if(request.getParameter("enter")!= null){
            response.sendRedirect("login.jsp");
        }
        ModelAndView modelAndView = new ModelAndView();

        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String confirmationPassword = request.getParameter("confirmation_password");
        String ageString = request.getParameter("age");
        String town = request.getParameter("town");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        if (ageString == null || ageString.trim().isEmpty()|| !AuthorizationHelper.isAgeValid(Integer.valueOf(ageString.trim()))) {
            modelAndView.addObject("messageError", "Поле Возраст имеет неверный формат. Минимальный (максимальный) возраст для регистрации на сайте 15 (90)");
            return modelAndView;
        }

        Integer age = null;
        if (request.getParameter("age") != null) {
            age = Integer.valueOf(request.getParameter("age"));
        }
        if (name == null || name.trim().isEmpty()) {
            modelAndView.addObject("messageError", "Поле ФИО имеет неверный формат");
            return modelAndView;
        }

        if (login == null || login.trim().isEmpty()|| !AuthorizationHelper.isLoginValid(login)) {
            modelAndView.addObject("messageError", "Поле Логин имеет неверный формат");
            return modelAndView;
        }

        if (password == null || password.trim().isEmpty()) {
            modelAndView.addObject("messageError", "Поле Пароль имеет неверный формат");
            return modelAndView;
        }

        if (confirmationPassword == null || confirmationPassword.trim().isEmpty()){
            modelAndView.addObject("messageError", "Поле Подтверждение пароля имеет неверный формат");
            return modelAndView;
        }

        if(!confirmationPassword.equals(password)){
           modelAndView.addObject("messageError", "Пароли не совпадают!");
           return modelAndView;
        }

        if (town == null || town.trim().isEmpty()) {
            modelAndView.addObject("messageError", "Поле Город имеет неверный формат");
            return modelAndView;
        }

        if (email == null || email.trim().isEmpty()|| !AuthorizationHelper.isEmailValid(email)) {
            modelAndView.addObject("messageError", "Поле Email имеет неверный формат");
            return modelAndView;
        }

        if (phone == null || phone.trim().isEmpty()|| !AuthorizationHelper.isPhoneValid(phone)) {
            modelAndView.addObject("messageError", "Phone имеет неверный формат");
            return modelAndView;
        }

        System.out.println("name = " + name);
        System.out.println("login = " + login);
        System.out.println("password = " + password);
        System.out.println("age = " + age);
        System.out.println("town = " + town);
        System.out.println("email = " + email);
        System.out.println("phone = " + phone);

        if(message==""){
            User user = new User(login,AuthorizationHelper.md5(password), name, age, town, email, phone);
            boolean isAdded = authenticationService.addUser(user);
            if(!isAdded) messageError = "Такой логин или Email уже используется";
            else message = "Вы успешно зарегистрированы!";

        }

        modelAndView.addObject("messageError", messageError);
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView authorization(@ModelAttribute User user,HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(request.getParameter("registration")!= null){
            response.sendRedirect("signup.jsp");
        }
        ModelAndView modelAndView = new ModelAndView();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        System.out.println("login = " + login);

        boolean isAuthorizated = authenticationService.checkAuthorization(login, AuthorizationHelper.md5(password));
        if (isAuthorizated) {
           modelAndView.addObject("login", login);
           response.sendRedirect("homePage.jsp");
        }else {
            modelAndView.addObject("messageError", "Неверная комбинация логин-пароль");

        }
        return modelAndView;
    }

}



