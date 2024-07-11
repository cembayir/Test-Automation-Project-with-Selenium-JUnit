package Ders07;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcelPractice {
    /*
    TASK
    ----
    a.Dosya yolunu bir string değişkene atayalım.
    b.FileInputStream objesi oluşturup, parametre olarak dosya yolunu girelim.
    c.Workbook objesi oluşturalım, parametre olarak fileInputStream objesini girelim.
    d.Sheet objesi oluşturalım.
    e.Row objesi oluşturalım.
    f.Cell objesi oluşturalım
    */

    @Test
    public void Test() throws IOException {
        String excel = "src/resources/takimlar.xlsx";
        FileInputStream fis = new FileInputStream(excel);
        Workbook workbook = WorkbookFactory.create(fis);
        String actualData = workbook.getSheet("Sayfa1").getRow(4).getCell(1).toString();
        System.out.println("actualData = " + actualData);
    }
}