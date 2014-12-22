package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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
    public @ResponseBody Response reserve(@RequestParam("login") String login,
                                          @RequestParam("idExcursion") Integer idExcursion,
                                          @RequestParam("numberPersons") String numberPersons,
                                          HttpServletRequest request, HttpServletResponse response
    ) throws IOException {



        Response result = new Response();
        Integer quantity;
        System.out.println("UpdateController.reserve");
        System.out.println("login = " + login);
        System.out.println("idExcursion = " + idExcursion);
        System.out.println("numberPersons = " + numberPersons);

        try {
            quantity = Integer.valueOf(numberPersons);
        } catch (NumberFormatException e) {
            result.setText("Проверьте количество мест");
            return result;
        }

        Integer isReserve = searchService.reserve(idExcursion, login, quantity);
        if(isReserve==-1){
            result.setText("Заявка отклонена! Попробуйте ввести меньшее количество мест");
            return result;
        }
        else {
            String text="Ваша заявка принята!</br> Гид в ближайшее время с Вами свяжется.</br> Номер заявки:" + isReserve.toString();
            result.setText(text);
            return result;
        }

    }



}
