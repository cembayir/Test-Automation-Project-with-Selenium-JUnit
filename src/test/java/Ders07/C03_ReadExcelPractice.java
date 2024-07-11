package Ders07;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcelPractice {

    /*
    TASK
    ----
    a.Belirtilen satırNo ve sütunNo değerlerini parametre olarak alıp o cell'de bulunan datayı konsola yazdıralım.
    b.Sonucun konsolda yazan ile aynı olduğunu doğrulayın.
    */

    @Test
    public void Test() throws IOException {
        int satir = 3;
        int sutun = 2;
        String excel = "src/resources/takimlar.xlsx";
        FileInputStream fis = new FileInputStream(excel);
        Workbook workbook = WorkbookFactory.create(fis);
        String actualData = workbook.getSheet("Sayfa1").getRow(satir - 1).getCell(sutun - 1).toString();
        String expectedData = "Real Madrid";
        Assert.assertEquals(expectedData, actualData);
        System.out.println("actualData = " + actualData);
    }
}