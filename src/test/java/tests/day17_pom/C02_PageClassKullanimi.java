package tests.day17_pom;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageClassKullanimi {


    @Test
    public void test01() {

        AmazonPage amazonPage = new AmazonPage();

        Driver.getDriver().get("https://www.amazon.com");

        // nutelle aratalim

        amazonPage.aramaKutusu.sendKeys("nutella" + Keys.ENTER);


        //sonuc yazisinin nutelle icerdigini test edelim

        String expectedSonuc="nutella";
        String actualSonuc= amazonPage.sonucsayisi.getText();

        Assert.assertTrue(actualSonuc.contains(expectedSonuc));


        Driver.closeDriver();

    }
}