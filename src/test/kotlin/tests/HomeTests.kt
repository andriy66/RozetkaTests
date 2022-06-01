package tests

import helpers.BaseTest
import io.qameta.allure.Description
import org.apache.commons.lang.math.NumberUtils.toInt
import org.testng.Assert
import org.testng.annotations.Test
import screens.HomeScreen
import screens.PremiumSubscribeScreen

class HomeTests : BaseTest() {
    @Test
    @Description("Verify that sort is working correctly")
    fun checkThatSortIsWorkingCorrectly() {
        val listOfProductsScreen = HomeScreen()
            .findProduct("iphone 13")

        //Sort the products from cheap to expensive
        val sort = listOfProductsScreen
            .openSortPopUp()
            .chooseFromCheapToExpensive()

        //Get the price of product after sorting from cheap to expensive
        val openProdDesc = sort
            .openFirstProductScreen()
        val cheapProductPrice = toInt(openProdDesc.priceLabel.text.replace(" ", ""))
        openProdDesc.getBack()

        //Sort the products from expensive to cheap
        val sortListOfProducts = sort
            .openSortPopUp()
            .chooseFromExpensiveToCheap()

        //Get the price of product after sorting from expensive to cheap
        val openExpenseProdDesc = sortListOfProducts
            .openFirstProductScreen()
        val expensiveProductPrice = toInt(openExpenseProdDesc.priceLabel.text.replace(" ", ""))

        //Check that the price of first product after sorting from cheap to expensive is less that the price of first element after sorting from expensive to cheap
        Assert.assertTrue(cheapProductPrice < expensiveProductPrice)
    }

    @Test
    @Description("Verify that after searching the product is adding to 'Переглянуті товари'")
    fun checkThatAfterSearchingProdAddToViewScreen() {
        //Delete data in Watched List if it exists
        val clearData = HomeScreen()
            .openYet()
            .openWatchedScreen()
            .clearWatchedData()

        //Check that data from Watched List is empty
        var message = clearData.message.text
        Assert.assertEquals(message, "Ви ще не переглядали товари")

        //Find the product
        val listOfProduct = clearData
            .openHomeScreen()
            .findProduct("iphone 13")

        //Get product description and open the Watch Screen
        val prodDesc = listOfProduct.openFirstProductScreen()
        val productName = prodDesc.productName.text
        val watchedScreen = prodDesc.getBack()
            .openHome()
            .openWatchScreen()

        //Check that product is in Watched List
        val productFromWatchedList = watchedScreen.productName.text
        Assert.assertEquals(productFromWatchedList, productName, "There aren`t product in Watch List")

        //Clear all data
        watchedScreen.clearWatchedData()

        //Check that data was deleted
        message = clearData.message.text
        Assert.assertEquals(message, "Ви ще не переглядали товари")
    }

    @Test
    @Description("Verify that customer can add the products for comparison")
    fun verifyThatCustomerCanAddTheProductsForComparison() {
        val catalogScreen = HomeScreen()
            .openCatalog()

        //Choose the category 'Gamers Product'
        val gamerProducts = catalogScreen.openCategoryGamersProducts()

        //Get products name
        val firstProductName = "Ігрова консоль XoKo Hey Boy Червона (XOKO Нb-RD)"
        val secondProductName = "Ігрова консоль XoKo Hey Boy Чорна (XOKO Нb-BK)"

        //Open the Sub Category
        val listOfProducts = gamerProducts.openGameConsolesListOfProducts()

        //Add first product to Comparison
        val openDesc = listOfProducts.openProductDescription(firstProductName)
        openDesc.addToComparison()
        val listOfPro = openDesc.getBack()

        //Add second product to Comparison
        val secondProduct = listOfPro.openProductDescription(secondProductName)
        secondProduct.addToComparison()
        val listOfProp = secondProduct.getBack()

        //Open Comparison
        val comparisonScreen = listOfProp.openYet()
            .openComparisonScreen()
            .openComparisonList()
        comparisonScreen.clickDifference()

        //Check difference
        val difference = comparisonScreen
        val firstProductProp = difference.isProperDisplayed("Червоний")
        val secondProductProp = difference.isProperDisplayed("Чорний")
        Assert.assertEquals(firstProductProp, secondProductProp, "The properties are displayed")

        //Delete list
        val deleteList = difference
            .getBack()
            .deleteComparisonList()
        val messageOfDeleting = deleteList.message.text

        //Check that list was deleted
        Assert.assertEquals(messageOfDeleting, "Немає товарів в порівнянні", "The list was`t deleted")
    }

    @Test
    @Description("Verify that customer can buy product")
    fun verifyThatCustomerCanBuyProduct() {
        val phonesSubCategoryScreen = HomeScreen()
            .openCatalog()
            .openPhonesSubCategoryScreen()

        //Check that phones sub category opened
        val phonesSubcategoryScreenIsOpened = phonesSubCategoryScreen.phonesSubcategoryScreenOpened()
        Assert.assertTrue(phonesSubcategoryScreenIsOpened, "Phones Subcategory Screen isn`t displayed")

        //Open Description Screen
        val descriptionScreen = phonesSubCategoryScreen
            .openSubCategoryAdaptors()
            .openSecondProductScreen()

        //Get price of product
        val productPrice = descriptionScreen.priceLabel.text

        //Add first product to cart and open cart
        val cartScreen = descriptionScreen
            .addToCart()
            .openCart()

        //Buy product from cart
        val buyProduct = cartScreen
            .clickBuyButton()

        //Check that customer who order it is same and price same
        val actualPrice = buyProduct.priceLayout.text
        val customerIsSame = buyProduct.isCustomerNameDisplayed("Лютак Андрій")
        Assert.assertTrue(customerIsSame, "Customer isn`t same")
        Assert.assertEquals(actualPrice, productPrice, "The prise aren`t same")

        //Delete product from cart
        val deleteProductFromCart = buyProduct
            .getBack()
            .openItemMenu()
            .removeFromCart()

        //Check that product has been deleted
        val cartIsEmpty = deleteProductFromCart.emptyCart()
        Assert.assertTrue(cartIsEmpty, "Product had`t been deleted")
    }

    @Test
    @Description("Verify that customer can get premium subscribe")
    fun verifyThatCustomerCanGetPremiumSubscribe() {
        val yetScreen = HomeScreen()
            .openYet()

        //Check that yet screen is shown
        val profileOwnerName = yetScreen.profileNameButton.text
        val expectedName = "Лютак Андрій"
        softAssert.assertEquals(profileOwnerName, expectedName, "Another user authorized")

        //Go to Premium Subscribe screen
        val premiumSubscribe = yetScreen
            .openPremiumSubscribeScreen()

        //Get actual price information result
        val novaPoshtaActual = premiumSubscribe.getDeliveryPriceInfo(PremiumSubscribeScreen.Delivery.NOVA_POSHTA)
        val ukrPoshtaActual = premiumSubscribe.getDeliveryPriceInfo(PremiumSubscribeScreen.Delivery.UKR_POSHTA)
        val justinActual = premiumSubscribe.getDeliveryPriceInfo(PremiumSubscribeScreen.Delivery.JUSTIN)
        val meestActual = premiumSubscribe.getDeliveryPriceInfo(PremiumSubscribeScreen.Delivery.MEEST)
        val courierActual = premiumSubscribe.getDeliveryPriceInfo(PremiumSubscribeScreen.Delivery.COURIER)

        //GetExpected result
        val novaPoshtaExpected = "від 55 ₴"
        val ukrPoshtaExpected = "від 24 ₴"
        val justinExpected = "від 33 ₴"
        val meestExpected = "від 23 ₴"
        val courierExpected = "від 59 ₴"

        //Check that price info is correct
        softAssert.assertEquals(novaPoshtaActual, novaPoshtaExpected, "The nova poshta price info isn`t same")
        softAssert.assertEquals(ukrPoshtaActual, ukrPoshtaExpected, "The ukr poshta price info isn`t same")
        softAssert.assertEquals(justinActual, justinExpected, "The justin price info isn`t same")
        softAssert.assertEquals(meestActual, meestExpected, "The meest express price info isn`t same")
        softAssert.assertEquals(courierActual, courierExpected, "The courier price info isn`t same")

        //Get info about sales
        val salesPopUp = premiumSubscribe
            .clickSalesButton()

        //Open available with premium subscribe
        val availWithSub = salesPopUp
            .clickAvailWithPremiumSub()

        //Open choose the premium screen
        val premiumScreen = availWithSub
            .closePremiumInfoPopUpAndGetBack()

        //Check that choose premium screen is shown
        premiumScreen.chooseThePremiumSubscribe()
        Assert.assertFalse(
            premiumScreen.chooseThePremiumSubButton.isDisplayed,
            "Choose the premium screen isn`t displayed"
        )
    }
}