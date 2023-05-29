package com.example.cardapio.controller;

import com.example.cardapio.dto.FoodRequestDTO;
import com.example.cardapio.dto.FoodResponseDTO;
import com.example.cardapio.model.Food;
import com.example.cardapio.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<FoodResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(FoodResponseDTO::new).toList();
    }

    @PostMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void saveFood(@RequestBody FoodRequestDTO dto) {
        Food foodData = new Food(dto);
        repository.save(foodData);
    }

}
