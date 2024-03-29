package screens

import helpers.BaseScreen
import io.qameta.allure.Step

class AuthorizeScreen : BaseScreen() {
    val searchButton = findById("action_search")
    val cartButton = findById("action_cart")
    val moreButton = findById("action_more")
    val loginField = findById("sign_in_et_login")
    val passwordField = findById("sign_in_et_password")
    val eyeIcon = findById("text_input_end_icon")
    val signInButton = findById("sign_in_tv_login")
    val forgotPasswordButton = findById("sign_in_b_remind_password")
    val signInWithSocialLabel = findById("sign_in_tv_social")
    val signInWithFacebookButton = findById("sign_in_b_facebook")
    val signInWithGoogleButton = findById("sign_in_b_google")
    val errorMessage = findByXpath("//*[@content-desc='Помилка']")

    @Step("Authorize")
    fun authorize(login: String, password: String): AuthorizedYetScreen {
        log.info("Authorize")
        loginField.sendKeys(login)
        passwordField.sendKeys(password)
        signInButton.click()

        return AuthorizedYetScreen()
    }
}