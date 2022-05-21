package screens

import helpers.BaseScreen
import io.qameta.allure.Step
import popups.CartItemMenuPopUp

open class CartScreen : BaseScreen() {
    val monitor = findById("item_cart_offer_tv_title")
    private val itemMenu = findById("item_cart_offer_iv_menu")
    private val cart = findById("empty_base_tv_title")
    private val buyButton = findById("cart_fab_checkout")

    @Step("Open Item Menu")
    fun openItemMenu(): CartItemMenuPopUp {
        itemMenu.click()

        return CartItemMenuPopUp()
    }

    fun emptyCart(): Boolean {
        if (cart.text == "Кошик порожній") {
            return true
        }
        return false
    }

    @Step("But product")
    fun clickBuyButton(): OrderingScreen {
        buyButton.click()

        return OrderingScreen()
    }
}