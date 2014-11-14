package web;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;
    String message = "";

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView registration(HttpServletRequest request,HttpServletResponse response)  {
        System.out.println("AuthenticationController.registration");
        ModelAndView modelAndView = new ModelAndView();

        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String ageString = request.getParameter("age");
        String town = request.getParameter("town");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        if (ageString == null || ageString.trim().isEmpty()|| !AuthorizationHelper.isAgeValid(Integer.valueOf(ageString.trim()))) {
            modelAndView.addObject("message", "Поле Возраст имеет неверный формат");
            modelAndView.setViewName("signup");
            return modelAndView;
        }

        Integer age = null;
        if (request.getParameter("age") != null) {
            age = Integer.valueOf(request.getParameter("age"));
        }

        if(name==null || login==null || password==null  || town==null || email==null || phone==null) message = "Данные введены не во все поля";

        if(name.isEmpty()) message = "Поле ФИО содержит пустое значение";

        if(login.isEmpty()) message = "Поле Логин содержит пустое значение";

        if(password.isEmpty()) message = "Поле Пароль содержит пустое значение";

        if(town.isEmpty()) message = "Поле Город содержит пустое значение";

        if(email.isEmpty()) message = "Поле Email содержит пустое значение";

        if(phone.isEmpty())message = "Поле Телефон содержит пустое значение";

        System.out.println("name = " + name);
        System.out.println("login = " + login);
        System.out.println("password = " + password);
        System.out.println("age = " + age);
        System.out.println("town = " + town);
        System.out.println("email = " + email);
        System.out.println("phone = " + phone);

        if (!AuthorizationHelper.isLoginValid(login))  message = "Логин имеет неверный формат";
        if (!AuthorizationHelper.isAgeValid(age)) message = "Минимальный(максимальный) возраст для регистрации на сайте 15(90)";
        if (!AuthorizationHelper.isEmailValid(email))  message = "Email имеет неверный формат";
        if (!AuthorizationHelper.isPhoneValid(phone))  message = "Phone имеет неверный формат";
        if(message==""){
            User user = new User(login, password, name, age, town, email, phone);
            boolean isAdded = authenticationService.addContact(user);
            if(!isAdded) message = "Такой логин или Email уже используется";

        }

//            User user = new User(login, password, name, age, town, email, phone);
//            authenticationService.addContact(user);
//            System.out.println("user = " + user);
//            boolean isAdded = authenticationService.addContact(user);
//            if (isAdded) response.sendRedirect("test.jsp");
//            else response.sendRedirect("login.jsp");
        modelAndView.addObject("message", message);
        modelAndView.setViewName("signup");
        return modelAndView;
    }




    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void authorization(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        System.out.println("login = " + login);
        if(request.getParameter("enter")!= null){

            response.sendRedirect("test.jsp");
        }
        if(request.getParameter("registration")!= null){
            response.sendRedirect("signup.jsp");
        }

    }

}



