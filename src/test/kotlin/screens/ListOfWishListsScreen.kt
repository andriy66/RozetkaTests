package screens

import helpers.BaseScreenWithMenuComponents
import io.qameta.allure.Step
import popups.ListOfWishListsItemMenuPopUp

open class ListOfWishListsScreen : BaseScreenWithMenuComponents() {
    private val listMenu = findByXpath("//*[@content-desc='Ще']")
    private val wishList = findById("item_wishlists_rv_offers")
    private val createWishListButton = findById("action_create_new_wishlist")

    @Step("Open Wish List")
    fun openWishList(): WishListScreen {
        log.info("Open Wish List")
        wishList.click()

        return WishListScreen()
    }

    @Step("Open custom wish list")
    fun openCustomWishList(wishListName: String): WishListScreen {
        log.info("Open custom wish list")
        val customWishList = findElementByText(wishListName)
        customWishList.click()

        return WishListScreen()
    }

    @Step("Open Wish List Menu")
    fun openWishListMenu(): ListOfWishListsItemMenuPopUp {
        log.info("Open Wish List Menu")
        listMenu.click()

        return ListOfWishListsItemMenuPopUp()
    }

    @Step("Crete wish list with name")
    fun createWishListWithName(wishListName: String) {
        log.info("Crete wish list with name")
        createWishListButton.click()
        val wishListNameField = findById("wishlist_add_edit_et_title")
        wishListNameField.sendKeys(wishListName)
        val createButton = findById("wishlist_add_edit_v_save")
        createButton.click()
    }

    fun wishListIsCreated(wishListName: String): Boolean {
        val wishList = findElementByText(wishListName)

        return wishList.isDisplayed
    }
}