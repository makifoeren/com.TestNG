package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class InstagramPage {

    public InstagramPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy (xpath ="//button[@class='aOOlW  bIiDR  ']")
    public WebElement cookieGec;

    @FindBy (xpath ="//*[text()='Registrieren']")
    public WebElement yeniKayitButton;

    @FindBy (xpath ="(//input[@class='_2hvTZ pexuQ zyHYP'])[1]")
    public WebElement emailButtonu;



    @FindBy (xpath ="//input[@aria-label='Vollständiger Name']")
    public WebElement vullNameButton;



    @FindBy (xpath ="//input[@aria-label='Benutzername']")
    public WebElement benutzerNameButton;

    @FindBy (xpath ="//input[@aria-label='Passwort']")
    public WebElement passwortButton;

    @FindBy (xpath ="//*[text()='Weiter']")
    public WebElement weiterButton;




}
