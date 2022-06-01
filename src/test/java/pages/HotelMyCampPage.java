package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelMyCampPage {

    public HotelMyCampPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement ilkLoginButonu;

    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement password;

    @FindBy(id = "btnSubmit")
    public WebElement ikinciLoginButonu;

    @FindBy(xpath = "//span[@class='username username-hide-on-mobile']")
    public WebElement girisTest;

    @FindBy(xpath= "//*[text()='Try again please']")
    public WebElement basarisizGirisTest;







}
