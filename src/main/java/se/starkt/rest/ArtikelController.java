package se.starkt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import se.starkt.Artikel;
import se.starkt.service.ArtiklarService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by
 *
 * @author nicklas on 2017-04-05.
 */
@RestController
public class ArtikelController {

    @Autowired
    private ArtiklarService service;

    ArtikelController() {

    }

    @RequestMapping(method = GET, value = "/artikel/{id}")
    public @ResponseBody
    Artikel artikel(@PathVariable long id) {
        return service.getArtikel(id);
    }
}
