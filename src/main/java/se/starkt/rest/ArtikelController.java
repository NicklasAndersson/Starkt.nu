package se.starkt.rest;


import model.Artikel;
import model.ArtikelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import se.starkt.service.ArtiklarRepository;
import se.starkt.service.ArtiklarService;

import javax.annotation.PostConstruct;

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

    @Autowired
    ArtiklarRepository repository;

    @RequestMapping(method = GET, value = "/artikel/{id}")
    public @ResponseBody
    Artikel artikel(@PathVariable long id) {
        return service.getArtikel(id);
    }


    @RequestMapping(value = "/artiklar", method = GET)
    public Page<ArtikelDao> getArtiklar(PageRequest pageRequest) {
        return repository.findAll(pageRequest);
    }

    @PostConstruct
    public void insertData() {
        for (Artikel a : service.getArtiklar()) {
            repository.save(a.getDao());
        }
    }
}
