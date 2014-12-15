package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
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

//    @RequestMapping(value = "/searchTours", method = RequestMethod.GET)
//    public @ResponseBody Response searchTours(@RequestParam("town") String town,@RequestParam("place") String place) {
//        System.out.println("town = [" + town + "], place = [" + place + "]");
//
//        Response result = new Response();
//        Map<DateTime, Integer> tours = searchService.searchTours(town, place);
//        System.out.println("tours = " + tours);
//        if (tours.isEmpty()) {
//            result.setText("Доступных туров <br/> нет");
//        }
//        else {
//            String text = "";
//            for (DateTime time : tours.keySet()) {
//                Integer quantity = tours.get(time);
//                text += "Дата экскурсии:" + time.toString("dd:MM:yy HH:mm") + "Количество свободных мест: " + quantity + "<br/>";
//            }
//            result.setText(text);
//        }
//
//        System.out.println(result.getText());
//        return result;
//    }


    @RequestMapping(value = "/selectTown", method = RequestMethod.POST)
    public ModelAndView authorization(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

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
}
