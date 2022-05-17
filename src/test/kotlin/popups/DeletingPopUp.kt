package popups

import com.codeborne.selenide.Selenide.`$`
import helpers.BaseScreen
import io.qameta.allure.Step
import org.openqa.selenium.By

class DeletingPopUp : BaseScreen() {
    val prefix = "android:id/"
    val message = findById("message", prefix)
    val deleteButton = findById("button1", prefix)
    val cancelButton = findById("button2", prefix)

    @Step("Click delete")
    fun clickDelete() {
        deleteButton.click()
    }

    @Step("Click Cancel")
    fun clickCancel() {
        cancelButton.click()
    }
}