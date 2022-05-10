package popups

import com.codeborne.selenide.Selenide.`$`
import helpers.BaseScreen
import io.qameta.allure.Step
import org.openqa.selenium.By

class DeletingPopUp : BaseScreen() {
    val message = `$`(By.id("android:id/message"))
    val deleteButton = `$`(By.id("android:id/button1"))
    val cancelButton = `$`(By.id("android:id/button2"))

    @Step("Click delete")
    fun clickDelete() {
        deleteButton.click()
    }

    @Step("Click Cancel")
    fun clickCancel() {
        cancelButton.click()
    }
}