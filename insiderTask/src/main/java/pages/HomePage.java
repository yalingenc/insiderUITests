package pages;
import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends TestBase {

    public HomePage (){
        PageFactory.initElements(driver,this);
    }

    public String actualHomePageVerificationElement="Trusted by 1000+ brands from high-growth startups to enterprise brands";

    public @FindBy(css = "h4.head-light")
    WebElement homePageVerificationElement;

    public @FindBy(css = "i#icon-close-button-1454703945249")
    WebElement homePageDownloadReportPopUp;

    public @FindBy(css = "a#wt-cli-accept-all-btn")
    WebElement homePageAcceptCookiesPopUp;

    public @FindBy(xpath = "//*[@class='nav-link dropdown-toggle']/span[contains(text(),'More')]")
    WebElement homePageMoreButton;

    public @FindBy(className = "btn btn-warning btn-sm rounded align-self-start mb-5 mb-lg-0")
    WebElement homePageJoinOurTeamButton;

    public @FindBy(xpath = "//h5[contains(text(),'Careers')]")
    WebElement homePageCareersButton;

    public String getElemetText(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public void click(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void clickJS(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        js.executeScript("arguments[0].click();", element);

    }

}
