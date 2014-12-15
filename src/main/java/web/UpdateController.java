package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.SearchService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Daria on 15.12.2014.
 */
@Controller
@SessionAttributes("login")
public class UpdateController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/reservePlace", method = RequestMethod.GET)
    public @ResponseBody Response reserve(
            @RequestParam("login") String login,
            @RequestParam("idExcursion") Integer idExcursion,
            @RequestParam("town") String town,
            @RequestParam("place") String place,
            @RequestParam("availablePlaces") Integer availablePlaces,
            @RequestParam("duration") Double duration,
            @RequestParam("numberPersons") Integer numberPersons,
            HttpServletRequest request, HttpServletResponse response
    ) throws IOException {


        Response result = new Response();

        System.out.println("login = " + login);
        System.out.println("idExcursion = " + idExcursion);
        System.out.println("town = " + town);
        System.out.println("place = " + place);
        System.out.println("availablePlaces = " + availablePlaces);
        System.out.println("duration = " + duration);
        System.out.println("numberPersons = " + numberPersons);
        Integer isReserve = searchService.getReserve(idExcursion,login,numberPersons);
        if(isReserve==-1){
            result.setText("Заявка отклонена!");
            return result;
        }
        else {
            String text="Ваша заявка принята!</br> Гид в ближайшее время с Вами свяжется.</br> Номер заявки:" + isReserve.toString();
            result.setText(text);
            return result;
        }

    }
}
