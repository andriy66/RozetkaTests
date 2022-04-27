package screens

import helpers.BaseScreen

class MainScreen : BaseScreen() {
    val search = findById("view_search_tv")
    val yet = findById("graph_more")
    val wishList = findById("graph_wishlists")
    val cart = findById("graph_cart")
    val catalog = findById("graph_fatMenu")

    fun clickSearch() {
        search.click()
    }

    fun clickYet() {
        yet.click()
    }

    fun clickWishList() {
        wishList.click()
    }

    fun clickCart() {
        cart.click()
    }

    fun clickCatalog() {
        catalog.click()
    }
}