package TestCases;

import BaseClass.BaseTest;
import Pages.HomePage;
import Utils.ReadExcelUtility;
import Utils.ScreenShotsUtility;
import org.testng.annotations.Test;

public class ElectronicsSearchScenario extends BaseTest {

    @Test
    public void advancedSearchOption() {

        HomePage homePage = new HomePage(driver);


        // Initialize Excel Information
        String excelFilePath = "src/test/resources/testdata/TestData.xlsx";
        String sheetName = "Data";

        // Initialize ExcelUtils
        ReadExcelUtility excel = new ReadExcelUtility(excelFilePath, sheetName);

        // Read data
        String mobileBrand = excel.getCellData(5, 1); // Row 1, Column 1
        setReportName("Electronics Search Scenario- Test Case 9");
        startTest("Electronics Search Scenario- Test Case 9");
        homePage.electronicsSearchFor();
        test = extent.createTest("Electronics Navigated to Advanced Searched", "System Successfully Navigated to Electronics Searched");
        String screenshotPath1 = ScreenShotsUtility.takeScreenshot(driver, "Success Navigated to Electronics Searched");
        test.pass("System Successfully Navigated to Electronics Searched").addScreenCaptureFromPath(screenshotPath1);

        test = extent.createTest("Initiating the advance search ", "System Successfully Initiating the advance search");
        String screenshotPath2 = ScreenShotsUtility.takeScreenshot(driver, "Initiating the advance search");
        test.pass("System Successfully Initiating the advance search").addScreenCaptureFromPath(screenshotPath2);

        test = extent.createTest("Done the advance search ", "System Successfully Done the advance search");
        String screenshotPath3 = ScreenShotsUtility.takeScreenshot(driver, "Done the advance search");
        test.pass("System Successfully Done the advance search").addScreenCaptureFromPath(screenshotPath3);
        // Write data back to the Excel file
        excel.setCellData(5, 2, "Samsung is the phone", excelFilePath);

        // Step 3: Proceed to add To search Results
        test = extent.createTest("Successfully Searched", "Successfully Searched");
        String screenshotPath4 = ScreenShotsUtility.takeScreenshot(driver, "Successfully Searched");
        test.pass("System Successfully Searched").addScreenCaptureFromPath(screenshotPath4);

        // Close workbook
        excel.closeWorkbook();
    }


}
