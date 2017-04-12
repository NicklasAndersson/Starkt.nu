package se.starkt.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by
 *
 * @author nicklas on 2017-04-11.
 */
@Controller
public class ClientController {
    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        return "index";
    }
}
