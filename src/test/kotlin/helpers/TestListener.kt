package helpers

import com.codeborne.selenide.WebDriverRunner
import io.appium.java_client.android.AndroidDriver
import io.qameta.allure.Attachment
import org.openqa.selenium.OutputType
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.testng.ITestContext
import org.testng.ITestListener
import org.testng.ITestResult
import java.util.*

class TestListener : ITestListener {
    private val log: Logger = LoggerFactory.getLogger("Listener")

    override fun onTestFailure(result: ITestResult) {
        log.warn("Test FAILED: ${result.name}")
        val driver = WebDriverRunner.driver().webDriver as AndroidDriver
        attachScreenshot(driver)
    }

    override fun onTestSkipped(result: ITestResult) {
        log.info("Test SKIPPED: ${result.name}")
    }

    override fun onTestFailedButWithinSuccessPercentage(iTestResult: ITestResult?) {}

    override fun onStart(iTestContext: ITestContext?) {
    }

    override fun onFinish(iTestContext: ITestContext?) {}

    override fun onTestStart(result: ITestResult) {
        log.info(
            "${result.instance.javaClass.simpleName}.${result.name} test case started"
        )
        println(result.instance.javaClass.name.lowercase(Locale.getDefault()))
    }

    override fun onTestSuccess(result: ITestResult) {
        log.info("Test PASSED: ${result.name}")
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    fun attachScreenshot(driver: AndroidDriver): ByteArray? {
        return driver.getScreenshotAs(OutputType.BYTES)
    }
}
