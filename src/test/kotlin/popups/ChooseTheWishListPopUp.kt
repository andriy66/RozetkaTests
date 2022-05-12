package popups

import com.codeborne.selenide.Selenide.`$`
import helpers.BaseScreen
import io.qameta.allure.Step
import org.openqa.selenium.By
import screens.NewWishListScreen

class ChooseTheWishListPopUp : BaseScreen() {
    private val createWishListButton = `$`(By.id("android:id/text1"))

    @Step("Create Wish List")
    fun createWishList(): NewWishListScreen {
        createWishListButton.click()

        return NewWishListScreen()
    }
}