package testCases;

import common.SetUp;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CareersPage;
import pages.HomePage;
import util.TestUtil;

public class CareersPageTests extends SetUp {

    CareersPage careersPage;
    public CareersPageTests(){
        super();
    }

    @BeforeClass
    public void sourcePage(){
        careersPage = new CareersPage();
    }

    @Test(priority = 1)
    public void isCareerPageOpened() {
        Assert.assertEquals(careersPage.actualCareerPageVerification,careersPage.getPageTitleText(careersPage.careerPageVerificationElement));
    }

    @Test(priority = 2)
    public void isLocationAppear() {
        Assert.assertEquals(careersPage.actualCareerPageLocationVerification,careersPage.getElemetText(careersPage.ourLocationVerificationElement));
    }

    @Test(priority = 3)
    public void isLifeAtInsiderAppear() {
        Assert.assertEquals(careersPage.actualLifeAtInsiderLocationVerification,careersPage.getElemetText(careersPage.lifeAtInsiderVerificationElement));
    }

    @Test(priority = 4)
    public void clickSeeAllTeamsButton() {
        careersPage.clickJS(careersPage.careerPageSeeAllTeamsButton);
    }

    @Test(priority = 5)
    public void clicQualityAssuranceButton() {
        careersPage.clickJS(careersPage.careerPageQualityAssuranceButton);
    }

    @Test(priority = 6)
    public void clicSeeAllQAJobsButton() {
        careersPage.clickJS(careersPage.careerPageSeeAllQAJobsButton);
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
