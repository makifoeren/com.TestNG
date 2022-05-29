package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {


    public FacebookPage(){ // constroctor ve Driver clasindaki geet driveer ile eslstiriyoruz
        PageFactory.initElements(Driver.getDriver(),this); //Page clasindaki en onemili adim burasi
        // this le bunun esitliyoruz
        // cons icinde yapica parametresiz olan bu calisir ve bu clastaki Driver bu dur demek anlamina geliyor
        // initElements deger atamasini yapiyor
    }

    @FindBy(xpath="//input[@id='email']")
    public WebElement mailKutusu;

    @FindBy(xpath="//input[@id='pass']")
    public WebElement sifreKutusu;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement loginTusu;

    @FindBy(className = "_9ay7")
    public WebElement girilemediYaziElementi;

    @FindBy(xpath ="//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']")
    public WebElement cookieButonu;

}
