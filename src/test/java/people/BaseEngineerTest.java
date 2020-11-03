package people;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@FixMethodOrder()
@RunWith(Parameterized.class)
public class BaseEngineerTest {

    private Engineer engineer;

    public BaseEngineerTest(Engineer engineer) {
        this.engineer = engineer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(
                new Object[][]{
                        {new AutomationEngineer(25, 5)},
                        {new ManualEngineer(25, 5)}
                }
        );
    }


    @Test
    public void testManualEngineerAge() {

//        ManualEngineer manualEngineer = new ManualEngineer(25, 5);
        assertEquals("The age is not correct", 25, engineer.getAge());

    }
    @Test
    public void testManualEngineerExperience() {

//        ManualEngineer manualEngineer = new ManualEngineer(25, 5);
        assertEquals("The experience is not correct", 5, engineer.getExperience());

    }

    @Test
    public void testManualEngineerSkills() {

//        ManualEngineer manualEngineer = new ManualEngineer(25, 5);
        assertEquals("The skills is not correct", engineer.getExperience() * 2, engineer.getSkills());

    }

    @Test
    public void testManualEngineerSetAge() {

//        ManualEngineer manualEngineer = new ManualEngineer(25, 5);
        engineer.setAge(27);
        assertEquals("The age is not correct", 27, engineer.getAge());
    }

    @Test
    public void testManualEngineerSetExperience() {

//        ManualEngineer manualEngineer = new ManualEngineer(25, 5);
        engineer.setExperience(10);
        assertEquals("The experience is not correct", 10, engineer.getExperience());
    }

    @Test
    public void testManualEngineerSetSkills() {

//        ManualEngineer manualEngineer = new ManualEngineer(25, 5);
        engineer.setSkills(3);
        assertEquals("The skills is not correct", 3, engineer.getSkills());

    }
}
