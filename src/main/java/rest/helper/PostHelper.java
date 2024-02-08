package rest.helper;

import io.restassured.response.Response;
import lombok.extern.log4j.Log4j;
import rest.BaseClient;

@Log4j
public class PostHelper {
    BaseClient baseClient;

    public PostHelper(BaseClient baseClient) {
        this.baseClient = baseClient;
    }

    public void createUser(Object user) {
        log.debug("Create user");
        Response response = baseClient.request().basePath("/users").body(user).post();
        response.then().statusCode(201);
    }
}
