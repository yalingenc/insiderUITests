package testCases;

import common.SetUp;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import util.TestUtil;

public class HomePageTests extends SetUp {

    HomePage homePage;
    public HomePageTests(){
        super();
    }

    @BeforeClass
    public void sourcePage(){
        homePage = new HomePage();
    }

    @Test(priority = 1)
    public void isHomePageOpened() {
        Assert.assertEquals(homePage.actualHomePageVerificationElement,homePage.getElemetText(homePage.homePageVerificationElement));
    }

    @Test(priority = 2)
    public void closeHomePagePopUps() {
        homePage.click(homePage.homePageAcceptCookiesPopUp);
    }

    @Test(priority = 3)
    public void clickMoreButton() {
        homePage.clickJS(homePage.homePageMoreButton);
    }

    @Test(priority = 4)
    public void clickCareersButton() {
        homePage.click(homePage.homePageCareersButton);
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
