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

public class NegatifLoginTest {

    @Test
    public void testNegatif() throws InterruptedException {

        HotelMyCampPage hotel = new HotelMyCampPage();

        //    1 ) Bir Class olustur //: Negativ
        //    2) Bir test method olustur NegativLoginTest()
        //    https://www.hotelmycamp.com/
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));

        //    login butonuna bas

        hotel.ilkLoginButonu.click();


        //    test data username:
        //    manager1
        hotel.username.sendKeys(ConfigReader.getProperty("hotelWrongUserName"));

        //    test data password :
        //    manager1!
        hotel.password.sendKeys(ConfigReader.getProperty("hotelWrongPassword"));

        Thread.sleep(1000);

        //giris yapi
        hotel.ikinciLoginButonu.click();

        //    Degerleri girildiginde sayfaya girilemedigini test et

        Assert.assertTrue(hotel.basarisizGirisTest.isDisplayed());

        Driver.closeDriver();

    }

    @Test
    public void testNegatifName() throws InterruptedException {

        HotelMyCampPage hotel = new HotelMyCampPage();

        //    1 ) Bir Class olustur //: Negativ
        //    2) Bir test method olustur NegativLoginTest()
        //    https://www.hotelmycamp.com/
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));

        //    login butonuna bas

        hotel.ilkLoginButonu.click();


        //    test data username:
        //    manager1
        hotel.username.sendKeys(ConfigReader.getProperty("hotelWrongUserName"));

        //    test data password :
        //    Manager1!
        hotel.password.sendKeys(ConfigReader.getProperty("hotelPalidPassword"));

        Thread.sleep(1000);

        //giris yapi
        hotel.ikinciLoginButonu.click();

        //    Degerleri girildiginde sayfaya girilemedigini test et

        Assert.assertTrue(hotel.basarisizGirisTest.isDisplayed());

        Driver.closeDriver();

    }


    @Test
    public void testNegatifPass() throws InterruptedException, IOException {

        HotelMyCampPage hotel = new HotelMyCampPage();

        //    1 ) Bir Class olustur //: Negativ
        //    2) Bir test method olustur NegativLoginTest()
        //    https://www.hotelmycamp.com/
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));

        //    login butonuna bas

        hotel.ilkLoginButonu.click();


        //    test data username:
        //    manager
        hotel.username.sendKeys(ConfigReader.getProperty("hotelValidUserName2"));

        //    test data password :
        //    manager 1
        hotel.password.sendKeys(ConfigReader.getProperty("hotelWrongPassword"));

        Thread.sleep(1000);

        //giris yapi
        hotel.ikinciLoginButonu.click();

        //    Degerleri girildiginde sayfaya girilemedigini test et

       // Assert.assertTrue(hotel.basarisizGirisTest.isDisplayed());

        WebElement sonucYaziElementi=hotel.basarisizGirisTest;

        File sonucYaziElementiSS=new File("target/ekranGoruntuleri/sonucYazisiSS.jpeg");

        File temp = sonucYaziElementi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp,sonucYaziElementiSS);
        Driver.closeDriver();


    }



}