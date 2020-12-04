package day19.steps;

import driver.ThreadLocalDriver;
import io.cucumber.core.api.Scenario;
import io.cucumber.core.event.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FakeBaseSteps {

    private static double passed,failed;
    private static List<String> failedNames = new ArrayList<>();

    static {
        afterAll();
    }

    @Before
    public void doBefore(){
        System.out.println("Init WebDriver");
//        ThreadLocalDriver.getWebDriver();
    }
    @After
    public void doAfter(Scenario scenario){
        if (scenario.getStatus().is(Status.PASSED)){
           failedNames.add(scenario.getName() + " at line: "
           + scenario.getLine() + System.getProperty("line.separator"));
           passed++;
        }
        else failed++;

//        ThreadLocalDriver.getWebDriver().close();
//        ThreadLocalDriver.setDriverNull();
    }

    public static void afterAll(){
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {

            StringBuilder sb = new StringBuilder();
            String ls = System.getProperty("line.separator");

            sb.append("Test execution report!" + ls);
            sb.append("Test executed: ").append(passed + failed).append(ls);
            sb.append(" - passed: ").append(passed).append(ls);
            sb.append(" - failed: ").append(failed).append(ls);
            sb.append(" - pass ratio: ").append((passed / (passed + failed)) * 100).append("%").append(ls);
            sb.append("Failed list: ").append(ls);
            failedNames.forEach(sb::append);

            System.out.println(sb.toString());

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("report.txt"))))
            {
             writer.write(sb.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
}
}

