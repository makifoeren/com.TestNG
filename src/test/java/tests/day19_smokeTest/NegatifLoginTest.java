package tests.day19_smokeTest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.File;
import java.io.IOException;

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



    }

    @Test
    public void yanlisKullanici() {

        BrcPage brc = new BrcPage();

        // Bir test method olustur positiveLoginTest()
        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //   login butonuna bas
        brc.ilkLoginButonu.click();

        //test data user email: customer@bluerentalcars.com ,
        brc.eMailTextBox.sendKeys(ConfigReader.getProperty("brcWrongUsername"));

        //test data password : 54321
        brc.passwortTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));

        //login butonuna tiklayin
        brc.ikinciLoginButonu.click();

        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et

        Assert.assertTrue(brc.ikinciLoginButonu.isDisplayed());

        Driver.closeDriver();



    }

    @Test
    public void yanlisKullaniciVeSifre() throws IOException {

        BrcPage brc = new BrcPage();

        // Bir test method olustur positiveLoginTest()
        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //   login butonuna bas
        brc.ilkLoginButonu.click();

        //test data user email: customer@bluerentalcars.com ,
        brc.eMailTextBox.sendKeys(ConfigReader.getProperty("brcWrongUsername"));

        //test data password : 54321
        brc.passwortTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));

        //login butonuna tiklayin
        brc.ikinciLoginButonu.click();

        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et

        Assert.assertTrue(brc.ikinciLoginButonu.isDisplayed());

        WebElement sonucYazisi=brc.ikinciLoginButonu;
        File sonucYazisiSS=new File("target/ekranGoruntuleri/sonucYazisiSS.jpeg");
        File temp=sonucYazisi.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(temp,sonucYazisiSS);

        Driver.closeDriver();


    }
}
