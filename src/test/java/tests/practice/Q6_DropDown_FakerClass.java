package tests.practice;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.InstagramPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

public class Q6_DropDown_FakerClass extends TestBase {


    //twitter a faker class kullanarak mail ile kayit olmaya calisiniz
    //actions class kullanmayin twitteri deneyen instagram i denesin


    @Test
    public void testTwitter() throws InterruptedException {

        InstagramPage instagram=new InstagramPage();

        Faker faker=new Faker();

        Driver.getDriver().get(ConfigReader.getProperty("instagramUrl"));

        instagram.cookieGec.click();

        instagram.yeniKayitButton.click();

        instagram.emailButtonu.sendKeys(faker.internet().emailAddress());
        instagram.vullNameButton.sendKeys(faker.name().fullName());
        instagram.benutzerNameButton.sendKeys(faker.name().firstName());
        instagram.passwortButton.sendKeys(faker.internet().password());
        instagram.weiterButton.click();

        Thread.sleep(2000);





    }
}
