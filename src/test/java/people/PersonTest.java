package people;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class PersonTest {

    @Test
    public void testPersonAge() {

        Person person = new Person(25);
        assertEquals("The age is not correct", 24, person.getAge());

    }
    @Test
    public void testPersonSetAge() {

        Person person = new Person(25);
        person.setAge(26);
        assertEquals("The age is not correct", 26, person.getAge());

    }
    @Test
    public void testPersonDoubleAge() {

        Person person = new Person(2 * 20);
        assertEquals("The age is not correct", 40, person.getAge());

    }

    @Test
    public void testDemo() {
        boolean check = false;
        String str = "buha";

        if (str.contains("bu") == true && str.contains("ga") == true){
            check = true;
            System.out.println("Passed");
        }
        else{
            System.out.println("Failed");
        }

        assertEquals("The age is not correct!", true, check);

    }

    @Test
    public void testDemo1() {
        assertThat("buha", both(containsString("bu")).and(containsString("ga")));


    }
}
