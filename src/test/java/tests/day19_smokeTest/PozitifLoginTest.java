package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PozitifLoginTest {
    @Test
    public void pozitifLoginTest() {


        BrcPage brc = new BrcPage();

        // Bir test method olustur positiveLoginTest()
        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //   login butonuna bas
        brc.ilkLoginButonu.click();

        //test data user email: customer@bluerentalcars.com ,
        brc.eMailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));

        //test data password : 12345
        brc.passwortTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));

        //login butonuna tiklayin
        brc.ikinciLoginButonu.click();

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        String actualUsername = brc.kullaniciProfilIsmi.getText();
        String expectedUsername = ConfigReader.getProperty("brcValidUsername");

        Assert.assertEquals(actualUsername,expectedUsername);


        Driver.closeDriver();


    }
}
