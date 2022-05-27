package screens

import helpers.BaseScreenWithMenuComponents
import io.qameta.allure.Step
import popups.WishListItemMenuPopUp

open class WishListScreen : BaseScreenWithMenuComponents() {
    val monitor = findById("section_offer_tv_title")
    val availableProducts = findById("wishlist_tv_count")
    private val getBackButton = findByXpath("//*[@content-desc='Перейти вгору']")
    private val message = findById("empty_base_tv_title")
    private val itemMenu = findById("item_wishlist_offer_fl_menu")
    private val buyAllButton = findById("wishlist_btn_buy_all")

    @Step("Open Item Menu")
    fun openItemMenu(): WishListItemMenuPopUp {
        itemMenu.click()

        return WishListItemMenuPopUp()
    }

    fun wishListIsEmpty(): Boolean {
        return message.text == "Цей список порожній"
    }

    @Step("Get Back to the product description")
    fun getBackToProductDescription(): ProductDescriptionScreen {
        getBackButton.click()

        return ProductDescriptionScreen()
    }

    @Step("Get Back to the Wish Lists")
    fun getBackToWishLists(): ListOfWishListsScreen {
        getBackButton.click()

        return ListOfWishListsScreen()
    }

    @Step("Click button 'Buy All'")
    fun clickBuyAll(): CartScreen {
        buyAllButton.click()

        return CartScreen()
    }

    fun productInWishListIsAdded(nameOfProduct: String): Boolean {
        val product = findElementByText(nameOfProduct)

        return product.isDisplayed
    }

}