package lecture_14;

import entities.lombok.Home;
import lecture_14.entity.Car;
import lecture_14.entity.Person;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.Test;

@Log4j
public class Lecture_14 {

    @Test(priority = 1)
    public void carTest() {
        Car passat = new Car();
        passat.setModel("VW");
        passat.setType("Passat");
        passat.setYear(1994);
        log.info(passat);

        Car audi = new Car("Audi", "A6", 2004, 2.0);
        log.info(audi);
    }

    @Test(priority = 2)
    public void personTest() {
        Person person = new Person() {{
            setFirstname("Tester");
            setLastname("Test");
            setAge(29);
        }};
        log.info(person);
    }

    @Test(priority = 3)
    public void homeTest() {
        Home home = Home.create().withAddress("Minsk").withAge(12).done();
        log.info(home);
    }
}
