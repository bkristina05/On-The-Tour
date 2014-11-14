package web;

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


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView registration(HttpServletRequest request,HttpServletResponse response)  {
        System.out.println("AuthenticationController.registration");
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Integer age = Integer.valueOf(request.getParameter("age"));
        String town = request.getParameter("town");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        System.out.println("name = " + name);
        System.out.println("login = " + login);
        System.out.println("password = " + password);
        System.out.println("age = " + age);
        System.out.println("town = " + town);
        System.out.println("email = " + email);
        System.out.println("phone = " + phone);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Работает");
        modelAndView.setViewName("signup");

       // if (request.getParameter("signup") != null) {

//            if (!AuthorizationHelper.isEmailValid(email)) response.sendRedirect("test.jsp");

//            User user = new User(login, password, name, age, town, email, phone);
//            authenticationService.addContact(user);
//            System.out.println("user = " + user);
//            boolean isAdded = authenticationService.addContact(user);
//            if (isAdded) response.sendRedirect("test.jsp");
//            else response.sendRedirect("login.jsp");
       // }
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



