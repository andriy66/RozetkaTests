package screens

import com.codeborne.selenide.Condition
import helpers.BaseScreenWithMenuComponents
import io.qameta.allure.Step
import popups.CartItemMenuPopUp

open class CartScreen : BaseScreenWithMenuComponents() {
    val monitor = findById("item_cart_offer_tv_title")
    val buyButton = findById("cart_fab_checkout")
    val phoneNumber = findById("checkout_order_item_tv_recipient_phone")
    private val itemMenu = findById("item_cart_offer_iv_menu")
    private val cart = findById("empty_base_tv_title")
    private val productButton = findById("item_cart_offer_cl_offer")
    private val plusButton = findById("view_number_picker_iv_plus")
    private val orderPrice = findById("checkout_tv_cost")
    private val getBack = findByXpath("//*[@content-desc='Перейти вгору']")

    @Step("Open Item Menu")
    fun openItemMenu(): CartItemMenuPopUp {
        log.info("Open Item Menu")
        itemMenu.click()

        return CartItemMenuPopUp()
    }

    fun emptyCart(): Boolean {
        return cart.text == "Кошик порожній"
    }

    @Step("Buy product")
    fun clickBuyButton(): OrderingScreen {
        log.info("Buy product")
        buyButton.click()

        return OrderingScreen()
    }

    @Step("Open product description")
    fun openProductDescription(): ProductDescriptionScreen {
        log.info("Open product description")
        productButton.click()

        return ProductDescriptionScreen()
    }

    @Step("Click plus button")
    fun clickPlusButton() {
        log.info("Click plus button")
        plusButton.click()
    }

    @Step("Increase the counts of product buy two and get order price")
    fun clickPlusAndGetOrderPrice(): String {
        log.info("Increase the counts of product buy two and get order price")
        plusButton.click()
        scroll(times = 2)

        return orderPrice.text
    }

    @Step("Get order price")
    fun getOrderPrice(): String {
        log.info("Get order price")
        val orderLabel = findById("checkout_order_item_tv_order_number")
        orderLabel.shouldBe(Condition.visible)
        scroll()

        return orderPrice.text
    }

    @Step("Get back")
    fun getBack() {
        log.info("Get back")
        getBack.click()
    }
}