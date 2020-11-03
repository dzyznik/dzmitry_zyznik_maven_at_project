package people;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AutomationEngineerTess.class,
        ManualEngineerTest.class
})
public class JUnit4Runner {

}
