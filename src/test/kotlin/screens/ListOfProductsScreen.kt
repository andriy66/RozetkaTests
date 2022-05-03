package screens

import helpers.BaseScreen
import io.qameta.allure.Step
import popups.FilterPopUp
import popups.SortPopUp

open class ListOfProductsScreen : BaseScreen() {
    private val wishListScreen = findById("graph_wishlists")
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

    @Step("Open Filter Pop Up")
    fun openFilterPopUp(): FilterPopUp{
        filterButton.click()

        return FilterPopUp()
    }

    @Step("Open Sort Pop Up")
    fun openSortPopUp(): SortPopUp {
        sortButton.click()

        return SortPopUp()
    }
}