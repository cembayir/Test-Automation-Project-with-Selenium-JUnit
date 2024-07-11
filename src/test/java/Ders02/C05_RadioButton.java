package Ders02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_RadioButton {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /*
    TASK
    ----
    a.https://www.facebook.com adresine gidin.
    b.Cookies'i kabul edin (Varsa).
    c."Create new account" butonuna basın.
    d."Radio Buttons" elementlerini locate edin.
    e.Seçili değilse cinsiyet butonundan size uygun olanı seçin.
    */

    @Test
    public void test() {
        driver.get("https://www.facebook.com");
        WebElement createNewButton = driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        createNewButton.click();
        WebElement firstName = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        WebElement lastName = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[2]"));
        WebElement mail = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[3]"));
        WebElement remail = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[4]"));
        WebElement password = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[5]"));
        WebElement day = driver.findElement(By.xpath("//*[@id='day']"));
        WebElement month = driver.findElement(By.xpath("//*[@id='month']"));
        WebElement year = driver.findElement(By.xpath("//*[@id='year']"));
        WebElement genderF = driver.findElement(By.xpath("(//*[@name='sex'])[1]"));
        WebElement genderM = driver.findElement(By.xpath("(//*[@name='sex'])[2]"));

        firstName.sendKeys("CM");
        lastName.sendKeys("BYR");
        mail.sendKeys("cb@gmail.com");
        remail.sendKeys("cb@gmail.com");
        password.sendKeys("!cb@gmail.com");
        day.sendKeys("28");
        month.sendKeys("May");
        year.sendKeys("1997");
        if (!genderM.isSelected()){
            genderM.click();
        }
    }
}
