package tests.day18_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigReaderKullanimi {


    @Test
    public void test01() {

        FacebookPage facebookPage = new FacebookPage();

        //facebook anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        //cikan coockies i kapatin
        facebookPage.cookieButonu.click();


        // kullanici mail kutusuna yanlis bir isim yazdirin

        facebookPage.mailKutusu.sendKeys(ConfigReader.getProperty("fbWrongUsername"));

        //kullanici sifre j´kutusna rast gele bir psss yazdirin
        facebookPage.sifreKutusu.sendKeys(ConfigReader.getProperty("fbWrongPassword"));

        // login butonuna basin giris yapilmadigini test edin
        facebookPage.loginTusu.click();


        //girilemedigini test edin
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());

        Driver.closeDriver();



    }
}