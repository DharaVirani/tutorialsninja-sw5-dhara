package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.AccountRegisterPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class AccountRegisterPageTest extends BaseTest {

    HomePage homePage;
    AccountRegisterPage accountRegisterPage;
    MyAccountPage accountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        accountRegisterPage = new AccountRegisterPage();
        accountPage = new MyAccountPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        accountPage.clickOnMyQAccountTab();

       accountPage.selectMyAccountOptions("Register");

        Assert.assertEquals(accountRegisterPage.getRegisterAccountText(),
                "Register Account", "Register page not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        accountPage.clickOnMyQAccountTab();

        accountPage.selectMyAccountOptions("Register");

       accountRegisterPage.enterFirstName("Jignasha" );

       accountRegisterPage.enterLastName("Khan");

        accountRegisterPage.enterEmail("jignasha28khan@gmail.com");

        accountRegisterPage.enterTelephone("07988112233");

        accountRegisterPage.enterPassword("9081811670@Dv");

        accountRegisterPage.enterConfirmPassword("9081811670@Dv");

        accountRegisterPage.selectSubscription("Yes");

        accountRegisterPage.clickOnPrivacyPolicyCheckBox();

        accountRegisterPage.clickOnContinueButton();

        Assert.assertEquals(accountPage.getYourAccountHasBeenCreatedText(), "Your Account Has Been Created!",
                "Account not created");

        accountPage.clickOnContinueButton();

        Thread.sleep(2000);
        accountPage.clickOnMyQAccountTab();

        accountPage.selectMyAccountOptions("Logout");

        Assert.assertEquals(accountPage.getAccountLogoutText(), "Account Logout", "Not logged out");

        accountPage.clickOnContinueButton();
    }

}
