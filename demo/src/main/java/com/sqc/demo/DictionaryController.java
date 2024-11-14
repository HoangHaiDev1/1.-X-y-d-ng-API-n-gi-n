package com.sqc.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DictionaryController {
    private static final Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "Xin chào");
        dictionary.put("goodbye", "Tạm biệt");
        dictionary.put("thank you", "Cảm ơn");
        dictionary.put("cat", "Con mèo");
        dictionary.put("dog", "Con chó");
        dictionary.put("apple", "Quả táo");
        dictionary.put("book", "Cuốn sách");
        dictionary.put("computer", "Máy tính");
    }

    @GetMapping("/dictionary")
    public ResponseEntity<String> englist(@RequestParam String word) {
        String cleanWord = word.trim().toLowerCase();

        if (dictionary.containsKey(cleanWord)) {
            return ResponseEntity.ok(dictionary.get(cleanWord));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Word not found: " + cleanWord);
        }
    }

}
