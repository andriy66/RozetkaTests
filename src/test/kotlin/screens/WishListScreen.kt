package screens

import com.codeborne.selenide.SelenideElement
import helpers.BaseScreen
import io.qameta.allure.Step
import popups.WishListItemMenuPopUp

open class WishListScreen : BaseScreen() {
    private val getBackButton = findByXpath("//*[@content-desc='Перейти вгору']")

    fun getMonitorFromWishList(): SelenideElement {
        val monitor = findById("section_offer_tv_title")

        return monitor
    }

    @Step("Open Item Menu")
    fun openItemMenu(): WishListItemMenuPopUp {
        val itemMenu = findById("item_wishlist_offer_fl_menu")
        itemMenu.click()

        return WishListItemMenuPopUp()
    }

    fun wishListIsEmpty(): Boolean {
        val message = findById("empty_base_tv_title")
        if (message.text == "Цей список порожній") {
            return true
        }
        return false
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
}