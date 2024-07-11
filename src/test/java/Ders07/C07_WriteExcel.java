package Ders07;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C07_WriteExcel {

    /*
    TASK
    ----
    a.Dosya yolunu bir string değişkene atayalım.
    b.FileInputStream objesi oluşturup, parametre olarak dosya yolunu girelim.
    c.Workbook objesi oluşturalım, parametre olarak fileInputStream objesini girelim.
    d.5.Hücreye yeni bir cell oluşturalım.
    e.Oluşturduğumuz hücreye "PUAN" yazdıralım.
    f.2.Satır PUAN kolonuna 85 yazdıralım.
    g.10.Satır PUAN kolonuna 72 yazdıralım.
    h.Dosyayı kaydedelim.
    i.Dosyayı kapatalım.
    */

    @Test
    public void Test() throws IOException {
        String excel = "src/resources/takimlar.xlsx";
        FileInputStream fis = new FileInputStream(excel);
        Workbook workbook = WorkbookFactory.create(fis);

        workbook.getSheet("sayfa1").getRow(0).createCell(4).setCellValue("PUAN");
        workbook.getSheet("sayfa1").getRow(1).createCell(4).setCellValue("85");
        workbook.getSheet("sayfa1").getRow(9).createCell(4).setCellValue("72");
        FileOutputStream fileOutputStream = new FileOutputStream(excel);
        workbook.write(fileOutputStream);
        fis.close();
        fileOutputStream.close();
        workbook.close();
    }
}
