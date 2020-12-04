package reporting.custom;

import cucumber.api.Result;
import cucumber.api.event.*;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import parser.Search;

public class CustomCuke implements ConcurrentEventListener {

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestRunStarted.class, getTestRunStartedHandler());
        publisher.registerHandlerFor(TestCaseStarted.class, getTestCaseStartedHandler());
        publisher.registerHandlerFor(TestStepStarted.class, getTestStepStartedHandler());
        publisher.registerHandlerFor(TestStepFinished.class, getTestStepFinishedHandler());
        publisher.registerHandlerFor(TestCaseFinished.class, getTestCaseFinishedHandler());
        publisher.registerHandlerFor(WriteEvent.class, getWriteEventHandler());
        publisher.registerHandlerFor(EmbedEvent.class, getEmbedEventHandler());
        publisher.registerHandlerFor(TestRunFinished.class, getTestRunFinishedHandler());
    }

    private EventHandler<TestRunStarted> getTestRunStartedHandler() {
        return event -> {


            System.out.println(event.getTimeStamp());
        };
    }

    private EventHandler<TestCaseStarted> getTestCaseStartedHandler() {
        return event -> {
            System.out.println(event.getTimeStamp());

        };
    }

    private EventHandler<TestStepStarted> getTestStepStartedHandler() {
        return event -> {

            System.out.println(event.getTimeStamp());
        };
    }

    private EventHandler<TestStepFinished> getTestStepFinishedHandler() {
        return event -> {

            System.out.println(event.result);
        };
    }

    private EventHandler<TestCaseFinished> getTestCaseFinishedHandler() {
        return event -> {

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

           Result.Type status = event.result.getStatus();
           int st = 1;


           if (status == Result.Type.PASSED){
               st = 1;
           }
           else st = 5;

           int caseId =Integer.parseInt(event.testCase.getTags().stream().findFirst().get().getName().substring(1));

            String body = "{\"status_id\": " + st + "," + "\"comment\": \"This test is Mitya\", \"elapsed\": \"15s\", \"defects\":\"TR-7\", \"version\": \"1.0 RC1 build 3724\"}";

            System.out.println(
            RestAssured
                    .given()
                    .spec(requestSpecification)
                    .body(body)
                    .when()
                    .post("index.php?/api/v2/add_result_for_case/411/" + caseId)
//                    .get("index.php?/api/v2/get_cases/7&suite_id=358")
                    .then()
                    .extract().body().asString()
            );
        };
    }

    private EventHandler<WriteEvent> getWriteEventHandler() {
        return event -> {

            System.out.println(event.text);
        };
    }


    private EventHandler<EmbedEvent> getEmbedEventHandler() {
        return event -> {

            System.out.println(event.name);
        };
    }


    private EventHandler<TestRunFinished> getTestRunFinishedHandler() {
        return event -> {

            System.out.println(event.getTimeStamp());
        };
    }


}
