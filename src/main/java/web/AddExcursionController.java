package web;

import domain.Excursion;
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

    @RequestMapping( value = "add_excursion_for_admin",  method = RequestMethod.POST)
    public ModelAndView get_tourist(HttpServletRequest request,HttpServletResponse response) throws IOException {
        ModelAndView mav=new ModelAndView();
        String login=request.getParameter("login");
        if(request.getParameter("rewrite")!=null){
            request.setAttribute("isRedact",true);
            request.setAttribute("id_excursion",Integer.parseInt(request.getParameter("excursionList")));
            request.setAttribute("excursionList",adminService.getListExcursion());
            request.setAttribute("excursion",adminService.getExcursion(Integer.parseInt(request.getParameter("excursionList"))));
        }
        if(request.getParameter("newExcursion")!=null){
            request.setAttribute("excursionList",adminService.getListExcursion());
            request.setAttribute("isAddExcursion",true);
            request.setAttribute("id_excursion",request.getParameter("excursionList"));
            request.setAttribute("excursion",adminService.getExcursion(Integer.parseInt(request.getParameter("excursionList"))));
        }
        if(request.getParameter("save")!=null){
            request.setAttribute("excursionList",adminService.getListExcursion());
            request.setAttribute("excursion",adminService.getExcursion(Integer.parseInt(request.getParameter("excursionList"))));
            request.setAttribute("id_excursion",request.getParameter("excursionList"));
            if(request.getParameter("move")!=null){
                String description=request.getParameter("description");
                int duration_tour=Integer.parseInt(request.getParameter("duration_tour"));
                String place=request.getParameter("place");
                String town=request.getParameter("town");
                int max_tourists=Integer.parseInt(request.getParameter("max_tourists"));
                double price=Double.parseDouble(request.getParameter("price"));
                Excursion excursion=new Excursion(place,town,max_tourists,price,duration_tour,description);
                if(request.getParameter("move").equals("insert")){

                    adminService.addExcursion(excursion);
                    request.setAttribute("excursionList",adminService.getListExcursion());
                    return  mav;
                }
                excursion.setExcurs_id(Integer.parseInt(request.getParameter("id_excursion")));
                adminService.updateExcursion(excursion);
            }
        }
        return  mav;
    }
}
