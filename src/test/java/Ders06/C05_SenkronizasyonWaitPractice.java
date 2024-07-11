package Ders06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C05_SenkronizasyonWaitPractice extends TestBaseBeforeAfter {
    /*
    TASK
    ----
    a.https://the-internet.herokuapp.com/dynamic_controls adresine gidelim.
    b.TextBox'ın etkin (enabled) olmadığını doğrulayın.
    c."Enable" butonuna tıklayın ve TextBox etkin oluncaya kadar bekleyin.
    d."It's enabled!" mesajının görüntülendiğini doğrulayın.
    e.TextBox'ın etkin (enabled) olduğunu doğrulayın.
    */

    @Test
    public void Test() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement textBox = driver.findElement(By.xpath("//*[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());
        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(textBox));
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]")).isDisplayed());
        Assert.assertTrue(textBox.isEnabled());
    }
}
