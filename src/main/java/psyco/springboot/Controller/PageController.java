package psyco.springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lipeng on 15/7/22.
 */
@Controller
public class PageController {
    public ModelAndView error() {
        return new ModelAndView("error");
    }
}
