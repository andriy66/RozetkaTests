package popups

import helpers.BaseScreen
import io.qameta.allure.Step

class DeletingPopUp : BaseScreen() {
    val message = findById("message", androidPrefix)
    private val deleteButton = findById("button1", androidPrefix)
    private val cancelButton = findById("button2", androidPrefix)

    @Step("Click delete")
    fun clickDelete() {
        log.info("Click delete")
        deleteButton.click()
    }

    @Step("Click Cancel")
    fun clickCancel() {
        log.info("Click cancel")
        cancelButton.click()
    }
}