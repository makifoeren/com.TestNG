package tests.day22_crossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C03_DataProvider {


    @Test
    public void test01() throws IOException {
        AmazonPage amazonPage = new AmazonPage();

        // amazon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // nutellayi arama yapin
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // sonuclarin nutella icerdigini test edelim
        String expectedKelime = "Nutella";
        String actualKelime = amazonPage.sonucsayisi.getText();

        Assert.assertTrue(actualKelime.contains(expectedKelime));

        ReusableMethods.getScreenshot("nutella");
        Driver.closeDriver();
    }

    @DataProvider
    public static Object[][] AranacakKelimeler() {

        Object[][] arananKelimearrayi = {{"Nutella"}, {"Java"}, {"cigdem"}, {"Netherlands"}};

        return arananKelimearrayi;
    }

    @Test(dataProvider = "AranacakKelimeler")

    //arayacagimiz kelimeleri bir liste gibi tutup
    //bana yollayacak bibr veri saglayicisi olusturcagiz

    public void dataproviderTest(String arananKelime) {
        AmazonPage amazonPage = new AmazonPage();

        // amazon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // nutellayi, java, cigdem ve Netherlands icin arama yapalim
        amazonPage.aramaKutusu.sendKeys(arananKelime + Keys.ENTER);

        // sonuclarin arama kelime icerdigini test edelim

        String expectedKelime = arananKelime;
        String actualKelime = amazonPage.sonucsayisi.getText();
        Assert.assertTrue(actualKelime.contains(expectedKelime));

        // sayfayi kapatalim

        Driver.closeDriver();

    }
}
