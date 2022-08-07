package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.OpenPositionsPage;
import util.TestUtil;

public class OpenPositionsTest {

    OpenPositionsPage openPositionsPage;
    public OpenPositionsTest(){
        super();
    }

    @BeforeClass
    public void sourcePage(){
        openPositionsPage = new OpenPositionsPage();
    }

    @Test(priority = 1)
    public void isOpenPositionsOpened() {
        Assert.assertEquals(openPositionsPage.isPageTitleDisplayed(),openPositionsPage.actualOpenPositionPageTitle);
    }

    @Test(priority = 2)
    public void clickLocationCombobox() {
        openPositionsPage.click(openPositionsPage.openPositionsPageFilterByLocationsCombobox);
    }

    @Test(priority = 3)
    public void locationComboboxIstanbulSelection() {
        openPositionsPage.click(openPositionsPage.filterByLocationsIstanbulTurkeySelection);
    }

    @Test(priority = 4)
    public void verificationJobDepartments() {
        openPositionsPage.verifyJobDepartments();
    }

    @Test(priority = 5)
    public void verificationJobLocations(){
        openPositionsPage.verifyJobLocations();
    }

    @Test(priority = 6)
    public void verificationApplyNowButton(){
        openPositionsPage.verifyApplyNowButton();
    }

    @Test(priority = 7)
    public void clickApplyNowButton(){
        openPositionsPage.clickApplyNowButtonAndVerifyLeverPage();
    }



    @AfterMethod
    public void ss(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TestUtil.takeScreenShot(result.getMethod().getMethodName());
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }

}
