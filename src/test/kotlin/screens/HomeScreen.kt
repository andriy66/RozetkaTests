package screens

import helpers.BaseScreen
import io.qameta.allure.Step

class HomeScreen : BaseScreen() {
    private val searchField = findById("view_search_tv")
    private val yetButton = findById("graph_more")
    private val wishListButton = findById("graph_wishlists")
    private val cartButton = findById("graph_cart")
    private val catalogButton = findById("graph_fatMenu")
    private val homeButton = findById("graph_home")

    @Step("Fill data in field 'Search'")
    fun findProduct(text: String): ListOfProductsScreen {
        searchField.click()
        val presentSearchItem = findElementByText(text)
        presentSearchItem.click()

        return ListOfProductsScreen()
    }

    @Step("Open 'Yet' button")
    fun openYet(): YetScreen {
        yetButton.click()

        return YetScreen()
    }

    @Step("Open 'Wish List' button")
    fun openWishList() {
        wishListButton.click()
    }

    @Step("Open 'Cart' button")
    fun openCart() {
        cartButton.click()
    }

    @Step("Click 'Catalog' button")
    fun openCatalog(): CatalogScreen {
        catalogButton.click()
        return CatalogScreen()
    }

    @Step("Click 'Home' button")
    fun openHome() {
        homeButton.click()
    }

    @Step("Open Watch Screen")
    fun openWatchScreen(): WatchedScreen {
        val watchedScreen = findById("main_carousel_tv_recent_all")
        watchedScreen.click()

        return WatchedScreen()
    }
}