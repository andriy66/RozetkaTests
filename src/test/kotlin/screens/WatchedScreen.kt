package screens

import com.codeborne.selenide.SelenideElement
import helpers.BaseScreen
import io.qameta.allure.Step
import popups.DeletingPopUp

class WatchedScreen: BaseScreen() {
    private val clear = findById("recent_b_clear")
    private val homeButton = findById("graph_home")
    val message = findById("empty_base_tv_title")
    val productName = findById("section_offer_tv_title")

    @Step("Clear Watched Data")
    fun clearWatchedData(): WatchedScreen {
        if(clear.isDisplayed){
            clear.click()
            DeletingPopUp().clickDelete()
        }

        return this
    }

    @Step("Open Home Screen")
    fun openHomeScreen(): HomeScreen {
        homeButton.click()

        return HomeScreen()
    }

    @Step("Get Product from Watched List")
    fun getProductFromWatchedList(productName: String): SelenideElement {
        val product = findElementByText(productName)

        return product
    }
}