package api;

import io.restassured.RestAssured;
import parser.Search;

import java.io.FileNotFoundException;

public class ClientAPI {
    public static void main(String[] args) throws FileNotFoundException {
        WebService webService = new WebService();
        fullNameTestShort(webService, "a");

    }

       public static void fullNameTestShort(WebService webService, String user) {
           Search search = new Search(false, user);
           Search response =
                   RestAssured
                           .given()
                           .spec(webService.getRequestSpecification())
                           .body(search)
                           .when()
                           .post()
                           .then()
                           .statusCode(200)
                           .extract().body().as(Search.class);

           System.out.println();
       }

    }
