package lecture_20;

import entities.pojo.user.Data;
import entities.pojo.user.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import rest.BaseClient;
import testngUtils.Listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static propertyUtils.PropertyReader.getProperties;

@Listeners(Listener.class)
public class Lecture_20 extends BaseTest {
    List<Map> userList = new ArrayList<>();

    @BeforeTest
    public void preconditions() {
        baseURI = getProperties().getProperty("url");
    }

    @Test(priority = 1)
    public void listUserTest() {
        Response response = given().basePath("/users").param("page", "2").get();
        Assert.assertEquals(response.statusCode(), 200);
        response.then().statusCode(200);
        userList = response.jsonPath().getList("data", Map.class);
    }

    @Test(priority = 2)
    public void singleUserTest() {
        Response response = given().basePath("/users").get(userList.get(0).get("id").toString());
        response.then().statusCode(200);
        response.prettyPrint();
        Assert.assertEquals(Integer.parseInt(userList.get(0).get("id").toString()), response.jsonPath().getInt("data.id"));
        Data data = response.jsonPath().getObject("data", Data.class);
        User user = response.jsonPath().getObject("", User.class);
        Assert.assertEquals(data.getId(), Integer.parseInt(userList.get(0).get("id").toString()));
        Assert.assertEquals(data.getEmail(), userList.get(0).get("email").toString());
        Assert.assertEquals(data.getFirst_name(), userList.get(0).get("first_name").toString());
        Assert.assertEquals(data.getLast_name(), userList.get(0).get("last_name").toString());
        Assert.assertEquals(data.getAvatar(), userList.get(0).get("avatar").toString());
    }

    @Test(priority = 3)
    public void createTest() {
        Response response = given().basePath("/users").body("{\n" +
                "    \"name\": \"tester\",\n" +
                "    \"job\": \"qa\"\n" +
                "}").post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

    @Test(priority = 4)
    public void createWithObjectTest() {
        Response response = given().basePath("/users").body(new CreateUser() {{
            setJob("Qa");
            setName("qa");
        }}).post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

    @Test(priority = 5)
    public void createWithGetMethodTest() {
        Response response = get(BaseClient.class).request().basePath("/users").body(new CreateUser() {{
            setJob("Qa");
            setName("qa");
        }}).post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

    @Test(priority = 6)
    public void createWithGetMethodAndHelperTest() {
        CreateUser user = new CreateUser() {{
            setJob("Qa");
            setName("qa");
        }};
        get(BaseClient.class).post.createUser(user);
    }

    @lombok.Data
    static class CreateUser {
        private String name;
        private String job;
    }
}
