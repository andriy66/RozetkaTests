package popups

import helpers.BaseScreen
import io.qameta.allure.Step
import screens.NewWishListScreen

class ChooseTheWishListPopUp : BaseScreen() {
    private val createWishListButton = findById("text1", androidPrefix)

    @Step("Create Wish List")
    fun createWishList(): NewWishListScreen {
        createWishListButton.click()

        return NewWishListScreen()
    }
}