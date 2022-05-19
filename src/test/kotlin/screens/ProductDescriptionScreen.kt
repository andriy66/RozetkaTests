package screens

import helpers.BaseScreen
import helpers.ScrollDirection
import io.qameta.allure.Step
import java.lang.Thread.sleep

class ProductDescriptionScreen : BaseScreen() {
    private val cartButton = findById("bottom_bar_iv_cart_image")
    private val wishButton = findById("bottom_bar_iv_wish_image")
    private val comparison = findById("bottom_bar_iv_compare_image")
    private val getBackButton = findByXpath("//*[@content-desc='Перейти вгору']")
    private val attribute = findById("offer_var_detail_variant_value_tv_text")
    val priceLabel = findById("view_price_tv_price")

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
    fun addToWishList(): ProductDescriptionScreen {
        scroll()
        wishButton.click()

        return this
    }

    @Step("Click the 'Wish' Button")
    fun openWishList(): WishListScreen {
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
}