package tests.day21_reusableMethod_HtmlReports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.io.File;
import java.io.IOException;

public class C03_PozitifLoginTestTestiRapor extends TestBaseRapor {


    HotelMyCampPage hotel = new HotelMyCampPage();

    @Test
    public void testPozitif() throws InterruptedException, IOException {

        extentTest=extentReports.createTest("Pozitif Test","Gecereli username ve pass ile giris yapildi");

        //    1 ) Bir Class olustur //: Posi tiveTest
        //    2) Bir test method olustur positiveLoginTest()
        //    https://www.hotelmycamp.com/
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));
        extentTest.info("HotelMyCamp anasayfaya gidildi");

        //    login butonuna bas

        hotel.ilkLoginButonu.click();
        extentTest.info("Login buttonuna tiklandi.");


        //    test data username:
        //    manager
        hotel.username.sendKeys(ConfigReader.getProperty("hotelValidUserName"));
        extentTest.info("Gecerli username yazildi");

        //    test data password :
        //    Manager 1
       hotel.password.sendKeys(ConfigReader.getProperty("hotelWalidPassword"));
        //hotel.password.sendKeys(ConfigReader.getProperty("hotelWrongPassword"));
        extentTest.info("Gecerli pass yazildi");

        Thread.sleep(1000);

        //giris yapi
        hotel.ikinciLoginButonu.click();
        extentTest.info("Login buttonuna basildi");

        //    Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        Assert.assertTrue(hotel.girisTest.isDisplayed());
        extentTest.pass("Kullanici basarili sekilde giris yapti");


        WebElement sonucYaziElementi=hotel.girisTest;

        File sonucYaziElementiSS=new File("target/ekranGoruntuleri/sonucYazisiSS.jpeg");

        File temp = sonucYaziElementi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp,sonucYaziElementiSS);
        Driver.closeDriver();
    }
}
