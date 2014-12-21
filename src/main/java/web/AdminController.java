package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import service.AdminService;
import service.SearchService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Igor on 20.12.2014.
 */
@Controller
@SessionAttributes("login")
public class AdminController {

    @Autowired
    private SearchService searchService;
    @Autowired
    private AdminService adminService;

    @RequestMapping( value = "admin_page",  method = RequestMethod.POST)
    public ModelAndView get_tourist(HttpServletRequest request,HttpServletResponse response) throws IOException {
        ModelAndView mav=new ModelAndView();
        String login=request.getParameter("login");
        if(request.getParameter("goOnTour")!=null){
        List<String> towns = searchService.getTowns();
        request.setAttribute("towns", towns);
        request.setAttribute("login", login);
        mav.setViewName("homePage");
        }
        if(request.getParameter("findUser")!=null){
            String login_find=request.getParameter("login_find");
            if(login_find.length()==0)login_find="0";
            request.setAttribute("listTypes",adminService.nameOfType());
            request.setAttribute("findUser",adminService.find_user(login_find));
            request.setAttribute("id_type_user",adminService.id_user_type(login_find));
            request.setAttribute("afterRequest",true);
            return mav;
        }
        if(request.getParameter("saveUser")!=null&&request.getParameter("set_type")!=null){
            adminService.saveUserType(Integer.parseInt(request.getParameter("user_id")),Integer.parseInt(request.getParameter("set_type")));
        }
        if(request.getParameter("addExcursion")!=null){
            request.setAttribute("login",request.getAttribute("login"));
            request.setAttribute("excursionList",adminService.getListExcursion());
            mav.setViewName("/add_excursion_for_admin");
        }
        return  mav;
    }
}
