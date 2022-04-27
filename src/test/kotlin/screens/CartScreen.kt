package screens

import com.codeborne.selenide.SelenideElement
import helpers.BaseScreen
import io.qameta.allure.Step
import popups.CartItemMenuPopUp

open class CartScreen : BaseScreen() {
    @Step("Get Monitor from the cart")
    fun getMonitorFromCart(): SelenideElement {
        val monitor = findById("item_cart_offer_tv_title")

        return monitor
    }

    @Step("Open Item Menu")
    fun openItemMenu(): CartItemMenuPopUp {
        val itemMenu = findById("item_cart_offer_iv_menu")
        itemMenu.click()

        return CartItemMenuPopUp()
    }

    fun emptyCart(): Boolean {
        val cart = findById("empty_base_tv_title")
        if (cart.text == "Кошик порожній") {
            return true
        }
        return false
    }
}