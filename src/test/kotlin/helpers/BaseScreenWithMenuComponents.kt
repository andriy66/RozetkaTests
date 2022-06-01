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
        log.info("Open 'Yet' button")
        yetButton.click()

        return YetScreen()
    }

    @Step("Open 'Cart' button")
    fun openCart(): CartScreen {
        log.info("Open 'Cart' button")
        cartButton.click()

        return CartScreen()
    }

    @Step("Open 'Home' button")
    fun openHome(): HomeScreen {
        log.info("Open 'Home' button")
        homeButton.click()

        return HomeScreen()
    }

    @Step("Open 'Catalog' button")
    fun openCatalog(): CatalogScreen {
        log.info("Open 'Catalog' button")
        catalogButton.click()

        return CatalogScreen()
    }

    @Step("Open Wish Lists")
    fun openWishLists(): ListOfWishListsScreen {
        log.info("Open Wish Lists")
        wishListsButton.click()

        return ListOfWishListsScreen()
    }
}