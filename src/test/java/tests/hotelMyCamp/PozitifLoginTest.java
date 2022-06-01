package tests.hotelMyCamp;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.File;
import java.io.IOException;

public class PozitifLoginTest {


    @Test
    public void testPozitif() throws InterruptedException, IOException {
        HotelMyCampPage hotel = new HotelMyCampPage();

        //    1 ) Bir Class olustur //: Posi tiveTest
        //    2) Bir test method olustur positiveLoginTest()
        //    https://www.hotelmycamp.com/
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));

        //    login butonuna bas

        hotel.ilkLoginButonu.click();


        //    test data username:
        //    manager
        hotel.username.sendKeys(ConfigReader.getProperty("hotelValidUserName"));

        //    test data password :
        //    Manager 1
        hotel.password.sendKeys(ConfigReader.getProperty("hotelPalidPassword"));

        Thread.sleep(1000);

        //giris yapi
        hotel.ikinciLoginButonu.click();

        //    Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        Assert.assertTrue(hotel.girisTest.isDisplayed());

        WebElement sonucYaziElementi=hotel.girisTest;

        File sonucYaziElementiSS=new File("target/ekranGoruntuleri/sonucYazisiSS.jpeg");

        File temp = sonucYaziElementi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp,sonucYaziElementiSS);
        Driver.closeDriver();
    }
}