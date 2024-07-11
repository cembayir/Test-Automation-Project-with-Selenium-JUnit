package Ders05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C05_ActionsPractice extends TestBaseBeforeAfter {
    /*
    TASK
    ----
    a.https://demoqa.com/droppable adresine gidelim.
    b."Drag me" butonunu tutup "Drop here" kutusunun üstüne bırakalım.
    c."Drop here" yazısı yerine "Dropped!" olduğunu test edelim.
     */

    @Test
    public void actionsTest() throws InterruptedException {
        driver.get("https://demoqa.com/droppable");
        WebElement dragmeButton = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement droppableArea = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        Actions actions = new Actions(driver);
        Thread.sleep(1000);
        actions.dragAndDrop(dragmeButton, droppableArea).perform();
        Assert.assertEquals("Dropped!", driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());
    }
}