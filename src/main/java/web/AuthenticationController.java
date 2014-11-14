package web;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AuthenticationController {

	@Autowired
	private AuthenticationService contactService;

    @RequestMapping("/testHibernate")
    public void testHibernate() {
        User user = new User("user", "123", "max", 21, "spb", "mail", "12345");
        contactService.addContact(user);
    }


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void registration(HttpServletRequest request,HttpServletResponse response){
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        System.out.println("password = " + password);
        Integer age = Integer.getInteger(request.getParameter("age"));
        String town = request.getParameter("town");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        if(request.getParameter("signup") != null) {
           User user = new User(login, password, name, age, town, email, phone);
           contactService.addContact(user);
        }

    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void authorization(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        System.out.println("login = " + login);
        if(request.getParameter("enter")!= null){

          //  return "redirect:/index";
          }
        if(request.getParameter("registration")!= null) //return "redirect:/signup";
        {  response.sendRedirect("/WEB-INF/views/signup.jsp");}
        //return "Ошибка!";
    }

}



