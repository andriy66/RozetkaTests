package screens

import helpers.BaseScreen
import io.qameta.allure.Step

class ProfileSettingScreen : BaseScreen() {
    private val signOutButton = findById("personal_info_btn_sign_out")

    @Step("Sign out")
    fun signOut(): YetScreen {
        log.info("Sign out")
        scroll(times = 5)
        signOutButton.click()

        return YetScreen()
    }
}