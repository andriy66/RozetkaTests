package tests

import io.qameta.allure.Description
import org.testng.annotations.Test
import screens.HomeScreen
import helpers.BaseTest
import helpers.Properties
import org.testng.Assert.assertEquals

class Tests : BaseTest() {
    @Test
    @Description("Verify that you can log in with valid data")
    fun verifyThatCantLogInWithValidDataAndCanLogInWithValid() {
        val homeScreen = HomeScreen()
        val yetScreen = homeScreen.openYet()

        //Check that Yet Screen components are displayed
        softAssert.assertEquals(yetScreen.rozetkaLogoImage.isDisplayed, true, "The 'Rozetka Logo' image isn`t displayed")
        assertEquals(yetScreen.signInButton.isDisplayed, true, "The 'Sign In' button isn`t displayed")

        val authorizeScreen = yetScreen.clickSignIn()

        val validEmail = Properties.getProperty("email")
        val validPassword = Properties.getProperty("password")

        val authorizeProfile = authorizeScreen
                .authorize(validEmail, validPassword)

        //Check that the user login
        softAssert.assertEquals(authorizeProfile.rozetkaLogoIcon.isDisplayed, true, "The 'Rozetka Logo' icon is displayed")
        assertEquals(authorizeProfile.getProfileOwnerName(),"Лютак Андрій", "Invalid login")
    }
}