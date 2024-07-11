package Ders04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_WindowHandlePractice {
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
        //driver.quit();
    }

    /*
    TASK
    ----
    1.https://www.amazon.com.tr adresine gidin.
    2.URL'in amazon içerdiğini test edelim.
    3.Yeni bir pencere açıp bestbuy anasayfasına gidelim (https://www.bestbuy.com adresine).
    4.Title'ın "Best Buy" içerdiğini test edelim.
    5.İlk sayfaya dönüp sayfada java aratalım.
    6.Arama sonuçlarının java içerdiğini test edelim.
    7.Yeniden BestBuy sayfasına gidelim.
    8.Logonun görünürlüğünü kontrol edelim.
    */

    @Test
    public void windowHandleTest() {
        driver.get("https://www.amazon.com.tr");
        driver.findElement(By.xpath("//*[@id='sp-cc-accept']")).click();

        String amazonWindowHandle = driver.getWindowHandle();
        System.out.println("amazonWindowHandle = " + amazonWindowHandle);

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "amazon";
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        driver.switchTo().newWindow(WindowType.WINDOW); //Yeni pencere (browser) açması için kullanıyoruz.
        driver.get("https://www.bestbuy.com");
        String bestbuyWindowHandle = driver.getWindowHandle();
        System.out.println("bestbuyWindowHandle = " + bestbuyWindowHandle);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Best Buy";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        driver.switchTo().window(amazonWindowHandle);

        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("java", Keys.ENTER);

        WebElement actualText = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualResult = actualText.getText();
        String expectedResult = "java";
        Assert.assertTrue(actualResult.contains(expectedResult));

        driver.switchTo().window(bestbuyWindowHandle);

        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='logo']")).isDisplayed());
    }
}