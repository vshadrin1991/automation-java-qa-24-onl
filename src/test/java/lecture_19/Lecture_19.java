package lecture_19;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entities.pojo.Person;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Lecture_19 {
    private final String FILES_PATH = "src/test/java/lecture_19/files/";

    @Test
    public void fromJsonTest() {
        Gson gson = new Gson();
        JsonObject person = gson.fromJson(getJsonData("person.json"), JsonObject.class);
        JsonArray persons = gson.fromJson(getJsonData("persons.json"), JsonArray.class);
        System.out.println("name :: " + person.get("name").getAsString());
        System.out.println("work :: " + person.get("work").getAsJsonObject().get("company").getAsString());
        System.out.println("name 1 :: " + persons.get(0).getAsJsonObject().get("name").getAsString());
        Map<?, ?> personData = gson.fromJson(getJsonData("person.json"), Map.class);
        List<?> personsData = gson.fromJson(getJsonData("persons.json"), List.class);
        System.out.println(personData);
        System.out.println(((Map<?, ?>) personsData.get(0)).get("name"));
    }

    @Test
    public void pojoTest() {
        Gson gson = new Gson();
        Person person = gson.fromJson(getJsonData("person.json"), Person.class);
        JsonArray persons = gson.fromJson(getJsonData("persons.json"), JsonArray.class);
        System.out.println(person.getFamily().get(0).getFirstname());
        System.out.println((persons.get(0).getAsJsonObject().get("name").getAsString()));
    }

    @SneakyThrows
    public String getJsonData(String path) {
        return new String(Files.readAllBytes(Paths.get(FILES_PATH + path)));
    }
}
