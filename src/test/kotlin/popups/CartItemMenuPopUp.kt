package popups

import helpers.BaseScreen
import io.qameta.allure.Step
import screens.CartScreen

class CartItemMenuPopUp : BaseScreen() {
    val removeFromCart = findElementByText("Видалити з кошика")

    @Step("Click Remove From Cart")
    fun clickRemoveFromCart(): CartScreen {
        removeFromCart.click()

        return CartScreen()
    }
}