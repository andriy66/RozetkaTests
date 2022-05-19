package helpers

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide.`$$`
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.WebDriverRunner.getWebDriver
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.By
import org.openqa.selenium.Dimension
import org.openqa.selenium.Point
import org.openqa.selenium.interactions.PointerInput
import org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT
import org.openqa.selenium.interactions.Sequence
import java.time.Duration

open class BaseScreen {
    val androidPrefix = "android:id/"

    fun findById(id: String, prefix: String = "ua.com.rozetka.shop:id/"): SelenideElement {
        return `$`(By.id(prefix + id))
    }

    fun findByXpath(xpath: String): SelenideElement {
        return `$`(By.xpath(xpath))
    }

    fun findByCssSelector(cssSelector: String): SelenideElement {
        return `$`(By.cssSelector(cssSelector))
    }

    fun findElementByText(text: String): SelenideElement {
        val element = findByXpath("//*[@text = '$text']")
        return element
    }

    fun findElementsByCssSelector(cssSelector: String): ElementsCollection {
        return `$$`(By.cssSelector(cssSelector))
    }

    fun scroll(dir: ScrollDirection = ScrollDirection.DOWN, times: Int = 1) {
        val driver = (getWebDriver() as AndroidDriver)
        val duration = 1000
        val finger = PointerInput(PointerInput.Kind.TOUCH, "finger")
        val dimension: Dimension = driver.manage().window().size
        var start = Point(0, 0)
        var end = Point(0, 0)
        for (i in 0 until times) {
            when (dir) {
                ScrollDirection.DOWN -> {
                    start = Point((dimension.width * 0.5).toInt(), (dimension.height * 0.9).toInt())
                    end = Point((dimension.width * 0.2).toInt(), (dimension.height * 0.1).toInt())
                }
                ScrollDirection.UP -> {
                    start = Point((dimension.width * 0.5).toInt(), (dimension.height * 0.2).toInt())
                    end = Point((dimension.width / 2), (dimension.height - 10))
                }
                ScrollDirection.LEFT -> {
                    start = Point((dimension.width - 10), (dimension.height / 2))
                    end = Point((dimension.width * 0.1).toInt(), (dimension.height / 2))
                }
                ScrollDirection.RIGHT -> {
                    start = Point((dimension.width * 0.1).toInt(), (dimension.height / 2))
                    end = Point((dimension.width - 10), (dimension.height / 2))
                }
            }
            val swipe = Sequence(finger, 1)
                .addAction(
                    finger.createPointerMove(
                        Duration.ofMillis(0),
                        PointerInput.Origin.viewport(), start.getX(), start.getY()
                    )
                )
                .addAction(finger.createPointerDown(LEFT.asArg()))
                .addAction(
                    finger.createPointerMove(
                        Duration.ofMillis(duration.toLong()),
                        PointerInput.Origin.viewport(), end.getX(), end.getY()
                    )
                )
                .addAction(finger.createPointerUp(LEFT.asArg()))
            driver.perform(listOf(swipe))
        }
    }
}

enum class ScrollDirection {
    UP, DOWN, LEFT, RIGHT
}