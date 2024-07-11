package Ders07;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C06_ReadExcelPractice {
    /*
    TASK
    ----
    a.Dosya yolunu bir string değişkene atayalım.
    b.FileInputStream objesi oluşturup, parametre olarak dosya yolunu girelim.
    c.Workbook objesi oluşturalım, parametre olarak fileInputStream objesini girelim.
    d.Excel tablosundaki tüm tabloyu konsola yazdıralım.
    */

    @Test
    public void Test() throws IOException {
        String excel = "src/resources/takimlar.xlsx";
        FileInputStream fis = new FileInputStream(excel);
        Workbook workbook = WorkbookFactory.create(fis);

        String tablo = "";
        for (int i = 0; i < 10; i++) {
            tablo = workbook.getSheet("sayfa1").getRow(i).getCell(0).toString() + " " +
                    workbook.getSheet("sayfa1").getRow(i).getCell(1).toString() + " " +
                    workbook.getSheet("sayfa1").getRow(i).getCell(2).toString() + " " +
                    workbook.getSheet("sayfa1").getRow(i).getCell(3).toString();
            System.out.println(tablo);
        }
    }
}