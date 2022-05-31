package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SauceDemoPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Collections;

public class Q3_SoftAssert {

    /*
     * Navigate to  https://www.saucedemo.com/
     * Enter the user name  as standard_user
     * Enter the password as   secret_sauce
     * Click on login button
     *     T1 : Choose price low to high with soft Assert
     *     T2 : Verify item prices are sorted from low to high with hard Assert
     */




    // Verify item prices are sorted from low to high with hard Assert


    @Test
    public void sauceDemoSoft() {

        Driver.getDriver().get(ConfigReader.getProperty("saucedemoUrl"));

        SauceDemoPage sdmp=new SauceDemoPage();

        sdmp.username.sendKeys("standard_user");
        sdmp.password.sendKeys("secret_sauce");
        sdmp.login.click();

        Select select =new Select(sdmp.dropDown);
        select.selectByVisibleText("Price (low to high)");

        String expected = "PRICE (LOW TO HIGH)";
        String actual = select.getFirstSelectedOption().getText();
        String actual2 = Driver.getDriver().findElement(By.className("active_option")).getText();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actual,expected);
        softAssert.assertEquals(actual2,expected);

        softAssert.assertAll();

    }

    @Test
    public void sauceDemoHard() {

        Driver.getDriver().get(ConfigReader.getProperty("saucedemoUrl"));

        SauceDemoPage sdmp=new SauceDemoPage();

        sdmp.username.sendKeys("standard_user");
        sdmp.password.sendKeys("secret_sauce");
        sdmp.login.click();


        Select select =new Select(sdmp.dropDown);
        select.selectByIndex(2);

        ArrayList<Double> urunlerDouble=new ArrayList<>();

        for (WebElement each: sdmp.urunler) {
            String fiyatStr=each.getText().replaceAll("\\$","");
            //String fiyatStr = each.getText().replaceAll("^\\D", "");
            urunlerDouble.add(Double.parseDouble(fiyatStr));

        }
        ArrayList<Double> kontrolList=new ArrayList<>(urunlerDouble);

        Collections.sort(kontrolList);

        Assert.assertEquals(kontrolList,urunlerDouble);

        Driver.closeDriver();
     }


}
