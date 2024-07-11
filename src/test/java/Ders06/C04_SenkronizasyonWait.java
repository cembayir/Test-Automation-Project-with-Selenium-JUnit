package Ders06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C04_SenkronizasyonWait extends TestBaseBeforeAfter {

    /*
    TASK
    ----
    a.https://the-internet.herokuapp.com/dynamic_controls adresine gidelim.
    b.Remove butonuna basalım.
    c."It's gone!" mesajının görüntülendiğini doğrulayalım.
    d.Add Butonuna basalım.
    e."It's back!" mesajının görüntülendiğini doğrulayalım.
     */

    @Test
    public void implicityWaitTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"It's gone!\"]")).isDisplayed());
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"It's back!\"]")).isDisplayed());
    }

    @Test
    public void explicityWaitTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement itsGone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));
        Assert.assertTrue(itsGone.isDisplayed());
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        WebElement itsBack = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));
        Assert.assertTrue(itsBack.isDisplayed());
    }
}