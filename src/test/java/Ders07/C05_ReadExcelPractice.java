package Ders07;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_ReadExcelPractice {
    /*
    TASK
    ----
    a.Dosya yolunu bir string değişkene atayalım.
    b.FileInputStream objesi oluşturup, parametre olarak dosya yolunu girelim.
    c.Workbook objesi oluşturalım, parametre olarak fileInputStream objesini girelim.
    d.Sayfa 2'ye gidip satır sayısının 17, kullanılan satır sayısının ise 5 olduğunu test edin.
    */

    @Test
    public void Test() throws IOException {
        String excel = "src/resources/takimlar.xlsx";
        FileInputStream fis = new FileInputStream(excel);
        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatir = workbook.getSheet("Sayfa2").getLastRowNum();
        System.out.println("sonSatir = " + sonSatir);

        int expectedLastRow = 17;
        Assert.assertEquals(expectedLastRow, sonSatir + 1);

        int kullanilanSatirSayisi = workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        System.out.println("kullanilanSatirSayisi = " + kullanilanSatirSayisi);
        int expectedKullanilanSatirSayisi = 5;
        Assert.assertEquals(expectedKullanilanSatirSayisi, kullanilanSatirSayisi);
    }
}