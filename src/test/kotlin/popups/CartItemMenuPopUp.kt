package popups

import helpers.BaseScreen
import io.qameta.allure.Step
import screens.CartScreen

class CartItemMenuPopUp : BaseScreen() {
    private val removeFromCart = findElementByText("Видалити з кошика")

    @Step("Click Remove From Cart")
    fun removeFromCart(): CartScreen {
        log.info("Click Remove From Cart")
        removeFromCart.click()

        return CartScreen()
    }
}