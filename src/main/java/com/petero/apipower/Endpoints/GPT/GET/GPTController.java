package com.petero.apipower.Endpoints.GPT.GET;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GPTController {
    @GetMapping("/gpt")
    public GPT gpt(@RequestParam(value = "key", defaultValue = "") String key, @RequestParam(value = "prompt", defaultValue = "") String prompt) throws IOException {
        if(key.equals("petero")) {
            return new GPT(GPTScripter.script(prompt));
        } else {
            return new GPT("Incorrect key");
        }
    }
}
