package tests

import io.qameta.allure.Description
import org.testng.Assert
import org.testng.annotations.Test
import helpers.Properties
import helpers.BaseTest
import screens.HomeScreen

class Tests : BaseTest() {
    @Description("Verify that you can log in with valid data")
    fun verifyThatCantLogInWithValidDataAndCanLogInWithValid() {
        val homeScreen = HomeScreen()
        val yetScreen = homeScreen.openYet()

        //Check that Yet Screen components are displayed
        softAssert.assertEquals(
            yetScreen.rozetkaLogoImage.isDisplayed,
            true,
            "The 'Rozetka Logo' image isn`t displayed"
        )
        Assert.assertEquals(yetScreen.signInButton.isDisplayed, true, "The 'Sign In' button isn`t displayed")

        val authorizeScreen = yetScreen.openAuthorizeScreen()

        val validEmail = Properties.getProperty("email")
        val validPassword = Properties.getProperty("password")

        val authorizeProfile = authorizeScreen
            .authorize(validEmail, validPassword)

        //Check that the user login
        softAssert.assertEquals(
            authorizeProfile.rozetkaLogoIcon.isDisplayed,
            true,
            "The 'Rozetka Logo' icon is displayed"
        )
        Assert.assertEquals(authorizeProfile.getProfileOwnerName(), "Лютак Андрій", "Invalid login")
    }
}