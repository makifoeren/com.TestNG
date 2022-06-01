package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegatifLoginTest {

    @Test
    public void yanlisSifre() {
        BrcPage brc = new BrcPage();

        // Bir test method olustur positiveLoginTest()
        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //   login butonuna bas
        brc.ilkLoginButonu.click();

        //test data user email: customer@bluerentalcars.com ,
        brc.eMailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));

        //test data password : 54321
        brc.passwortTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));

        //login butonuna tiklayin
        brc.ikinciLoginButonu.click();

        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et

        Assert.assertTrue(brc.ikinciLoginButonu.isDisplayed());

        Driver.closeDriver();

        // bu clasta iki test methodu olusturun
        // yanlis kullanici
        //yanlis sifre ve kullanici adi

    }
}
