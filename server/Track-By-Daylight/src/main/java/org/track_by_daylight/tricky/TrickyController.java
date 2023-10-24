package org.track_by_daylight.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.track_by_daylight.models.TrickyResult;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api")

public class TrickyController {

    private final String trickyToken;

    public TrickyController(@Value("${trickyToken}") String trickyToken) {
        this.trickyToken = trickyToken;
    }

    @GetMapping("/")
    public TrickyResult uploadFiles(@RequestParam("image") MultipartFile image) {
        return getFromTricky(image);
    }

    private TrickyResult getFromTricky(MultipartFile file) {

        TrickyResult result = null;

        try {
            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_1_1)
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://dbd.tricky.lol"))
                    .header("Authorization", "Bearer " + trickyToken)
                    .method("POST", HttpRequest.BodyPublishers.ofByteArray(file.getBytes()))
                    .build();

            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            var mapper = new ObjectMapper();
            TrickyResult rawResult = mapper.readValue(response.body(), TrickyResult.class);

            result = TrickyResult.fromTrickyResult(rawResult);

        } catch(IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        return result;
    }
}