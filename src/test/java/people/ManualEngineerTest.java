package people;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ManualEngineerTest {

    @Test
    public void testManualEngineerAge() {

        ManualEngineer manualEngineer = new ManualEngineer(25, 5);
        assertEquals("The age is not correct", 25, manualEngineer.getAge());

    }
    @Test
    public void testManualEngineerExperience() {

        ManualEngineer manualEngineer = new ManualEngineer(25, 5);
        assertEquals("The experience is not correct", 5, manualEngineer.getExperience());

    }

    @Test
    public void testManualEngineerSkills() {

        ManualEngineer manualEngineer = new ManualEngineer(25, 5);
        assertEquals("The skills is not correct", manualEngineer.getExperience() * 2, manualEngineer.getSkills());

    }

    @Test
    public void testManualEngineerSetAge() {

        ManualEngineer manualEngineer = new ManualEngineer(25, 5);
        manualEngineer.setAge(27);
        assertEquals("The age is not correct", 27, manualEngineer.getAge());
    }

    @Test
    public void testManualEngineerSetExperience() {

        ManualEngineer manualEngineer = new ManualEngineer(25, 5);
        manualEngineer.setExperience(10);
        assertEquals("The experience is not correct", 10, manualEngineer.getExperience());
    }

    @Test
    public void testManualEngineerSetSkills() {

        ManualEngineer manualEngineer = new ManualEngineer(25, 5);
        manualEngineer.setSkills(3);
        assertEquals("The skills is not correct", 3, manualEngineer.getSkills());

    }








}
