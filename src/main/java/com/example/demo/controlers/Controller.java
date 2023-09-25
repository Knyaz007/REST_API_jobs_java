package com.example.demo.controlers;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/")
    public String index() {
        return "result";
    }
    @PostMapping("/calculate-frequency")
    public ResponseEntity<Map<Character, Integer>> calculateFrequency(@RequestParam("input") String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char lowercaseChar = Character.toLowerCase(c);
                frequencyMap.put(lowercaseChar, frequencyMap.getOrDefault(lowercaseChar, 0) + 1);
            }
        }

        return ResponseEntity.ok(frequencyMap);
    }

}
