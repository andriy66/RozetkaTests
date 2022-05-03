package popups

import io.qameta.allure.Step
import screens.ListOfWishListsScreen

class ListOfWishListsItemMenuPopUp : ListOfWishListsScreen() {
    private val deleteWishListButton = findElementByText("Видалити список")

    @Step("Delete Wish List")
    fun deleteWishList(): DeletingPopUp {
        deleteWishListButton.click()

        return DeletingPopUp()
    }
}