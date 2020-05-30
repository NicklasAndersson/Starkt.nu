package se.starkt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.starkt.service.ArtiklarService;

@RestController
public class AdminController {

    private final ArtiklarService artiklarService;

    public AdminController(ArtiklarService artiklarService) {
        this.artiklarService = artiklarService;
    }

    @GetMapping("/populate")
    public int populate() {
        artiklarService.populateArtiklarService();
        return artiklarService.antal();
    }

    @GetMapping("/save")
    public void save() {
        artiklarService.saveAsJsonFiles();
    }
}
