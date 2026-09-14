package com.example.family_backend.controller;

import com.example.family_backend.model.MenuHistory;
import com.example.family_backend.repository.MenuRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174", "https://kitchin-frontend.onrender.com"}, allowCredentials = "true")
public class MenuController {

    private final MenuRepository menuRepository;

    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @GetMapping
    public ResponseEntity<List<MenuHistory>> getAllMenus() {
        return ResponseEntity.ok(menuRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<MenuHistory> createMenu(@RequestBody MenuHistory menuHistory) {
        MenuHistory savedMenu = menuRepository.save(menuHistory);
        return ResponseEntity.ok(savedMenu);
    }
}