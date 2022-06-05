package tests.day22_crossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseCross;

public class C01_AssertionsCross extends TestBaseCross {

    @Test
    public void test01() {


            // 1- amazon anasayfaya gidin
            driver.get("https://www.amazon.com");
            // 2- title'in Amazon icerdigini test edin
            String expectedTitle="Amazon";
            String actualTitle= driver.getTitle();
            Assert.assertTrue(actualTitle.contains(expectedTitle));
            // 3- Arama kutusunun erisilebilir oldugunu test edin
            WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
            Assert.assertTrue(aramaKutusu.isEnabled());
            // 4- arama kutusuna nutella yazip aratin
            aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
            // 5- arama yapildigini test edin
            WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
            Assert.assertTrue(sonucYaziElementi.isDisplayed());
            // 6- arama sonucunun Nutella icerdigini test edin
            Assert.assertTrue(sonucYaziElementi.getText().contains("Nutella"));

    }
}

/*
1. adim xml den class a geldik
2. adim beformethoda gelmek icin Testbasecross class ina  gittik burada driver olusturup degeri CrossDriver daki
getDriver dan yani buradan
3. adim olarak CrossDriver class ina gidiyoruz burada driver a geldik
browser parametre edge degeri buraya kadar geldi
burada browser degeri bulundu ve ona gore asagidaki edge degerini bulup acacak

daha sonra TestBAseCross a geri dondu degerleri atadi ve class a dondu
artik class ta drivere var ve o driver de islemleri yapip
aftermethodu calistircak
 */






















