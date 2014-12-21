package web;
import domain.Excursion;
import domain.ExcursionGuide;
import domain.ExcursionTourist;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.GuideService;
import service.SearchService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Created by Igor on 17.12.2014.
 * контроллер для guide_page
 */
@Controller
@SessionAttributes("login")
public class GuideController {

    @Autowired
    private GuideService guideService;
    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/guide_page", method = RequestMethod.POST)
    public ModelAndView get_tourist(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String error="";
        ModelAndView mav=new ModelAndView();
        Map<ExcursionGuide, Excursion> set;
        int id_guide=Integer.parseInt(request.getParameter("user_id"));
        request.setAttribute("user_id",id_guide);
        String login=request.getParameter("login");
        //если гид захотел записаться на экскурсию
        if (request.getParameter("goOnTour") != null) {
            List<String> towns = searchService.getTowns();
            request.setAttribute("towns", towns);
            request.setAttribute("login", login);
            mav.setViewName("homePage");
        }
        if(request.getParameter("getTourists")!=null&&request.getParameter("select_excursion")!=null){
            int id_excurs=Integer.parseInt(request.getParameter("select_excursion"));
            Set<User> setUser=guideService.getListTourists(id_excurs,id_guide);
            List<ExcursionTourist>excursionTourists=guideService.listExcursionTouris(id_excurs,id_guide);
            request.setAttribute("id_excursion",id_excurs);
            request.setAttribute("listExcursionTourist",excursionTourists);
            request.setAttribute("setTourists",setUser);
            set=guideService.getListExcursions(id_guide);
            request.setAttribute("Excursions",set);
            return  mav;
        }

        set=guideService.getListExcursions(id_guide);
        request.setAttribute("Excursions",set);
        return  mav;
    }
}
