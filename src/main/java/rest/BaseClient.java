package rest;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import propertyUtils.PropertyReader;
import rest.helper.GetHelper;
import rest.helper.PostHelper;

public class BaseClient {

    public GetHelper get;

    public PostHelper post;

    {
        post = new PostHelper(this);
        get = new GetHelper(this);
    }

    public RequestSpecification request() {
        return RestAssured.given().relaxedHTTPSValidation().baseUri(PropertyReader.getProperties().getProperty("url"));
    }
}


