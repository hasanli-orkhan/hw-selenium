package zenfira;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstTest extends BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkIsSuccess() throws InterruptedException {
        String url = "https://rahulshettyacademy.com/angularpractice/";
        driver.get(url);

        WebElement nameInput = driver.findElement(By.name("name"));
        nameInput.sendKeys("Zenfira");

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("zenfira@gmail.com");

        WebElement passwordInput = driver.findElement(By.id("exampleInputPassword1"));
        passwordInput.sendKeys("A$1234n5%");

        WebElement iceCreamCheck = driver.findElement(By.id("exampleCheck1"));
        iceCreamCheck.click();

        WebElement genderSelectionInput = driver.findElement(By.id("exampleFormControlSelect1"));
        Select genderSelection = new Select(genderSelectionInput);
        genderSelection.selectByVisibleText("Female");

        WebElement employmentStatus = driver.findElement(By.id("inlineRadio1"));
        employmentStatus.click();

        WebElement dobInput = driver.findElement(By.name("bday"));
        dobInput.sendKeys("07051984");

        WebElement submitButton = driver.findElement(By.cssSelector(".btn.btn-success"));
        submitButton.submit();

        Thread.sleep(3000);

        WebElement result = driver.findElement(By.cssSelector(".alert strong"));
        System.out.println(result.getText());
        Assert.assertEquals(result.getText(), "Success!");
    }

    @Test
    public void checkIsNameRequired() throws InterruptedException {
        String url = "https://rahulshettyacademy.com/angularpractice/";
        driver.get(url);

        WebElement nameInput = driver.findElement(By.name("name"));
        nameInput.sendKeys("");

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("zenfira@gmail.com");

        WebElement passwordInput = driver.findElement(By.id("exampleInputPassword1"));
        passwordInput.sendKeys("A$1234n5%");

        WebElement iceCreamCheck = driver.findElement(By.id("exampleCheck1"));
        iceCreamCheck.click();

        WebElement genderSelectionInput = driver.findElement(By.id("exampleFormControlSelect1"));
        Select genderSelection = new Select(genderSelectionInput);
        genderSelection.selectByVisibleText("Female");

        WebElement employmentStatus = driver.findElement(By.id("inlineRadio1"));
        employmentStatus.click();

        WebElement dobInput = driver.findElement(By.name("bday"));
        dobInput.sendKeys("07051984");

        WebElement submitButton = driver.findElement(By.cssSelector(".btn.btn-success"));
        submitButton.submit();

        Thread.sleep(3000);
        WebElement result = driver.findElement(By.cssSelector(".alert.alert-danger"));
        System.out.println(result.getText());
        Assert.assertEquals(result.getText(), "Name is required");
    }

    @Test
    public void checkIsEmailRequired() throws InterruptedException {
        String url = "https://rahulshettyacademy.com/angularpractice/";
        driver.get(url);

        WebElement nameInput = driver.findElement(By.name("name"));
        nameInput.sendKeys("Zenfira");

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("");

        WebElement passwordInput = driver.findElement(By.id("exampleInputPassword1"));
        passwordInput.sendKeys("A$1234n5%");

        WebElement iceCreamCheck = driver.findElement(By.id("exampleCheck1"));
        iceCreamCheck.click();

        WebElement genderSelectionInput = driver.findElement(By.id("exampleFormControlSelect1"));
        Select genderSelection = new Select(genderSelectionInput);
        genderSelection.selectByVisibleText("Female");

        WebElement employmentStatus = driver.findElement(By.id("inlineRadio1"));
        employmentStatus.click();

        WebElement dobInput = driver.findElement(By.name("bday"));
        dobInput.sendKeys("07051984");

        WebElement submitButton = driver.findElement(By.cssSelector(".btn.btn-success"));
        submitButton.submit();

        Thread.sleep(3000);
        WebElement result = driver.findElement(By.cssSelector(".alert.alert-danger"));
        System.out.println(result.getText());
        Assert.assertEquals(result.getText(), "Email is required");
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }
}
