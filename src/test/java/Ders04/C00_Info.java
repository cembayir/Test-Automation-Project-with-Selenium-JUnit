package Ders04;

public class C00_Info {

    /*
    - driver.switchTo() metodu ile kullanılabilecek üç farklı yapı vardır bunlar:
    1.Alerts
    2.IFrame
    3.Window Handles

    *Bir web sitesinin içinde farklı bir web sitesi olabilir (embedded).
    *IFrame genellikle bir web sayfasına döküman,video veya interaktif medya gibi başka bir kaynaktan içerik eklemek için kullanılır.
    *<iframe> tag'ı bir inline frame olduğunu belirtir.
    *iframe tag'ı bulunan web sayfalarında locate işlemi yapabilmek için iframe'i handle etmek gerekir.
    *Diğer bir deyişle,bir web sayfasında doğruluğundan emin olduğumuz bir locate işlemi varsa ancak bu düzgün çalışmıyorsa, sayfada iframe tag'ı bulunup
    bulunmadığını kontrol etmemiz gerekir. Bu durmumda, önce iframe'i locate edip switchTo() metodu ile geçiş yapmamız gerekir.

    - switchTo() metodu ile iframe'e geçmenin üç yolu vardır bunlar:
    1.Index ile:
        driver.switchTo().frame(index of the iframe);
    2.Id veya name value ile:
        driver.switchTo().frame("id of the iframe");
    3.WebElement ile:
        driver.switchTo().frame(WebElement of the iframe);

    - iframe'den çıkmanın iki yolu vardır bunlar:
    1.driver.switchTo().parentFrame(); // <-- Bir üst seviyedeki frame'e geçiş yapar.
    2.driver.switchTo().defaultContent(); // <-- En üst seviyedeki frame'e geçiş yapar.
     */
}
