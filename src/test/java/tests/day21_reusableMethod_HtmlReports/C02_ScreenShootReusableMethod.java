package tests.day21_reusableMethod_HtmlReports;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C02_ScreenShootReusableMethod {


    @Test
    public void test01() throws IOException {

        // amazon a gidip foto cekelim

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        ReusableMethods.getScreenshot("amazon");


        Driver.closeDriver();

    }

}
