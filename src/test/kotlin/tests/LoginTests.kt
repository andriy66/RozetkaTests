package tests

import helpers.BaseTest
import helpers.Properties
import io.qameta.allure.Description
import org.testng.Assert
import org.testng.annotations.Test
import screens.HomeScreen

class LoginTests : BaseTest()  {
    @Test
    @Description("Verify that you can log in with valid data")
    fun verifyThatCantLogInWithValidDataAndCanLogInWithValid() {
        val yetScreen = HomeScreen().openYet()
        if(yetScreen.profileSettingsButton.isDisplayed){
                 yetScreen
                .openProfileSettings()
                .signOut()
        }

        //Check that Yet Screen components are displayed
        Assert.assertTrue(yetScreen.signInButton.isDisplayed, "The 'Sign In' button isn`t displayed")

        //Get valid data
        val validEmail = Properties.getProperty("email")
        val validPassword = Properties.getProperty("password")

        //Authorize and check that the user login
        val authorizeProfile = yetScreen.openAuthorizeScreen()
            .authorize(validEmail, validPassword)
        softAssert.assertTrue(authorizeProfile.rozetkaLogoIcon.isDisplayed, "The 'Rozetka Logo' icon is displayed")
        Assert.assertEquals(authorizeProfile.profileOwnerNameButton.text, "Лютак Андрій", "Invalid login")
    }
}