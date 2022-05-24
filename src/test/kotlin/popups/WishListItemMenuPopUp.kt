package popups

import helpers.BaseScreen
import io.qameta.allure.Step
import screens.WishListScreen

class WishListItemMenuPopUp : BaseScreen() {
    private val relocateProductButton = findElementByText("Перемістити товар")
    private val deleteProductFromWishListButton = findElementByText("Видалити товар")

    @Step("Click 'Relocate Product'")
    fun clickRelocateProduct(): ChooseTheWishListPopUp {
        relocateProductButton.click()

        return ChooseTheWishListPopUp()
    }

    @Step("Delete product from Wish List")
    fun deleteProductFromWishList(): WishListScreen {
        deleteProductFromWishListButton.click()

        return WishListScreen()
    }
}