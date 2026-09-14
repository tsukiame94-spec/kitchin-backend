package com.example.family_backend.controller;

import com.example.family_backend.dto.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {
    "http://localhost:5173", 
    "http://localhost:5174", 
    "https://kitchin-frontend.onrender.com",
    "https://tsukiame94-spec.github.io"
}, allowCredentials = "true")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        if ("family".equals(request.getUsername()) && "password".equals(request.getPassword())) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "ログイン成功");
            return ResponseEntity.ok(response);
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "IDまたはパスワードが違います");
            return ResponseEntity.status(401).body(response);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok(Map.of("success", true));
    }
}