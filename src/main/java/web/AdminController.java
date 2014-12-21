package web;

import domain.UserType;
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
        if(request.getParameter("outAllUsers")!=null){
            request.setAttribute("listTypes",adminService.nameOfType());
            request.setAttribute("userTypeList",adminService.userType());
            request.setAttribute("users",adminService.allUsers());
            return mav;
        }
        if(request.getParameter("saveUsers")!=null){
            List<UserType>userTypeList=adminService.userType();
            for (UserType userType:userTypeList){
                int typeId=Integer.parseInt(request.getParameter(userType.getUser_id().toString()));
                if(userType.getType_id().intValue()!=1&&(userType.getType_id().intValue()!=typeId)){
                    adminService.saveUserType(userType.getUser_id().intValue(),typeId);
                }
            }
        }
        return  mav;
    }
}
