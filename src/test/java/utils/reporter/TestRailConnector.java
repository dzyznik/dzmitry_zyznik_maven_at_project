package utils.reporter;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import cucumber.api.event.*;

public class TestRailConnector {


    public static RequestSpecification TestRailLogin() {
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

        return requestSpecification;
    }

    public static void setTestResult(String body, RequestSpecification requestSpecification, int caseId) {
                RestAssured
                        .given()
                        .spec(requestSpecification)
                        .body(body)
                        .when()
                        .post("index.php?/api/v2/add_result_for_case/420/" + caseId)
                        .then()
                        .extract().body().asString();





    }

}

