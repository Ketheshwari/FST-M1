package restAssuredApiProject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GitHubRestAssuredProject {

    String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIHp2XLJUXnaaHBq7FFJzCIv6LnlmBSKHz5r5uqIJRiht";
    int sshKeyId;

    RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("https://api.github.com/user/keys")
            .addHeader("Authorization","token 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")
            .addHeader("content-Type","application/json")
            .build();

    ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectBody("key", equalTo(sshKey))
            .expectBody("title",equalTo("gitProjectKey"))
            .build();

     @Test(priority = 1)
    public void postRequest() {


        Map<String, Object> reqbody= new HashMap<>();
        reqbody.put("title","gitProjectKey");
        reqbody.put("key","ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIHp2XLJUXnaaHBq7FFJzCIv6LnlmBSKHz5r5uqIJRiht");

        Response response =
                given().log().all().spec(requestSpec)
                        .body(reqbody).when().post(); // Send POST request

         sshKeyId=response.then().extract().path("id");
        response.then().log().all().statusCode(201).spec(responseSpec);


    }

    @Test(priority = 2)
    public void getTest()
    {

        given().log().all().spec(requestSpec).pathParam("keyId",sshKeyId)
                .when().get("/{keyId}")
                .then().log().all().statusCode(200).spec(responseSpec);
    }

    @Test(priority = 3)
    public void deleteTest()
    {
       given().log().all().spec(requestSpec).pathParam("keyId",sshKeyId)
               .when().delete("/{keyId}")
               .then().log().all().statusCode(anyOf(is(200),is(204))).time(lessThan(3000L));
    }
    {

    }
}
