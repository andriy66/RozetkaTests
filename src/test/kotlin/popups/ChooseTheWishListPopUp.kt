package popups

import helpers.BaseScreen
import io.qameta.allure.Step
import screens.NewWishListScreen
import screens.ProductDescriptionScreen

class ChooseTheWishListPopUp : BaseScreen() {
    private val createWishListButton = findById("text1", androidPrefix)

    @Step("Choose wish list")
    fun chooseWishList(wishListName: String): ProductDescriptionScreen {
        val chooseWishList = findElementByText(wishListName)
        chooseWishList.click()

        return ProductDescriptionScreen()
    }

    @Step("Create Wish List")
    fun createWishList(): NewWishListScreen {
        createWishListButton.click()

        return NewWishListScreen()
    }
}