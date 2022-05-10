package screens

import helpers.BaseScreen
import io.qameta.allure.Step
import popups.CartItemMenuPopUp

open class CartScreen : BaseScreen() {
    val monitor = findById("item_cart_offer_tv_title")
    val itemMenu = findById("item_cart_offer_iv_menu")
    val cart = findById("empty_base_tv_title")

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
}