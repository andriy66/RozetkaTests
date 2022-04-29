package popups

import io.qameta.allure.Step
import screens.WishListScreen

class WishListItemMenuPopUp : WishListScreen() {
    val relocateProductButton = findElementByText("Перемістити товар")
    val deleteProductFromWishListButton = findElementByText("Видалити товар")

    @Step("Click 'Relocate Product'")
    fun clickRelocateProduct(): ChooseTheWishListPopUp {
        relocateProductButton.click()

        return ChooseTheWishListPopUp()
    }

    @Step("Delete product from Wish List")
    fun deleteProductFromWishList() {
        deleteProductFromWishListButton.click()
    }
}