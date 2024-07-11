package Ders07;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C08_DeleteExcel {

    /*
    TASK
    ----
    a.Dosya yolunu bir string değişkene atayalım.
    b.FileInputStream objesi oluşturup, parametre olarak dosya yolunu girelim.
    c.Workbook objesi oluşturalım, parametre olarak fileInputStream objesini girelim.
    d.Sheet objesi oluşturalım.
    e.Row objesi oluşturalım.
    f.Cell objesi oluşturalım
    g.3.Satır 3.Cell'de bulunan veriyi silelim.
    */

    @Test
    public void Test() throws IOException {
        String excel = "src/resources/takimlar.xlsx";
        FileInputStream fis = new FileInputStream(excel);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(2);
        Cell cell = row.getCell(2);
        row.removeCell(cell);

        FileOutputStream fileOutputStream = new FileOutputStream(excel);
        workbook.write(fileOutputStream);
    }
}