package com.example.family_backend.controller;

import com.example.family_backend.model.FoodItem;
import com.example.family_backend.repository.FoodRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/foods")
@CrossOrigin(origins = {
    "http://localhost:5173", 
    "http://localhost:5174", 
    "https://kitchin-frontend.onrender.com",
    "https://tsukiame94-spec.github.io"
}, allowCredentials = "true")
public class FoodController {

    private final FoodRepository foodRepository;

    public FoodController(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @GetMapping
    public ResponseEntity<List<FoodItem>> getAllFoods() {
        return ResponseEntity.ok(foodRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<FoodItem> createFood(@RequestBody FoodItem foodItem) {
        System.out.println("受け取ったデータ -> name: " + foodItem.getName());
        
        FoodItem savedItem = foodRepository.save(foodItem);
        return ResponseEntity.ok(savedItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodItem> updateFood(@PathVariable Long id, @RequestBody FoodItem updatedItem) {
        System.out.println("更新データ -> id: " + id + ", name: " + updatedItem.getName());

        Optional<FoodItem> optionalFood = foodRepository.findById(id);
        if (optionalFood.isPresent()) {
            FoodItem food = optionalFood.get();
            food.setName(updatedItem.getName());
            food.setChecked(updatedItem.isChecked());
            food.setUsedToday(updatedItem.isUsedToday());
            return ResponseEntity.ok(foodRepository.save(food));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable Long id) {
        if (foodRepository.existsById(id)) {
            foodRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}