package web;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import service.GuideService;
import service.SearchService;
import transferObjects.Excursion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Igor on 21.12.2014.
 */
@Controller
@SessionAttributes("login")
public class ExcursionPageController {
    @Autowired
    SearchService searchService;
    @Autowired
    GuideService guideService;
    @RequestMapping(value = "excursionPage", method = RequestMethod.POST)
    public ModelAndView get_tourist(HttpServletRequest request,HttpServletResponse response) throws IOException {
        ModelAndView mav=new ModelAndView();
        String login=request.getParameter("login");
        int user_id= guideService.getIdUser(login);
        String typeName=guideService.getTypeName(user_id);
        if(typeName.equals("guide")){
            mav.addObject("user_id",user_id);
            mav.addObject("login",login);
            mav.setViewName("guide_page");
            return  mav;
        }
        if(typeName.equals("admin")){
            mav.addObject("user_id",user_id);
            mav.addObject("login",login);
            mav.setViewName("admin_page");
            return  mav;
        }
        List<String> towns = searchService.getTowns();

        request.setAttribute("towns", towns);

        mav.addObject("login", login);
        mav.setViewName("homePage");
        return mav;
    }
}
