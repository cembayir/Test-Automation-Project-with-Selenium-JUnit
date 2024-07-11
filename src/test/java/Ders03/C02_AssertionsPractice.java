package Ders03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_AssertionsPractice {
    WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /*
    TASK
    ----
    a.https://www.youtube.com adresine gidin.
    b.Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapın.
    c.titleTest --> Sayfa başlığının "Youtube" olduğunu test edin.
    d.imageTest --> Youtube resminin görüntülendiğini kontrol edin.
    e.SearchBox'ın erişilebilir olduğunu test edin.
    f.wrongTitleTest --> Sayfa başlığının "youtube" olmadığını test edin.
     */

    @Test
    public void titleTest() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "YouTube";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Test
    public void imageTest() {
        WebElement youtubeLogo = driver.findElement(By.xpath("(//*[@class='style-scope ytd-logo'])[1]"));
        Assert.assertTrue(youtubeLogo.isDisplayed());
    }

    @Test
    public void searchBoxTest() {
        WebElement searchBox = driver.findElement(By.xpath("(//*[@id='search'])[2]"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void wrongTitleTest() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "youtube";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
}