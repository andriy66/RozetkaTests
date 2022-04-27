package helpers

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.WebDriverRunner.closeWebDriver
import org.testng.annotations.*
import org.testng.asserts.SoftAssert

@Listeners(TestListener::class)
open class BaseTest {
    val softAssert = SoftAssert()

    @BeforeMethod
    fun setup() {
        Configuration.browserSize = null
        Configuration.browser = AndroidDriverProvider::class.java.name
        Configuration.screenshots = false
        Configuration.savePageSource = false
        open()
    }

    @AfterMethod
    fun closeDriver() {
        closeWebDriver()
    }

    @AfterClass
    fun tearDown() {
        softAssert.assertAll()
    }
}