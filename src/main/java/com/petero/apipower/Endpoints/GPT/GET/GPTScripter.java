package com.petero.apipower.Endpoints.GPT.GET;

import java.io.*;
import java.util.Scanner;

public class GPTScripter {
    public static String script(String prompt) throws IOException {
        PrintWriter pw = new PrintWriter("GPTScript.py");
        pw.println("""
                import os
                import openai
                openai.api_key ="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"
                """);
        pw.print("prompt=" + prompt);
        pw.print("""

                completion = openai.ChatCompletion.create(
                  model="gpt-3.5-turbo",
                  messages=[
                    {"role": "user", "content": prompt}
                  ]
                )

                print(completion.choices[0].message.content)
                """);
        pw.close();
        ProcessBuilder pb = new ProcessBuilder("python3", "GPTScript.py");
        Process p = pb.start();
        Scanner sc = new Scanner(p.getInputStream());
        StringBuilder lines = new StringBuilder();
        while(sc.hasNextLine()){
            lines.append(sc.nextLine());
        }
        return lines.toString();
    }
}
