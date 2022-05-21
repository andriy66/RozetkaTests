package screens

import com.codeborne.selenide.Condition
import helpers.BaseScreen
import io.qameta.allure.Step

class OrderingScreen : BaseScreen() {
    private val getBackButton = findByXpath("//*[@content-desc='Перейти вгору']")
    private val orderLayout = findById("checkout_order_item_tv_order_number")
    private val customerName = findById("checkout_order_item_tv_recipient")
    val priceLayout = findById("view_price_tv_price")

    fun isCustomerNameDisplayed(name: String): Boolean {
        orderLayout.shouldBe(Condition.visible)
        scroll()
        if (customerName.text == name) {
            return true
        }

        return false
    }

    @Step("Get back")
    fun getBack(): CartScreen {
        getBackButton.click()

        return CartScreen()
    }
}