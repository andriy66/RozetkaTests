package screens

import helpers.BaseScreen
import io.qameta.allure.Step

class HomeScreen : BaseScreen() {
    val searchField = findById("view_search_tv")
    val yetButton = findById("graph_more")
    val wishListButton = findById("graph_wishlists")
    val cartButton = findById("graph_cart")
    val catalogButton = findById("graph_fatMenu")
    val homeButton = findById("graph_home")

    @Step("Click 'Search' button")
    fun clickSearch() {
        searchField.click()
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
}