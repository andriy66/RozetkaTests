package screens

import helpers.BaseScreen
import io.qameta.allure.Step

class NewWishListScreen : BaseScreen() {
    val wishListNameField = findById("wishlist_add_edit_et_title")
    val makeDefaultWishListCheckBox = findById("wishlist_add_edit_cb_is_default")
    val createButton = findById("wishlist_add_edit_v_save")

    @Step("Fill in Wish List Name")
    fun fillInWishListName(name: String) {
        log.info("Fill in Wish List Name")
        wishListNameField.sendKeys(name)
    }

    @Step("Click 'Create Wish List'")
    fun clickCreateWishList(): WishListScreen {
        log.info("Click 'Create Wish List'")
        createButton.click()

        return WishListScreen()
    }

    @Step("Make default")
    fun makeDefault() {
        log.info("Make default")
        makeDefaultWishListCheckBox.click()
    }
}