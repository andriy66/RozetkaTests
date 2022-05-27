package screens

import helpers.BaseScreen
import io.qameta.allure.Step
import popups.CartItemMenuPopUp

open class CartScreen : BaseScreen() {
    val monitor = findById("item_cart_offer_tv_title")
    val buyButton = findById("cart_fab_checkout")
    private val itemMenu = findById("item_cart_offer_iv_menu")
    private val cart = findById("empty_base_tv_title")
    private val productButton = findById("item_cart_offer_cl_offer")
    private val plusButton = findById("view_number_picker_iv_plus")
    private val wishListButton = findById("graph_wishlists")

    @Step("Open Item Menu")
    fun openItemMenu(): CartItemMenuPopUp {
        itemMenu.click()

        return CartItemMenuPopUp()
    }

    fun emptyCart(): Boolean {
        return cart.text == "Кошик порожній"
    }

    @Step("But product")
    fun clickBuyButton(): OrderingScreen {
        buyButton.click()

        return OrderingScreen()
    }

    @Step("Open product description")
    fun openProductDescription(): ProductDescriptionScreen {
        productButton.click()

        return ProductDescriptionScreen()
    }

    @Step("Click plus button")
    fun clickPlusButton() {
        plusButton.click()
    }

    @Step("Open Wish List")
    fun openWishLists(): ListOfWishListsScreen {
        wishListButton.click()

        return ListOfWishListsScreen()
    }
}