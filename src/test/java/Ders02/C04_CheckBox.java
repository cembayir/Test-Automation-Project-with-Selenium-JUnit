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

public class C04_CheckBox {
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
    a.Verilen web sayfasına gidiniz.(https://the-internet.herokuapp.com/checkboxes)
    b.CheckBox1 ve CheckBox2 elementlerini locate edin.
    c.CheckBox1 seçili değilse onay kutusuna tıklayın.
    d.CheckBox2 seçili değilse onay kutusuna tıklayın.
     */

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkBox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

        if (!checkBox1.isSelected()) {
            checkBox1.click();
        }
        if (!checkBox2.isSelected()) {
            checkBox2.click();
        }
    }
}
