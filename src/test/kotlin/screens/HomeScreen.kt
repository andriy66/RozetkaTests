package screens

import com.codeborne.selenide.Condition
import helpers.BaseScreenWithMenuComponents
import io.qameta.allure.Step

class HomeScreen : BaseScreenWithMenuComponents() {
    private val searchField = findById("view_search_tv")
    private val watchedScreen = findById("main_carousel_tv_recent_all")

    @Step("Fill data in field 'Search'")
    fun findProduct(text: String): ListOfProductsScreen {
        log.info("Fill data in field 'Search'")
        searchField.click()
        findElementByText(text).shouldBe(Condition.visible).click()

        return ListOfProductsScreen()
    }

    @Step("Open Watch Screen")
    fun openWatchScreen(): WatchedScreen {
        log.info("Open Watch Screen")
        watchedScreen.click()

        return WatchedScreen()
    }
}