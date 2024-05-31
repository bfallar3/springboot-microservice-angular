package ph.benjsoft.microservice.with.angular.controller;

import com.google.gson.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ph.benjsoft.microservice.with.angular.model.Person;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JsonController {

    @PostMapping("/extract/{keyToFind}")
    public ResponseEntity<List<String>> process(@PathVariable String keyToFind, @RequestBody Person person) {
        List<String> values =  extractValuesFromModel(keyToFind, person);
        return ResponseEntity.ok(values);
    }

    private List<String> extractValuesFromModel(String keyToFind, Person model) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(model);
        JsonElement rootElement = JsonParser.parseString(jsonString);

        List<String> values = new ArrayList<>();
        findKey(rootElement, keyToFind, values);

        String sanitizeJsonString = sanitizeJsonArray(values.toString());
        return convertJsonToList(sanitizeJsonString);
    }

    private static void findKey(JsonElement element, String keyToFind, List<String> values) {
        if (element.isJsonObject()) {
            JsonObject jsonObject = element.getAsJsonObject();
            for (String key : jsonObject.keySet()) {
                JsonElement childElement = jsonObject.get(key);
                if (key.equals(keyToFind)) {
                    values.add(childElement.toString());
                }
                findKey(childElement, keyToFind, values);
            }
        } else if (element.isJsonArray()) {
            JsonArray jsonArray = element.getAsJsonArray();
            for (JsonElement arrayElement : jsonArray) {
                findKey(arrayElement, keyToFind, values);
            }
        }
    }

    public static String sanitizeJsonArray(String jsonString) {
        JsonElement rootElement = JsonParser.parseString(jsonString);
        if (rootElement.isJsonArray()) {
            JsonArray jsonArray = rootElement.getAsJsonArray();
            JsonArray sanitizedArray = new JsonArray();
            for (JsonElement element : jsonArray) {
                if (element.isJsonPrimitive() && element.getAsJsonPrimitive().isString()) {
                    String sanitizedString = element.getAsString().replace("\"", "");
                    sanitizedArray.add(new JsonPrimitive(sanitizedString));
                }
            }
            return sanitizedArray.toString();
        } else {
            throw new JsonSyntaxException("Input is not a JSON array");
        }
    }

    public static List<String> convertJsonToList(String jsonString) {
        JsonElement rootElement = JsonParser.parseString(jsonString);
        if (rootElement.isJsonArray()) {
            JsonArray jsonArray = rootElement.getAsJsonArray();
            List<String> list = new ArrayList<>();
            for (JsonElement element : jsonArray) {
                if (element.isJsonPrimitive() && element.getAsJsonPrimitive().isString()) {
                    list.add(element.getAsString());
                }
            }
            return list;
        } else {
            throw new JsonSyntaxException("Input is not a JSON array");
        }
    }
}
