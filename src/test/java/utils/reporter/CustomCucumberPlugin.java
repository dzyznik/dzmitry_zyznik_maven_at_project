package utils.reporter;

import cucumber.api.event.*;
import io.restassured.specification.RequestSpecification;

public class CustomCucumberPlugin implements ConcurrentEventListener {

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
        };
    }

    private EventHandler<TestCaseStarted> getTestCaseStartedHandler() {
        return event -> {
        };
    }

    private EventHandler<TestStepStarted> getTestStepStartedHandler() {
        return event -> {
        };
    }

    private EventHandler<TestStepFinished> getTestStepFinishedHandler() {
        return event -> {
        };
    }

    private EventHandler<TestCaseFinished> getTestCaseFinishedHandler() {
        return event -> {
            RequestSpecification requestSpecification = TestRailConnector.TestRailLogin();
            Result result = new Result();
            result.caseResult(event);
            TestRailConnector.setTestResult(result.body, requestSpecification, result.caseId);
        };
    }

    private EventHandler<WriteEvent> getWriteEventHandler() {
        return event -> {
        };
    }

    private EventHandler<EmbedEvent> getEmbedEventHandler() {
        return event -> {
        };
    }


    private EventHandler<TestRunFinished> getTestRunFinishedHandler() {
        return event -> {

        };
    }
}
