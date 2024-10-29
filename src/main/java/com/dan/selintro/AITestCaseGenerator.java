package com.dan.selintro;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class AITestCaseGenerator {
    
    // Replace with your Hugging Face API key
    private static final String API_KEY = "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";
    private static final String API_URL = "https://api-inference.huggingface.co/models/gpt2"; // or another model on Hugging Face

    public static void main(String[] args) {
        try {
            // Prompt to generate refined test scenarios and test cases
            String prompt = "Generate two detailed, structured test scenarios for an e-commerce website’s checkout process. "
            + "Each scenario should include steps and expected results. Do not include irrelevant information.";

            // Call the Hugging Face API to get AI-generated test scenarios
            String aiResponse = generateTestCases(prompt);

            // Parse the JSON response
            JSONArray responseArray = new JSONArray(aiResponse);
            String generatedText = responseArray.getJSONObject(0).getString("generated_text");

            // Display the structured and detailed AI-generated test cases
            System.out.println("AI-generated refined test scenarios and cases:");
            System.out.println(generatedText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Function to generate test cases using Hugging Face's API
    public static String generateTestCases(String prompt) throws IOException {
        // Create the API request
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        // Create the request body with the input prompt
        JSONObject inputJson = new JSONObject();
        inputJson.put("inputs", prompt);

        // Send the request
        OutputStream os = connection.getOutputStream();
        os.write(inputJson.toString().getBytes());
        os.flush();
        os.close();

        // Get the response
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Return the AI-generated response
        return response.toString();
    }
}