package helpers

import io.qameta.allure.Step
import screens.*

open class BaseScreenWithMenuComponents : BaseScreen() {
    private val yetButton = findById("graph_more")
    private val wishListsButton = findById("graph_wishlists")
    private val cartButton = findById("graph_cart")
    private val catalogButton = findById("graph_fatMenu")
    private val homeButton = findById("graph_home")

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

        return HomeScreen()
    }

    @Step("Open 'Catalog' button")
    fun openCatalog(): CatalogScreen {
        catalogButton.click()

        return CatalogScreen()
    }

    @Step("Open Wish Lists")
    fun openWishLists(): ListOfWishListsScreen {
        wishListsButton.click()

        return ListOfWishListsScreen()
    }
}