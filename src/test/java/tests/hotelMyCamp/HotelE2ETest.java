package tests.hotelMyCamp;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.security.Key;

public class HotelE2ETest {
    @Test
    public void roomCreateTest() throws InterruptedException {


        HotelMyCampPage hotelMy = new HotelMyCampPage();

        //   E2E Testing / C r eate R oom T est
        //  1. Tests packagenin altına class olusturun: D18_HotelRoomCreation
        //  2. Bir metod olusturun: RoomCreateTest()
        //  3. https://www.hotelmycamp.com adresine gidin.
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));

        hotelMy.ilkLoginButonu.click();

        //  4. Username textbox ve password metin kutularını locate edin ve aşağıdaki verileri girin.
        //  a. Username
        //  manager b. Password : Manager 1
        hotelMy.username.sendKeys(ConfigReader.getProperty("hotelValidUserName"));
        hotelMy.password.sendKeys(ConfigReader.getProperty("hotelPalidPassword"));


        //  5. Login butonuna tıklayın.
        hotelMy.ikinciLoginButonu.click();

        //  6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
        hotelMy.hotelManegement.click();
        hotelMy.hotelRooms.click();
        hotelMy.addRooms.click();
        Thread.sleep(1000);
        //  7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        WebElement ddm = hotelMy.hotelDropDown;
        Select select = new Select(ddm);
        select.selectByIndex(5);
        Thread.sleep(1000);
        Actions actions = new Actions(Driver.getDriver());
        actions.click(hotelMy.code).
                sendKeys("30163").sendKeys(Keys.TAB).
                sendKeys("Ahmet").sendKeys(Keys.TAB).
                sendKeys("Hamburg").sendKeys(Keys.TAB).
                sendKeys("03.06 saat 14.30 da girisi yapacagim.").sendKeys(Keys.TAB).
                dragAndDrop(hotelMy.preis400, hotelMy.preis).perform();
        Thread.sleep(1000);
        WebElement ddmroom = hotelMy.roomDropDown;
        Select selectroom = new Select(ddmroom);
        selectroom.selectByIndex(2);
        actions.click(hotelMy.maxAdult).sendKeys("2").sendKeys(Keys.TAB).
                sendKeys("3").sendKeys(Keys.TAB).perform();
        Thread.sleep(1000);
        hotelMy.available.click();
        Thread.sleep(1000);
        //  8. Save butonuna basin.
        hotelMy.save.click();
        Thread.sleep(1000);
        //  9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
        Assert.assertTrue(hotelMy.yazi.isDisplayed());
        //  10. OK butonuna tıklayın.
        hotelMy.ok.click();
        //  11. Hotel rooms linkine tıklayın.

        hotelMy.hotelManegement.click();
        hotelMy.hotelRooms.click();
        Thread.sleep(1000);
        //  12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın.
        Assert.assertTrue(hotelMy.listOfHotelRooms.isDisplayed());
        Driver.closeDriver();
    }
}