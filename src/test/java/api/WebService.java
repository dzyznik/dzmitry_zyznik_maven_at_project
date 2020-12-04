package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class WebService {
        public RequestSpecification getRequestSpecification () {
            RequestSpecification requestSpecification = new RequestSpecBuilder()
                    .setBaseUri("http://178.124.206.46:8001/app/ws/")
                    .setPort(8080)
                    .setAccept(ContentType.JSON)
                    .setContentType(ContentType.JSON)
                    .log(LogDetail.ALL)
                    .build();
            return requestSpecification;
        }
    }

