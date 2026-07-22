package com.example.ai.controller;

@RestController
@RequestMapping("/gemini")
public class GeminiController {

    @Autowired
    private GeminiService geminiService;

    @GetMapping
    public String ask(@RequestParam String prompt){

        return geminiService.askGemini(prompt);

    }

}