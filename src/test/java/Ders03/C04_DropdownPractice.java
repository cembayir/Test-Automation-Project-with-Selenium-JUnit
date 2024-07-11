package Ders03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_DropdownPractice {
    WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
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
    a.https://www.amazon.com.tr adresine gidin.
    b.Çerezleri "Kabul Et" seçeneğine tıklayın.
    c.SearchBox'ın yanında bulunan "Kategori" menüsünün kategori sayısının 40 olduğunu test edin.
    d.Kategori menüsünden "Kitaplar" seçeneğini seçin.
    e.SearchBox'a "Java" yazın ve aratın.
    f.Bulunan sonuç sayısını yazdırın.
    g.Sonucun "Java" kelimesini içerdiğini test edin.
     */

    @Test
    public void amazonTest() {
        driver.get("https://www.amazon.com.tr");
        driver.findElement(By.cssSelector("#sp-cc-accept")).click();
        List<WebElement> ddm = driver.findElements(By.xpath("//option"));
        System.out.println(ddm.size());
        for (WebElement w : ddm) {
            System.out.println(w.getText());
        }

        int actualDropdown = ddm.size();
        int expectedDropdown = 40;
        Assert.assertNotEquals(expectedDropdown, actualDropdown);

        WebElement ddmList = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(ddmList);
        select.selectByVisibleText("Kitaplar");
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Java", Keys.ENTER);

        WebElement sonucText = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucText.getText());

        String actualText = sonucText.getText();
        String expectedText = "Java";
        Assert.assertTrue(actualText.contains(expectedText));
    }
}
