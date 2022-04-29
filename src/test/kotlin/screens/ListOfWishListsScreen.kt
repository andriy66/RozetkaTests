package screens

import helpers.BaseScreen
import io.qameta.allure.Step
import popups.ListOfWishListsItemMenuPopUp

open class ListOfWishListsScreen : BaseScreen() {
    @Step("Open Wish List")
    fun openWishList(): WishListScreen {
        val wishList = findById("item_wishlists_rv_offers")
        wishList.click()

        return WishListScreen()
    }

    @Step("Open Wish List Menu")
    fun openWishListMenu(): ListOfWishListsItemMenuPopUp {
        val listMenu = findByXpath("//*[@content-desc='Ще']")
        listMenu.click()

        return ListOfWishListsItemMenuPopUp()
    }
}