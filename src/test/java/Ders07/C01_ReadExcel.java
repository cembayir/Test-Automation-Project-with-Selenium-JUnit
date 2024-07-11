package Ders07;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    /*
    TASK
    ----
    a.Dosya yolunu bir string değişkene atayalım.
    b.FileInputStream objesi oluşturup, parametre olarak dosya yolunu girelim.
    c.Workbook objesi oluşturalım, parametre olarak fileInputStream objesini girelim.
    d.Sheet objesi oluşturalım.
    e.Row objesi oluşturalım.
    f.Cell objesi oluşturalım
    g.3.Index'deki satırın 2.Index'indeki datanın Norveç olduğunu test edelim.
    */

    @Test
    public void readExcelTest() throws IOException {
        String excel = "src/resources/takimlar.xlsx";
        FileInputStream fis = new FileInputStream(excel);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(3);
        Cell cell = row.getCell(2);
        String expectedData = "Norvec";
        String actulData = cell.toString();
        Assert.assertEquals(expectedData,actulData);
        System.out.println("actulData = " + actulData);
    }
}
