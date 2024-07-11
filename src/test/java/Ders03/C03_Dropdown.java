package Ders03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_Dropdown {
    WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /*
    TASK
    ----
    a.https://the-internet.herokuapp.com/dropdown adresine gidin.
    b.Index kullanarak Option-1'i seçin ve yazdırın.
    c.Value kullanarak Option-2'i seçin ve yazdırın.
    d.Visible Text kullanarak Option-1 ve Option-2 elementlerini seçin ve yazdırın.
    e.Tüm Dropdown değerlerini yazdırın.
    f.Dropdown'un boyutunu bulun, dropdown içerisinde 4 değer varsa konsola true, yoksa false yazdırın.
     */

    @Test
    public void dropdownTest() throws InterruptedException {
        WebElement dropdownList = driver.findElement(By.cssSelector("#dropdown"));
        Select select = new Select(dropdownList);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("=======================================");
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("=======================================");
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("=======================================");
        Thread.sleep(2000);
        select.selectByVisibleText("Option 2");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("=======================================");
        List<WebElement> tumddm = driver.findElements(By.xpath("//option"));
        for (WebElement w : tumddm) {
            System.out.println(w.getText());
        }
        System.out.println("Dropdown'da bulunan eleman sayısı : " + tumddm.size());
        if (tumddm.size() == 4) {
            System.out.println("Ture");
        } else {
            System.out.println("False");
        }
    }
}
