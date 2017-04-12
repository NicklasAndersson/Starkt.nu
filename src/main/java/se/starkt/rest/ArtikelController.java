package se.starkt.rest;

import com.fasterxml.jackson.annotation.JsonView;
import model.Artikel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.*;
import se.starkt.service.ArtiklarRepository;
import se.starkt.service.ArtiklarService;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

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

    @JsonView(DataTablesOutput.View.class)
    @RequestMapping(value = "/artiklar", method = GET)
    public DataTablesOutput<Artikel> getArtiklar(@Valid DataTablesInput input) {
        return repository.findAll(input);
    }

    @PostConstruct
    public void insertData() {
        for (Artikel a : service.getArtiklar()) {
            repository.save(a);
        }
    }
}
