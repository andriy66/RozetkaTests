package helpers

import com.codeborne.selenide.WebDriverProvider
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import io.appium.java_client.remote.AutomationName
import org.openqa.selenium.WebDriver
import org.openqa.selenium.Capabilities
import helpers.Properties.Companion.DEVICE_NAME
import helpers.Properties.Companion.PATH
import helpers.Properties.Companion.PLATFORM_NAME
import helpers.Properties.Companion.PLATFORM_VERSION
import helpers.Properties.Companion.URL

class AndroidDriverProvider : WebDriverProvider {
    override fun createDriver(capabilities: Capabilities): WebDriver {
        val options = UiAutomator2Options()
        options.merge(capabilities)
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2)
        options.setPlatformName(PLATFORM_NAME)
        options.setDeviceName(DEVICE_NAME)
        options.setPlatformVersion(PLATFORM_VERSION)
        options.setApp(PATH)
        options.setFullReset(false)
        options.noReset()
        return AndroidDriver(URL, options)
    }
}