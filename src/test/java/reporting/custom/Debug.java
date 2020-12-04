package reporting.custom;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Debug {
    public static void main(String[] args) {
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("fakemail@tech.co");
        authScheme.setPassword("Abc123");

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://178.124.206.46")
                .setPort(8000)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .setAuth(authScheme)
                .log(LogDetail.ALL)
                .build();

        System.out.println(
                RestAssured
                        .given()
                        .spec(requestSpecification)
//                    .body("")
                        .when()
//                    .post()
                        .get("index.php?/api/v2/get_cases/7&suite_id=358")
                        .then()
                        .extract().body().asString()
        );
    }
}
