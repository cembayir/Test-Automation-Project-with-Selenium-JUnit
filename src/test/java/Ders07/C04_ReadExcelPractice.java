package Ders07;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_ReadExcelPractice {

    /*
    TASK
    ----
    a.Dosya yolunu bir string değişkene atayalım.
    b.FileInputStream objesi oluşturup, parametre olarak dosya yolunu girelim.
    c.Workbook objesi oluşturalım, parametre olarak fileInputStream objesini girelim.
    d.Takim A sütununu yazdıralım.
    */

    @Test
    public void Test() throws IOException {
        String excel = "src/resources/takimlar.xlsx";
        FileInputStream fis = new FileInputStream(excel);
        Workbook workbook = WorkbookFactory.create(fis);

        String takimA = "";
        for (int i=0;i<10;i++){
            takimA = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            System.out.println(takimA);
        }
    }
}
