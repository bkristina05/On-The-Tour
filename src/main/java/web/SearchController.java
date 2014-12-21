package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.SearchService;
import transferObjects.Excursion;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Daria on 20.11.2014.
 */
@Controller
@SessionAttributes("login")
public class SearchController {

    @Autowired
    private SearchService searchService;


    @RequestMapping(value = "/selectTown", method = RequestMethod.POST)
    public ModelAndView searchExcursion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String town = request.getParameter("townsSelect");
        String login = request.getParameter("login");
        System.out.println("town = " + town);
        System.out.println("login = " + login);
        ModelAndView modelAndView = new ModelAndView();

            List<Excursion> excursions = searchService.getExcursions(town);
            System.out.println("excursions = " + excursions);

            request.setAttribute("excursions", excursions);

            modelAndView.addObject("login", login);
            modelAndView.setViewName("excursionPage");

        return modelAndView;
    }

    @RequestMapping(value = "/privateOffice", method = RequestMethod.POST)
    public ModelAndView selectionDataForPrivateOffice (HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException{

        String login = request.getParameter("login");
        System.out.println("login = " + login);
        ModelAndView modelAndView = new ModelAndView();

        List<Excursion> excursions = searchService.getReservedExcursions(login);
        System.out.println("excursions = " + excursions);

        request.setAttribute("excursions", excursions);

        modelAndView.addObject("login", login);
        modelAndView.setViewName("privateOffice");

        return modelAndView;
    }

}
