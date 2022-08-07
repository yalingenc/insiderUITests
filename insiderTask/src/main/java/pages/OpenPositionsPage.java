package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.security.Policy;
import java.util.ArrayList;
import java.util.List;

public class OpenPositionsPage extends TestBase {

    public OpenPositionsPage() { PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this); }

    public String actualOpenPositionPageTitle = "Insider open positions | Insider";
    public String actualDepartment ="Quality Assurance";
    public String actualLocations ="Istanbul, Turkey";
    public String actualApplyNowButton ="Apply Now";
    public @FindBy(xpath = "//*[@id=\"jobs-list\"]/div")
    List<WebElement> jobContents;
    public @FindBy(css = "span[aria-labelledby='select2-filter-by-location-container']")
    WebElement openPositionsPageFilterByLocationsCombobox;
    public @FindBy(xpath = "//title[contains(text(),'Insider open positions | Insider')]")
    WebElement openPositionsPageTitle;
    public @FindBy(css = "a.main-header-logo")
    WebElement leverPage;
    public @FindBy(xpath = "//li[contains(text(),'Istanbul, Turkey')]")
    WebElement filterByLocationsIstanbulTurkeySelection;


    public String isPageTitleDisplayed() {
        return (((JavascriptExecutor)driver).executeScript("return arguments[0].firstChild.textContent;", openPositionsPageTitle).toString());
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void verifyJobDepartments() {
        if (jobContents.size()!=0) {
            for (int i = 1; i <= jobContents.size(); i++) {
                WebElement department = driver.findElement(By.xpath("(//*[@class=\"position-department text-large font-weight-600 text-primary\"])[" + i + "]"));
                Assert.assertEquals(((JavascriptExecutor) driver).executeScript("return arguments[0].firstChild.textContent;", department).toString(), actualDepartment);
            }
        }else {
            System.out.println("There is no available Jobs");
            Assert.fail();
        }
    }

    public void verifyJobLocations() {
        if (jobContents.size()!=0) {
        for (int i = 1; i<=jobContents.size(); i++){
            WebElement locations = driver.findElement(By.xpath("(//*[@class=\"position-location text-large\"])["+i+"]"));
            Assert.assertEquals(((JavascriptExecutor)driver).executeScript("return arguments[0].firstChild.textContent;", locations).toString(),actualLocations);
        }
        }else {
            System.out.println("There is no available Jobs");
            Assert.fail();
        }
    }

    public void verifyApplyNowButton() {
        if (jobContents.size()!=0) {
        for (int i = 1; i<=jobContents.size(); i++){
            WebElement applyButton = driver.findElement(By.xpath("(//*[@class=\"btn btn-navy rounded pt-2 pr-5 pb-2 pl-5\"])["+i+"]"));
            Assert.assertEquals(((JavascriptExecutor)driver).executeScript("return arguments[0].firstChild.textContent;", applyButton).toString(),actualApplyNowButton);
        }
        }else {
            System.out.println("There is no available Jobs");
            Assert.fail();
        }
    }

    public void clickApplyNowButtonAndVerifyLeverPage() {
        if (jobContents.size()!=0) {
            for (int i = 1; i<=jobContents.size(); i++){
                WebElement applyButton = driver.findElement(By.xpath("(//*[@class=\"btn btn-navy rounded pt-2 pr-5 pb-2 pl-5\"])["+i+"]"));
                js.executeScript("arguments[0].click();", applyButton);
                ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
                driver.switchTo().window(tabs2.get(1));
                wait.until(ExpectedConditions.visibilityOf(leverPage));
                //Verify Lever Page
                Assert.assertTrue(leverPage.isDisplayed());
                driver.close();
                driver.switchTo().window(tabs2.get(0));
            }
        }else {
            System.out.println("There is no available Jobs");
            Assert.fail();
        }
    }
}
