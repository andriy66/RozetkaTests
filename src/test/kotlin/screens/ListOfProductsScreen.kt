package screens

import helpers.BaseScreen
import io.qameta.allure.Step
import popups.SortPopUp

open class ListOfProductsScreen : BaseScreen() {
    private val wishListScreen = findById("graph_wishlists")
    private val yetScreen = findById("graph_more")
    private val homeButton = findById("graph_home")
    val filterButton = findById("section_ll_filter")
    val sortButton = findById("section_ll_sort")

    @Step("Open Product Description")
    fun openProductDescription(productName: String): ProductDescriptionScreen {
        val product = findElementByText(productName)
        product.click()

        return ProductDescriptionScreen()
    }

    @Step("Get product price")
    fun getProductPrice(text: String): Int {
        val productDescription = openProductDescription(text)
        val price = productDescription.getPrice().filter { !it.isWhitespace() }
        productDescription.getBack()

        return price.toInt()
    }

    @Step("Open Wish List")
    fun openWishLists(): ListOfWishListsScreen {
        wishListScreen.click()

        return ListOfWishListsScreen()
    }

    @Step("Open Yet Screen")
    fun openYet(): YetScreen {
        yetScreen.click()

        return YetScreen()
    }

    @Step("Open Sort Pop Up")
    fun openSortPopUp(): SortPopUp {
        sortButton.click()

        return SortPopUp()
    }

    @Step("Open Home Screen")
    fun openHomeScreen(): HomeScreen {
        homeButton.click()

        return HomeScreen()
    }
}