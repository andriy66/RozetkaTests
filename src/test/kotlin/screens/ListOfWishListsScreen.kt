package screens

import helpers.BaseScreen
import io.qameta.allure.Step
import popups.ListOfWishListsItemMenuPopUp

open class ListOfWishListsScreen : BaseScreen() {
    val listMenu = findByXpath("//*[@content-desc='Ще']")
    val wishList = findById("item_wishlists_rv_offers")

    @Step("Open Wish List")
    fun openWishList(): WishListScreen {
        wishList.click()

        return WishListScreen()
    }

    @Step("Open Wish List Menu")
    fun openWishListMenu(): ListOfWishListsItemMenuPopUp {
        listMenu.click()

        return ListOfWishListsItemMenuPopUp()
    }
}