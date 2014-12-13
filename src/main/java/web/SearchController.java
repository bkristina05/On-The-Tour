package web;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.SearchService;

import java.util.Map;

/**
 * Created by Daria on 20.11.2014.
 */
@Controller
public class SearchController {


    @Autowired
    private SearchService searchService;


    @RequestMapping(value = "/searchTours", method = RequestMethod.GET)
    public @ResponseBody Response searchTours(@RequestParam("town") String town,@RequestParam("place") String place) {
        System.out.println("town = [" + town + "], place = [" + place + "]");

        Response result = new Response();
        Map<DateTime, Integer> tours = searchService.searchTours(town, place);
        System.out.println("tours = " + tours);
        if (tours.isEmpty()) {
            result.setText("Доступных туров <br/> нет");
        }
        else {
            String text = "";
            for (DateTime time : tours.keySet()) {
                Integer quantity = tours.get(time);
                text += "Дата экскурсии:" + time.toString("dd:MM:yy HH:mm") + "Количествосвободных мест " + quantity + "<br/>";
            }
            result.setText(text);
        }

        System.out.println(result.getText());
        return result;
    }


}
