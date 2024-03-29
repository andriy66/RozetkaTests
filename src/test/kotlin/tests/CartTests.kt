package tests

import helpers.BaseTest
import io.qameta.allure.Description
import org.testng.Assert
import org.testng.annotations.Test
import screens.HomeScreen

class CartTests : BaseTest() {
    @Test
    @Description("Verify that customer can add the product to the cart")
    fun verifyThatYouCanAddProductToTheCart() {
        val catalogScreen = HomeScreen()
            .openCatalog()

        //Open list of products
        val chooseTheSubCategory = catalogScreen
            .openCategoryLaptopsAndComputersSubCategoryScreen()
            .openListOfProducts()

        //Check that List of Products Screen opened
        softAssert.assertTrue(chooseTheSubCategory.sortButton.isDisplayed, "Button 'Sort' isn`t displayed")
        softAssert.assertTrue(chooseTheSubCategory.filterButton.isDisplayed, "Button 'Filter' isn`t displayed")

        //Get monitor name
        val monitorName = "Монітор 27\" Dell S2722DC (210-BBRR) 75Hz/8-bit/USB Type-C Power Delivery 65W"

        //Open monitor description
        val monitorDescription = chooseTheSubCategory
            .openProductDescription(monitorName)

        //Adding the product to the cart
        val cartScreen = monitorDescription
            .addToCart()
            .openCart()

        //Get product from cart
        val product = cartScreen.monitor

        //Check that product is in the cart
        Assert.assertEquals(product.text, monitorName, "Product isn`t in cart")

        //Remove product from Cart
        val removeFromCart = cartScreen
            .openItemMenu()
            .removeFromCart()

        //Check that product has been deleted
        softAssert.assertTrue(removeFromCart.emptyCart(), "Product had`t been deleted")
    }

    @Test
    @Description("Verify that the customer can add the product from Wish List to Cart")
    fun verifyThatCustomerCanAddProdFromWishListToCart() {
        val listOfProductsScreen = HomeScreen()
            .openCatalog()
            .openPhonesSubCategoryScreen()
            .openSubCategoryAdaptors()

        //Choose second product
        val firstProdDesc = listOfProductsScreen
            .openFirstProductScreen()

        //Add the product to Wish List
        firstProdDesc.addToWishList()
        val wishListsScreen = firstProdDesc
            .openWishList()

        //Check that product is one in Wish List
        val availableProductsActual = wishListsScreen.availableProducts.text.trim()
        val availableProductsExpected = "Доступно: 1 товар"
        softAssert.assertEquals(
            availableProductsActual,
            availableProductsExpected,
            "There is another counts of products in Wish List"
        )

        //Click button buy all and go to the cart
        val prodDesc = wishListsScreen
            .clickBuyAll()
            .openProductDescription()

        //Get previous price of product
        val priceOfProd = prodDesc.priceLabel.text.toInt()

        //Go to Cart screen again
        val cartScreen = prodDesc
            .openCart()

        //Check that price if equal
        val priceAfterMultiplying = cartScreen.buyButton.text.split(" ")[3]
        softAssert.assertEquals(priceAfterMultiplying.toInt(), priceOfProd, "The price isn`t equal")

        //Remove product from Cart
        val removeFromCart = cartScreen
            .openItemMenu()
            .removeFromCart()

        //Check that product has been deleted
        Assert.assertTrue(removeFromCart.emptyCart(), "Product had`t been deleted from cart")

        //Remove from wish list
        val removeProductFromWishList = removeFromCart
            .openWishLists()
            .openWishList()
            .openItemMenu()
            .deleteProductFromWishList()

        //Check that product deleted from wish list
        softAssert.assertTrue(removeProductFromWishList.wishListIsEmpty(), "Product had`t been deleted from Wish List")
    }

    @Test
    @Description("Verify that the customer can use fast buy")
    fun verifyThatCustomerCanUseFastBuy() {
        val listOfProductsScreen = HomeScreen()
            .openCatalog()
            .openPhonesSubCategoryScreen()
            .openSubCategoryAdaptors()

        //Choose second product and get the product price
        val firstProdDesc = listOfProductsScreen
            .openFirstProductScreen()
        val priceOfProduct = firstProdDesc.priceLabel.text.toInt()

        //Buy now
        val buyNow = firstProdDesc
            .buyNow()

        //Check that prices is equals
        val actualPrice = buyNow.getOrderPrice().split(" ")[0].toInt()
        Assert.assertEquals(actualPrice, priceOfProduct, "The prices are equals")

        //Get customer phone numbers
        val expectedNumber = "+380 98 396-76-11"
        val actualNumber = buyNow.phoneNumber.text
        Assert.assertEquals(actualNumber, expectedNumber, "The phone numbers aren`t equals")

        //Delete the product from cart
        buyNow.getBack()
        val removeProductFromCart = buyNow.openItemMenu()
            .removeFromCart()
        softAssert.assertTrue(removeProductFromCart.emptyCart(), "Product had`t been deleted from cart")
    }
}