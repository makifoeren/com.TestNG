package tests.day22_crossBrowser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegatifLoginDataProvider {
    BrcPage brc;

    @DataProvider
    public static Object[][] kullaniciListesi() {

        Object[][] kullaniciBilgileri={{"firuze@merhaba.com","12345"},
                {"murat@nokta.com","345678"},
                {"ilyas@hollanda.com","89273"}};

        return kullaniciBilgileri;
    }

    @Test(dataProvider = "kullaniciBilgiler")

    public void yanlisSifre(String userEmail, String password) {

       brc = new BrcPage();

        // Bir test method olustur positiveLoginTest()
        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //   login butonuna bas
        brc.ilkLoginButonu.click();

        //test data user email dataprovider den alalim
        brc.eMailTextBox.sendKeys(userEmail);

        //test data password dataprovider den alalim
        brc.passwortTextBox.sendKeys(password);

        //login butonuna tiklayin
        brc.ikinciLoginButonu.click();

        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et

        Assert.assertTrue(brc.ikinciLoginButonu.isDisplayed());

        Driver.closeDriver();


    }
}