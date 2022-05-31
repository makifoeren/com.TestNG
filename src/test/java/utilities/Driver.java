package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {


 /*
    POM de Driver icin TestBase class ina extends etmek yerine
    Driver classindan static methodlar kullanarak driver olusturup
    ilgili ayarlarin yapilmasi ve en sonda driver in kapatilmasi
    tercih edilmistir.
     */

    static WebDriver driver;

    public static WebDriver getDriver() { // void ten driver dondursun diye 1. daha sonra class
        // WebDriver yapip static ypiyoruuz ulasilsin diye


        if (driver==null) { //3. adim  ise bir dger atanmamis sa bu islemi yap, yoksa driver return et

            //18. gun nun sonu  configuration.properties e browser ekle
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;

                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

            }


           // WebDriverManager.chromedriver().setup();
            //driver = new ChromeDriver();  // herseferinde driver atiyor if ile bunu engellmis olduk
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;

    }

    public static void closeDriver() {

        if (driver!=null){ // driver e deger atanmissa kapat driever i kapat.
            driver.close();
            driver = null;//sonraki acmalarda soruun olmasin
//null degise kapat.  aciksa driver null degilse diye yazilir. bir deger atanmmaissa kapatamaz

        }
    }
}