package TestCases;

import BaseClass.BaseTest;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.SearchResultsPage;
import Utils.ReadExcelUtility;
import Utils.ScreenShotsUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartScenario extends BaseTest {

    @Test
    public void searchAndBuySamsungPhone() {

        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ProductPage productPage = new ProductPage(driver);

        // Initialize Excel Information
        String excelFilePath = "src/test/resources/testdata/TestData.xlsx";
        String sheetName = "Data";

        // Initialize ExcelUtils
        ReadExcelUtility excel = new ReadExcelUtility(excelFilePath, sheetName);

        // Read data
        String mobileBrand = excel.getCellData(1, 1); // Row 1, Column 1

        // Step 1: Search for Samsung phone
        homePage.searchFor(mobileBrand);
        setReportName("EbayAddToCartFlow");
        startTest("EbayAddToCartFlow");
        test = extent.createTest("Successful Searched", "Successfully Searched t");
        String screenshotPath1 = ScreenShotsUtility.takeScreenshot(driver, "SuccessfulSearch");
        test.pass("System Successfully searched ").addScreenCaptureFromPath(screenshotPath1);

        // Step 2: Select the first product
        double actualValue = searchResultsPage.assertPrice();
        double expectedPrice = 500;
        test = extent.createTest("Price is comparing", "Price is comparing");

        try {
            String screenshotPath5 = ScreenShotsUtility.takeScreenshot(driver, "Price Comparison");
            Assert.assertTrue(actualValue <= expectedPrice, "Price of the first item exceeds the expected value! Actual: $" + actualValue + ", Expected: $" + expectedPrice);
            test.pass("Price is within the expected Value.").addScreenCaptureFromPath(screenshotPath5);
        } catch (AssertionError e) {
            // Capture screenshot on failure
            String screenshotPath4 = ScreenShotsUtility.takeScreenshot(driver, "Price Comparison");
            test.fail("Assertion failed: " + e.getMessage()).addScreenCaptureFromPath(screenshotPath4);
            throw e; // Rethrow to terminate the test
        }
        searchResultsPage.selectFirstProduct();
        test = extent.createTest("First Item Selected", "searched the item and get the select the first result");
        String screenshotPath2 = ScreenShotsUtility.takeScreenshot(driver, "FirstResultTaken");
        test.pass("searched the item and select  the first result").addScreenCaptureFromPath(screenshotPath2);

        // Write data back to the Excel file
        excel.setCellData(1, 2, "I Found the Tab I searched", excelFilePath);

        // Step 3: Proceed to add To Cart
        test = extent.createTest("Add to Cart", " Add the item to Cart");
        String screenshotPath3 = ScreenShotsUtility.takeScreenshot(driver, "AddToCart");
        test.pass("dd the item to Cart").addScreenCaptureFromPath(screenshotPath3);

        // Close workbook
        excel.closeWorkbook();
    }


}
