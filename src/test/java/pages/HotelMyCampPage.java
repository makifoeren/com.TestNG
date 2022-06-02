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

    @FindBy(xpath= "//*[text()='Hotel Management']")
    public WebElement hotelManegement;

    @FindBy(xpath= "(//i[@class='icon-calendar'])[3]")
    public WebElement hotelRooms;

    @FindBy(xpath= "//a[@class='btn btn-circle btn-default']")
    public WebElement addRooms;

    @FindBy(xpath= "(//select[@id='IDHotel'])")
    public WebElement hotelDropDown;

    @FindBy(xpath= "//input[@id='Code']")
    public WebElement code;

    @FindBy(xpath= "(//a[@class='label label-success'])[3]")
    public WebElement preis400;

    @FindBy(xpath= "//input[@title='Price']")
    public WebElement preis;

    @FindBy(xpath= "//select[@title='Select Room Type']")
    public WebElement roomDropDown;

    @FindBy(xpath= " //input[@name='MaxAdultCount']")
    public WebElement maxAdult;

    @FindBy(xpath= "//input[@id='IsAvailable']")
    public WebElement available;

    @FindBy(xpath= "//button[@id='btnSubmit']")
    public WebElement save;

    @FindBy(xpath= "//div[@class='bootbox-body']")
    public WebElement yazi;

    @FindBy(xpath= "//*[text()='OK']")
    public WebElement ok;

    @FindBy(xpath= "//*[text()='Hotel Management']")
    public WebElement hotelManegement2;

    @FindBy(xpath= "(//li//ul//li)[6]")
    public WebElement hotelRooms2;

    @FindBy(xpath= "(//*[text()='List Of Hotelrooms'])[2]")
    public WebElement listOfHotelRooms;

    @FindBy(xpath= "(//span[@class='title'])[1]")
    public WebElement systemManagement;



































}
