package web;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.AuthenticationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@SessionAttributes("login")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

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
//        System.out.println("age = " + age);
        System.out.println("town = " + town);
        System.out.println("email = " + email);
        System.out.println("phone = " + phone);

        Response result = new Response();
        String text = "";

        if (ageString == null || ageString.trim().isEmpty()|| !AuthorizationHelper.isAgeValid(Integer.valueOf(ageString.trim()))) {
            result.setText("Поле Возраст имеет неверный формат. Минимальный (максимальный) возраст для регистрации на сайте 15 (90)");
            return result;
        }

           Integer age = Integer.valueOf(ageString);

        if (name == null || name.trim().isEmpty()) {
            result.setText("Поле ФИО имеет неверный формат");
            return result;
        }

        if (login == null || login.trim().isEmpty()|| !AuthorizationHelper.isLoginValid(login)) {
            result.setText("Поле Логин имеет неверный формат");
            return result;
        }

        if (password == null || password.trim().isEmpty()) {
            result.setText("Поле Пароль имеет неверный формат");
            return result;
        }

        if (confirmationPassword == null || confirmationPassword.trim().isEmpty()){
            result.setText("Поле Подтверждение пароля имеет неверный формат");
            return result;
        }

        if(!confirmationPassword.equals(password)){
            result.setText("Пароли не совпадают!");
            return result;
        }

        if (town == null || town.trim().isEmpty()) {
             result.setText("Поле Город имеет неверный формат");
             return result;
        }

        if (email == null || email.trim().isEmpty()|| !AuthorizationHelper.isEmailValid(email)) {
            result.setText("Поле Email имеет неверный формат");
            return result;
        }

        if (phone == null || phone.trim().isEmpty()|| !AuthorizationHelper.isPhoneValid(phone)) {
            result.setText("Phone имеет неверный формат");
            return result;
        }



        if(result.getText()==""){
            User user = new User(login,AuthorizationHelper.md5(password), name, age, town, email, phone);
            boolean isAdded = authenticationService.addUser(user);
            if(!isAdded)  result.setText("Такой логин или Email уже используется");
            else  result.setText("Вы успешно зарегистрированы!");

        }

        return result;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public @ResponseBody Response authorization(@RequestParam("login") String login,@RequestParam("password") String password, HttpServletRequest request,HttpServletResponse response) throws IOException {
//        ModelAndView modelAndView = new ModelAndView();
        Response result = new Response();
        String isLogin = "false";
        System.out.println("login = " + login);
        System.out.println("password = " + password);
//        String result= "";
        boolean isAuthorizated = authenticationService.checkAuthorization(login, AuthorizationHelper.md5(password));
        if (isAuthorizated) {
            isLogin = "true";
            result.setText(isLogin);
        }
//           modelAndView.addObject("login", login);
        else result.setText("Неверная комбинация логин-пароль");

        return result;
    }

}



