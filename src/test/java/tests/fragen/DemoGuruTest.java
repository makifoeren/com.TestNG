package tests.fragen;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoGuruPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.File;
import java.io.IOException;

public class DemoGuruTest {

    @Test
    public void test01() throws InterruptedException, IOException {

        DemoGuruPage demoGuruPage = new DemoGuruPage();

        //http://demo.guru99.com/test/drag_drop.html url e git

        Driver.getDriver().get(ConfigReader.getProperty("demoGuruUrl"));

        demoGuruPage.cookieButonu.click();

        //DEBIT SIDE da Account bolumune BANK butonunu surukle ve birak

        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(demoGuruPage.bankButonu, demoGuruPage.debitSideAccount).perform();
        Thread.sleep(2000);

        //    CREDIT SIDE da Account bolumune SALES butonunu surukle ve birak
        actions.dragAndDrop(demoGuruPage.saleButonu, demoGuruPage.creditSideAccount).perform();
        Thread.sleep(2000);

        //    DEBIT SIDE da Amount bolumune 5000 butonunu surukle ve birak
        actions.dragAndDrop(demoGuruPage.besbinButonu, demoGuruPage.debitSideAmount).perform();
        Thread.sleep(2000);

        //    CREDIT SIDE da Amount bolumune ise ikinci 5000  butonunu surukle ve birak
        actions.dragAndDrop(demoGuruPage.ikinciBesbinButonu, demoGuruPage.creditSideAmount).perform();
        Thread.sleep(2000);

        //    Perfect butonun goruntulendigini dogrulayin

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement sonucYaziElementi = demoGuruPage.perfectYazisi;

        File sonucYaziElementiSS = new File("target/ekranGoruntuleri/sonucYazisiSS.jpeg");
        File temp = sonucYaziElementi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp,sonucYaziElementiSS);

        //Assert.assertTrue(demoGuruPage.perfectYazisi.isDisplayed());
        Thread.sleep(2000);

        //Driver.closeDriver();

    }
}
