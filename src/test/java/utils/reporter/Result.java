package utils.reporter;

import cucumber.api.event.TestCaseFinished;

public class Result {

    public int caseId;
    public String body;

    public void caseResult(TestCaseFinished event) {

        cucumber.api.Result.Type status = event.result.getStatus();
        int st = 1;

        if (status == cucumber.api.Result.Type.PASSED) {
            st = 1;
        } else st = 5;

        this.caseId = Integer.parseInt(event.testCase.getTags().stream().findFirst().get().getName().substring(1));

        this.body = "{\"status_id\": " + st + "," + "\"comment\": \"This test is Mitya\", \"elapsed\": \"15s\", \"defects\":\"TR-7\", \"version\": \"1.0 RC1 build 3724\"}";


    }
}
