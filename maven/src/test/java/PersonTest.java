import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.assertEquals;

public class PersonTest {
    @BeforeClass
    public static void beforeClass() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

    @AfterClass
    public static void afterClass() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("TeenageTest test started");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("TeenageTest test done");
    }

    @DataProvider(name = "ageTest", parallel = true)
    public Object[][] ageDataProvider() {
        return new Object[][] {
                {10, false},
                {13, true},
                {15, true},
                {19, true},
                {20, false},
                {30, false}
        };
    }

    @Test(dataProvider = "ageTest")
    public void testIsTeenager(int age, boolean expectedResult) {
        boolean result = Person.isTeenager(age);
        assertEquals(result, expectedResult);
    }
}