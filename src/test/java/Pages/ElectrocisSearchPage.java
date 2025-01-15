package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ElectrocisSearchPage {
    WebDriver driver;

    // Locators using @FindBy
    @FindBy(id = "gh-ac-box2") // Search input field
            WebElement keyWordsField;

    @FindBy(id = "gh-btn") // Search input field
    WebElement searchButton;

    // Constructor to initialize elements
    public ElectrocisSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to searchFor
    public void electronicsSearchFor(String model) {
        keyWordsField.sendKeys(model);
        searchButton.click();
    }

}
