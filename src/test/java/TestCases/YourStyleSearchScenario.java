package TestCases;

import BaseClass.BaseTest;
import Pages.ShopYourStylePage;
import Pages.HomePage;
import Utils.ReadExcelUtility;
import Utils.ScreenShotsUtility;
import org.testng.annotations.Test;

public class YourStyleSearchScenario extends BaseTest {

    @Test
    public void shopYourStyle() {

        HomePage homePage = new HomePage(driver);
        ShopYourStylePage shopYourStyle = new ShopYourStylePage(driver);

        // Initialize Excel Information
        String excelFilePath = "src/test/resources/testdata/TestData.xlsx";
        String sheetName = "Data";

        // Initialize ExcelUtils
        ReadExcelUtility excel = new ReadExcelUtility(excelFilePath, sheetName);

        setReportName("shopYourStyle Search Scenario- Test Case 9");
        startTest("shopYourStyle Search Scenario- Test Case 9");
        homePage.shopYourStyle();
        test = extent.createTest("Successfully Navigated to shopYourStyle Page", "Successfully Navigated to shopYourStyle Page");
        String screenshotPath1 = ScreenShotsUtility.takeScreenshot(driver, "SSuccessfully Navigated to shopYourStyle Page");
        test.pass("Successfully Navigated to shopYourStyle Page").addScreenCaptureFromPath(screenshotPath1);
        shopYourStyle.sortProducts();
        test = extent.createTest("System Successfully Changed the Sorting", "System Successfully Changed the Sorting");
        String screenshotPath2 = ScreenShotsUtility.takeScreenshot(driver, "System Successfully Changed the Sorting");
        test.pass("System Successfully Changed the Sorting").addScreenCaptureFromPath(screenshotPath2);

        // Close workbook
        excel.closeWorkbook();
    }


}
