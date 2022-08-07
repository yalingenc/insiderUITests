package pages;
import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CareersPage extends TestBase {

    public CareersPage (){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20),this);
    }

    public String actualCareerPageVerification="Insider Careers";
    public String actualCareerPageLocationVerification = "Our Locations";
    public String actualLifeAtInsiderLocationVerification = "Life at Insider";

    public @FindBy(xpath = "//title[contains(text(),'Insider Careers')]")
    WebElement careerPageVerificationElement;

    public @FindBy(xpath = "//h3[contains(text(),'Our Locations')]")
    WebElement ourLocationVerificationElement;

    public @FindBy(xpath = "//h2[contains(text(),'Life at Insider')]")
    WebElement lifeAtInsiderVerificationElement;

    public @FindBy(xpath = "//a[contains(text(),'See all teams')]")
    WebElement careerPageSeeAllTeamsButton;

    public @FindBy(xpath = "//h3[contains(text(),'Quality Assurance')]")
    WebElement careerPageQualityAssuranceButton;

    public @FindBy(xpath = "//a[contains(text(),'See all QA jobs')]")
    WebElement careerPageSeeAllQAJobsButton;

    public String getPageTitleText(WebElement element){
        return driver.getTitle();
    }

    public void clickJS(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        js.executeScript("arguments[0].click();", element);
    }

    public String getElemetText(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

}
