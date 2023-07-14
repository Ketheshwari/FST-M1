package restAssuredApiProject;

import io.restassured.authentication.BasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GitHubProject {

    RequestSpecification requestSpec;

    String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIHp2XLJUXnaaHBq7FFJzCIv6LnlmBSKHz5r5uqIJRiht";
    int id= 82807526;

    @BeforeClass
    public void setUp() {



        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")
                .addHeader("Authorization","token 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")
                .setContentType(ContentType.JSON)
                .build();
             //   .addHeader("acessToken","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")


    }
//82807526
    @Test
    public void postRequest() {

        String reqBody = "{\"title\": \"gitHubKey\",\"key\": \"ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIHp2XLJUXnaaHBq7FFJzCIv6LnlmBSKHz5r5uqIJRiht\"}";

        Response response =
                given().log().all().spec(requestSpec)
                        .body(reqBody).when().post( "/user/keys").then().log().all().statusCode(201).extract().response(); // Send POST request

  String responseBody = response.asPrettyString();

        JsonPath js = new JsonPath(responseBody);
        this.id= js.getInt("id");
        System.out.println(id);


    }
    @Test
    public void getRequest() {

        Response responseget =
                given().log().all().spec(requestSpec).pathParam("keyId",id)
                        .when().get( "/user/keys/{keyId}"); // Send POST request

        String body = responseget.getBody().asPrettyString();
        System.out.println(body);

        responseget.then().statusCode(200);
    }

    @Test
    public void deleteRequest() {

        Response responsedelete =
                given().spec(requestSpec).pathParam("keyId",id)
                        .when().get( " /user/keys/{keyId}"); // Send POST request

        String body = responsedelete.getBody().asPrettyString();
        System.out.println(body);

        responsedelete.then().statusCode(200);
    }


}
