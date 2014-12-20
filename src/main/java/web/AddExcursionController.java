package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Igor on 21.12.2014.
 */
@Controller
@SessionAttributes("login")
public class AddExcursionController {

    @Autowired
    private AdminService adminService;

    @RequestMapping( value = "add_excursion",  method = RequestMethod.POST)
    public ModelAndView get_tourist(HttpServletRequest request,HttpServletResponse response) throws IOException {
        ModelAndView mav=new ModelAndView();
        String login=request.getParameter("login");
        if(request.getParameter("rewrite")!=null){
            request.setAttribute("isRedact",true);
            request.setAttribute("excursionList",adminService.getListExcursion());
            request.setAttribute("excursion",adminService.getExcursion(Integer.parseInt(request.getParameter("excursionList"))));
        }
        return  mav;
    }
}
