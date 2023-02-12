package com.insy2s.E_Redux.Controller;

import com.insy2s.E_Redux.Entites.Category;
import com.insy2s.E_Redux.Entites.Panier;
import com.insy2s.E_Redux.Services.PanierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/panier")
//open for all ports
@CrossOrigin(origins = "*")
public class PanierController {
    @Autowired
    private PanierServiceImpl panierServiceImpl;
    @PostMapping("/")
    public ResponseEntity<Panier> createPanier(@RequestBody Panier panier) throws URISyntaxException {

        Panier result = panierServiceImpl.save(panier);

        return ResponseEntity.status(201)
                .body(panier);
    }
}
