package Ders05;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C07_FakerClass extends TestBaseBeforeAfter {
    /*
    - Faker Class'ı ile yeni kullanıcı oluşturacaksak veya bir liste oluşuturlması gerekiyorsa, bu class sayesinde
    random olarak, gerçek verilermiş gibi veriler üreterek kullanabiliyoruz.

    //==============================================================================================================//

    TASK
    ----
    a.https://www.facebook.com adresine gidelim.
    b."Yeni hesap oluştur" butonuna basalım.
    c.Ad,Soyad,Mail ve Şifre alanlarına değer girelim ve Kaydol'a basalım.
    */

    @Test
    public void fakerTest() throws InterruptedException {
        driver.get("https://www.facebook.com");
        WebElement kaydolButonu = driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        Actions actions = new Actions(driver);
        actions.click(kaydolButonu).perform();
        Thread.sleep(1000);

        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        actions.sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB).sendKeys(email).sendKeys(Keys.TAB).sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(faker.number().digit()).sendKeys(Keys.TAB).sendKeys("May")
                .sendKeys(Keys.TAB).sendKeys("1997").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
    }
}