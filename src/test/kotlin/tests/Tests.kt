package tests

import io.qameta.allure.Description
import org.testng.Assert
import helpers.Properties
import helpers.BaseTest
import screens.HomeScreen

class Tests : BaseTest() {
    @Description("Verify that you can log in with valid data")
    fun verifyThatCantLogInWithValidDataAndCanLogInWithValid() {
        val yetScreen = HomeScreen().openYet()

        //Check that Yet Screen components are displayed
        softAssert.assertTrue(yetScreen.rozetkaLogoImage.isDisplayed, "The 'Rozetka Logo' image isn`t displayed")
        Assert.assertTrue(yetScreen.signInButton.isDisplayed, "The 'Sign In' button isn`t displayed")

        //Get valid data
        val authorizeScreen = yetScreen.openAuthorizeScreen()
        val validEmail = Properties.getProperty("email")
        val validPassword = Properties.getProperty("password")

        //Authorize and check that the user login
        val authorizeProfile = authorizeScreen
            .authorize(validEmail, validPassword)
        softAssert.assertTrue(authorizeProfile.rozetkaLogoIcon.isDisplayed, "The 'Rozetka Logo' icon is displayed")
        Assert.assertEquals(authorizeProfile.profileOwnerNameButton.text, "Лютак Андрій", "Invalid login")
    }
}