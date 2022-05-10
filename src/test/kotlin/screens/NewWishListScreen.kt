package screens

import helpers.BaseScreen
import io.qameta.allure.Step

class NewWishListScreen : BaseScreen() {
    val wishListNameField = findById("wishlist_add_edit_et_title")
    val makeDefaultWishListCheckBox = findById("wishlist_add_edit_cb_is_default")
    val createButton = findById("wishlist_add_edit_v_save")

    @Step("Fill in Wish List Name")
    fun fillInWishListName(name: String) {
        wishListNameField.sendKeys(name)
    }

    @Step("Click 'Create Wish List'")
    fun clickCreateWishList(): WishListScreen {
        createButton.click()

        return WishListScreen()
    }

    fun makeDefault() {
        makeDefaultWishListCheckBox.click()
    }
}