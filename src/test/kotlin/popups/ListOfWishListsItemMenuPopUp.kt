package popups

import helpers.BaseScreen
import io.qameta.allure.Step

class ListOfWishListsItemMenuPopUp : BaseScreen() {
    private val deleteWishListButton = findElementByText("Видалити список")

    @Step("Delete Wish List")
    fun deleteWishList(): DeletingPopUp {
        log.info("Delete Wish List")
        deleteWishListButton.click()

        return DeletingPopUp()
    }
}