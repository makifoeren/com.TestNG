package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DemoGuruPage {


    public DemoGuruPage() {


        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "(//p[@class='fc-button-label'])[1]")
    public WebElement cookieButonu;

    @FindBy(xpath = "(//a[@class='button button-orange'])[5]")
    public WebElement bankButonu;

    @FindBy (xpath = "//ol[@id='bank']")
    public WebElement debitSideAccount;

    @FindBy (xpath = "(//a[@class='button button-orange'])[6]")
    public WebElement saleButonu;

    @FindBy (xpath = "(//li[@class='placeholder'])[2]")
    public WebElement creditSideAccount;

    @FindBy (xpath = "(//a[@class='button button-orange'])[2]")
    public WebElement besbinButonu;

    @FindBy (xpath = "(//li[@class='placeholder'])[1]")
    public WebElement debitSideAmount;

    @FindBy (xpath = "(//a[@class='button button-orange'])[4]")
    public WebElement ikinciBesbinButonu;

    @FindBy (xpath = "(//ol[@class='field13 ui-droppable ui-sortable'])[2]")
    public WebElement creditSideAmount;

    @FindBy(xpath = "(//a[@class='button button-green'])[1]")
    public WebElement perfectYazisi;







}
