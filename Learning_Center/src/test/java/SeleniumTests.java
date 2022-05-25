import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.TestInstance;
import org.junit.Test;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SeleniumTests {

    public SeleniumTests() {}

    @Test
    public void testMainPage() {
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/");
        Assertions.assertTrue(true);
         assertEquals("indexPage", driver.getTitle());
        driver.quit();
    }

    @Test
    public void testAddStudent() {
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/");
        assertEquals("indexPage", driver.getTitle());
        assertEquals("indexPage", driver.getTitle());
        WebElement addStudentButton = driver.findElement(By.id("addStudentButton"));
        addStudentButton.click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        assertEquals("addStudentPage", driver.getTitle());
        driver.findElement(By.id("studentName")).sendKeys("TestName1");
        driver.findElement(By.id("studentLogin")).sendKeys("TestLogin1");
        driver.findElement(By.id("studentPassword")).sendKeys("TestPassowrd1");
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        driver.findElement(By.id("submitButton")).click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        driver.quit();
    }

}
