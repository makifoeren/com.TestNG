package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C06_SoftAssert extends TestBase {

    /*
    Softassertion baslangic ve bitis satirlari arasindaki tum assertions lari yapip
    bitis satiri geldiginde bize buldugu tum hatalari rapor eder
     */


    @Test
    public void test01() {

        // softassert baslangici obje olusturmaktir
        SoftAssert softAssert = new SoftAssert();


        // 1- amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // 2- title'in Amazon icerdigini test edin
        String expectedTitle = "amazon";
        String actualTitle = driver.getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"titel amazon icermiyor");

        // 3- Arama kutusunun erisilebilir oldugunu test edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled(),"arama kutusuna erisilemiyor");

        // 4- arama kutusuna nutella yazip aratin
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // 5- arama yapildigini test edin
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYaziElementi.isDisplayed(),"arama yapilamadi");

        // 6- arama sonucunun Nutella icerdigini test edin
        softAssert.assertTrue(sonucYaziElementi.getText().contains("Kutella"),"sonuc yazisi Kutella icermiyor");

        // Assertleri softAssert obj ile degistirdik
        //softassert'e bitis satirini soylemek icin assertAll() kullanilir
        //bu satir yazilmazsa assertion gorevi yapilmamis olur
        softAssert.assertAll();

        /*
        test edin denirse  assert
        verifications softassert

        Softassert'un hata bulsa bile calismaya devam etme ozelligi
        assertAll()'a kadardir.
        Eger assertAll()'da failed rapor edilirse calisma durur
        ve class'in kalan kismi calistirilmaz
        (Yani assertAll hardAsserdeki her bir assert gibidir, hatayi yakalarsa calisma durur)
         */

        System.out.println("assertion'lardan fail olan olursa, burasi calismaz");
    }
}
