package screens

import helpers.BaseScreen
import io.qameta.allure.Step

class ProductDescriptionScreen : BaseScreen() {
    val cartButton = findById("bottom_bar_iv_cart_image")

    @Step("Add to the Cart")
    fun addToCart(): CartScreen {
        scroll()
        cartButton.click()
        cartButton.click()

        return CartScreen()
    }


}