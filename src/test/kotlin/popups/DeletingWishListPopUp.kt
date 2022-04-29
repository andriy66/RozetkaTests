package popups

import com.codeborne.selenide.Selenide.`$`
import io.qameta.allure.Step
import org.openqa.selenium.By

class DeletingWishListPopUp {
    val message = `$`(By.id("android:id/message"))
    val deleteButton = `$`(By.id("android:id/button1"))
    val cancelButton = `$`(By.id("android:id/button2"))

    fun getMessage(): String {
        return message.text
    }

    @Step("Click delete")
    fun clickDelete() {
        deleteButton.click()
    }

    @Step("Click Cancel")
    fun clickCancel() {
        cancelButton.click()
    }
}