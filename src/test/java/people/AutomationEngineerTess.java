package people;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AutomationEngineerTess {
    @Test
    public void testAutomationEngineerAge() {

        AutomationEngineer automationEngineer = new AutomationEngineer(25, 5);
        Assert.assertEquals("The age is not correct", 25, automationEngineer.getAge());

    }

    @Test
    public void testAutomationEngineerExperience() {

        AutomationEngineer automationEngineer = new AutomationEngineer(25, 5);
        Assert.assertEquals("The experience is not correct", 5, automationEngineer.getExperience());

    }

    @Test
    public void testAutomationEngineerSkills() {

        AutomationEngineer automationEngineer = new AutomationEngineer(25, 5);
        Assert.assertEquals("The skills is not correct", automationEngineer.getExperience() * 3, automationEngineer.getSkills());

    }


    @Test
    public void testAutomationEngineerSetAge() {

       AutomationEngineer automationEngineer = new AutomationEngineer(25, 5);
        automationEngineer.setAge(27);
        Assert.assertEquals("The age is not correct", 27, automationEngineer.getAge());
    }

    @Test
    public void testAutomationEngineerSetExperience() {

        AutomationEngineer automationEngineer = new AutomationEngineer(25, 5);
        automationEngineer.setExperience(10);
        Assert.assertEquals("The experience is not correct", 10, automationEngineer.getExperience());
    }

    @Test
    public void testAutomationEngineerSetSkills() {

        AutomationEngineer automationEngineer = new AutomationEngineer(25, 5);
        automationEngineer.setSkills(23);
        Assert.assertEquals("The skills is not correct", 23, automationEngineer.getSkills());

    }
}
