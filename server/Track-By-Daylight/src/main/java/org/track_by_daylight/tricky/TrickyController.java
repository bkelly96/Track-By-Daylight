package org.track_by_daylight.tricky;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;


// make Tricky it's own repo. Rely on an interface for mapping.
// Make a Map Controller

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/tricky")

public class TrickyController {

    private final String trickyToken;

    public TrickyController(@Value("${trickyToken}") String trickyToken) {
        this.trickyToken = trickyToken;
    }

    @GetMapping("/maps")
    public Map<String, TrickyMap> getInfo(@RequestParam String toSearch) {
        return getFromTricky(toSearch);
    }

    @GetMapping()
    public TrickyMap getMapById(@RequestParam String toSearch) {return getFromTrickyId(toSearch);}

    TrickyMap result = null;
    private TrickyMap getFromTrickyId(String toSearch) {
        try {
            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_1_1)
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://dbd.tricky.lol/api/" + toSearch))
                    .header("Authorization", "Bearer " + trickyToken)
                    .header(HttpHeaders.CONTENT_TYPE, "application/json")
                    .build();

            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            var mapper = new ObjectMapper();
            return mapper.readValue(response.body(), TrickyMap.class);



        } catch(IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    private Map<String, TrickyMap> getFromTricky(String toSearch) {

       Map<String, TrickyMap> result = null;

        try {
            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_1_1)
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://dbd.tricky.lol/api/" + toSearch))
                    .header("Authorization", "Bearer " + trickyToken)
                    .header(HttpHeaders.CONTENT_TYPE, "application/json")
                    .build();

            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            var mapper = new ObjectMapper();
            TypeFactory typeFactory = mapper.getTypeFactory();
            MapType mapType = typeFactory.constructMapType(HashMap.class, String.class, TrickyMap.class);
            return mapper.readValue(response.body(), mapType);



            } catch(IOException ex) {
                ex.printStackTrace();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        return result;

        //make new controllers killer by id/maps by id/ survivor by id
        // pass id into fetch requests
        //map class types to response bodies for specific calls.
    }
}