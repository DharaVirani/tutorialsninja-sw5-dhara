package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.AccountLoginPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class AccountLoginPageTest extends BaseTest {

    HomePage homePage;
    AccountLoginPage accountLoginPage;
    MyAccountPage accountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        accountLoginPage = new AccountLoginPage();
        accountPage = new MyAccountPage();

    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        accountPage.clickOnMyQAccountTab();

        accountPage.selectMyAccountOptions("Login");

        Assert.assertEquals(accountLoginPage.getReturningCustomerText(),
                "Returning Customer", "Login page not displayed");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {

        accountPage.clickOnMyQAccountTab();

        accountPage.selectMyAccountOptions("Login");

        accountLoginPage.enterEmailAddress("jignaa28khan@gmail.com");

        accountLoginPage.enterPassword("9081811670@Dv");

        accountLoginPage.clickOnLoginButton();

        Thread.sleep(2000);
        accountPage.clickOnMyQAccountTab();

        Thread.sleep(2000);
        accountPage.selectMyAccountOptions("Logout");

        Assert.assertEquals(accountPage.getAccountLogoutText(), "Account Logout", "Not logged out");

        accountPage.clickOnContinueButton();
    }

}
