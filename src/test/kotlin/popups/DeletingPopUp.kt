package popups

import com.codeborne.selenide.Selenide.`$`
import helpers.BaseScreen
import io.qameta.allure.Step
import org.openqa.selenium.By

class DeletingPopUp : BaseScreen() {
    val message = findById("message", androidPrefix)
    private val deleteButton = findById("button1", androidPrefix)
    private val cancelButton = findById("button2", androidPrefix)

    @Step("Click delete")
    fun clickDelete() {
        deleteButton.click()
    }

    @Step("Click Cancel")
    fun clickCancel() {
        cancelButton.click()
    }
}