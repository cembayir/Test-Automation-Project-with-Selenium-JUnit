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

public class C05_Alerts {
    /*
    Bir web sitesine girdiğimizde karşımıza bir uyarı mesajı yada bir butona tıkladığımızda bir uyarı(alert) çıkabilir.
    Eğer bu uyarıya incele (mouse sağ tık -> incele) yapabiliyorsak, bu tür alert'lere "HTML Alert" denir ve istediğimiz
    locate'i alabiliriz. Eğer gelen uyarı kutusuna müdahale (mouse sağ tık -> incele) edemiyorsak bu tür alertlere "JavaScript Alert" denir.
    JS Alert'lere müdahale edebilmek için;
    - Tamam veya OK için --> driver.switchTo().alert().accept(); kullanılır.
    - İptal için --> driver.switchTo().alert().dismiss(); kullanılır.
    - Alert içinde bulunan mesajı almak için --> driver.switchTo().alert().getText(); kullanılır.
    - Alert bizden bir metin göndermemizi istiyorsa --> driver.switchTo().alert().sendKeys(""); kullanılır.
     */

    WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /*
    TASK
    ----
    a.https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    b.Bir metod oluşturun --> acceptAlert.
    c.1.Butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının "You successfully clicked an alert" olduğunu test edin.
    d.Bir metod oluşturun --> dismissAlert.
    e.2.Butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının "successfully" içermediğini test edin. Alert üzerindeki mesajı yazdırın
    f.Bir metod oluşturun --> sendKeysAlert.
    g.3.Butona tıklayın, uyarıdaki metin kutusuna isminizi yazın, OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
     */

    @Test
    public void acceptAlert() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        WebElement resultText = driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']"));
        String actualText = resultText.getText();
        String expectedText = "You successfully clicked an alert";
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void dissmissAlert() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        Thread.sleep(1000);
        System.out.println("Alert içersinde bulunan mesaj : " + driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        String actualText = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']")).getText();
        String expectedText = "successfully";
        Assert.assertNotEquals(expectedText, actualText);
    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        Thread.sleep(1000);
        System.out.println("Alert içersinde bulunan mesaj : " + driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("CEM");
        driver.switchTo().alert().accept();
        String actualText = driver.findElement(By.xpath(" //*[@id='result']")).getText();
        String expectedText = "CEM";
        Assert.assertTrue(actualText.contains(expectedText));
    }
}