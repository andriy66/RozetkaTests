package screens

import com.codeborne.selenide.Condition
import helpers.BaseScreen
import io.qameta.allure.Step

class HomeScreen : BaseScreen() {
    private val searchField = findById("view_search_tv")
    private val yetButton = findById("graph_more")
    private val wishListButton = findById("graph_wishlists")
    private val cartButton = findById("graph_cart")
    private val catalogButton = findById("graph_fatMenu")
    private val homeButton = findById("graph_home")
    private val watchedScreen = findById("main_carousel_tv_recent_all")

    @Step("Fill data in field 'Search'")
    fun findProduct(text: String): ListOfProductsScreen {
        searchField.click()
        val presentSearchItem = findElementByText(text).shouldBe(Condition.visible)
        if (!presentSearchItem.isDisplayed) {
            throw Exception("The product isn`t in list")
        }
        presentSearchItem.click()

        return ListOfProductsScreen()
    }

    @Step("Open 'Yet' button")
    fun openYet(): YetScreen {
        yetButton.click()

        return YetScreen()
    }

    @Step("Open 'Cart' button")
    fun openCart(): CartScreen {
        cartButton.click()

        return CartScreen()
    }

    @Step("Open 'Home' button")
    fun openHome(): HomeScreen {
        homeButton.click()

        return this
    }

    @Step("Open 'Catalog' button")
    fun openCatalog(): CatalogScreen {
        catalogButton.click()

        return CatalogScreen()
    }

    @Step("Open Watch Screen")
    fun openWatchScreen(): WatchedScreen {
        watchedScreen.click()

        return WatchedScreen()
    }
}