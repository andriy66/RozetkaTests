package screens

import helpers.BaseScreen
import helpers.ScrollDirection
import io.qameta.allure.Step
import popups.ChooseTheWishListPopUp
import java.lang.Thread.sleep

class ProductDescriptionScreen : BaseScreen() {
    private val cartButton = findById("bottom_bar_iv_cart_image")
    private val wishButton = findById("bottom_bar_iv_wish_image")
    private val comparison = findById("bottom_bar_iv_compare_image")
    private val getBackButton = findByXpath("//*[@content-desc='Перейти вгору']")
    private val buyNowButton = findById("bottom_bar_btn_buy")
    val priceLabel = findById("view_price_tv_price")
    val productName = findById("offer_tab_all_tv_title")

    @Step("Add to the Cart")
    fun addToCart(): ProductDescriptionScreen {
        scroll()
        cartButton.click()

        return this
    }

    fun openCart(): CartScreen {
        cartButton.click()

        return CartScreen()
    }

    @Step("Add to Wish List")
    fun addToWishList(wishListName: String = "") {
        log.info("Get delivery price info")
        scroll()
        wishButton.click()
        if (wishListName.isNotEmpty()) {
            ChooseTheWishListPopUp().chooseWishList(wishListName)
        }
    }

    @Step("Click the 'Wish' Button")
    fun openWishList(): WishListScreen {
        log.info("Get delivery price info")
        wishButton.click()

        return WishListScreen()
    }

    @Step("Get back to List Of products")
    fun getBack(): ListOfProductsScreen {
        sleep(1000)
        scroll(ScrollDirection.UP)
        getBackButton.click()

        return ListOfProductsScreen()
    }

    @Step("Add to Comparison")
    fun addToComparison() {
        scroll()
        comparison.click()
    }

    @Step("Buy now")
    fun buyNow(): CartScreen {
        scroll()
        buyNowButton.click()

        return CartScreen()
    }
}