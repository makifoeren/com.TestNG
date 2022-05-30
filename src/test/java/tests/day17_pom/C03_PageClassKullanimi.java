package tests.day17_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C03_PageClassKullanimi {

    @Test
    public void test01() throws InterruptedException {

        FacebookPage facebookPage = new FacebookPage();

        //facebook anasayfaya gidin

        Driver.getDriver().get("https://www.facebook.com");

        facebookPage.cookieButonu.click();

        // kullanici mail kutusuna rast gele bir isim yazdirin
        Faker faker = new Faker();
        facebookPage.mailKutusu.sendKeys(faker.internet().emailAddress());


        //kullanici sifre j´kutusna rast gele bir psss yazdirin
        facebookPage.sifreKutusu.sendKeys(faker.internet().password());

        // login butonuna basin giris yapilmadigini test edin
        facebookPage.loginTusu.click();

        //girilemedigini test edin
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());
        Thread.sleep(1000);
        Driver.closeDriver();

    }
}
