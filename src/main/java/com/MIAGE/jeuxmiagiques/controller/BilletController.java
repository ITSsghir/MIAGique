package com.MIAGE.jeuxmiagiques.controller;

import com.MIAGE.jeuxmiagiques.model.Billet;
import com.MIAGE.jeuxmiagiques.service.BilletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billets")
public class BilletController {
    @Autowired
    private BilletService billetService;

    @GetMapping
    public List<Billet> getAllBillets() {
        return billetService.findAll();
    }

    @GetMapping("/{id}")
    public Billet getBilletById(@PathVariable int id) {
        return billetService.findById(id);
    }

    @PostMapping
    public Billet createBillet(@RequestBody Billet billet) {
        return billetService.save(billet);
    }

    @PutMapping("/{id}")
    public Billet updateBillet(@PathVariable int id, @RequestBody Billet billet) {
        billet.setId(id);
        return billetService.save(billet);
    }

    @DeleteMapping("/{id}")
    public void deleteBillet(@PathVariable int id) {
        billetService.deleteById(id);
    }
}
