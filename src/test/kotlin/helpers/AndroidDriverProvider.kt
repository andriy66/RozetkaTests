package utils

import com.codeborne.selenide.WebDriverProvider
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import io.appium.java_client.remote.AutomationName
import org.openqa.selenium.WebDriver
import org.openqa.selenium.Capabilities
import utils.Properties.Companion.DEVICE_NAME
import utils.Properties.Companion.PATH
import utils.Properties.Companion.PLATFORM_NAME
import utils.Properties.Companion.PLATFORM_VERSION
import utils.Properties.Companion.URL

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
        return AndroidDriver(URL, options)
    }
}