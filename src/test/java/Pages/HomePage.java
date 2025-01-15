package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    // Locators using @FindBy
    @FindBy(id = "gh-ac") // Search input field
            WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"gh-search-btn\"]/span") // Search button
    WebElement searchButton;


    @FindBy(xpath = "//*[@id=\"s0-1-0-53-1-2-5-15-0[0]-2-@match-media-0-@ebay-carousel-list\"]/li/div/div/div/div[2]/div/div/div[4]/a/div[2]") // Search button
    WebElement shopYourStyleButton;

    //@FindBy(id = "gh-as-a") // Advance Search button
    //WebElement advanceSearchButton;

    @FindBy(xpath = "//*[@id=\"gh-f\"]/div[3]/a") // Advance Search button
    WebElement advanceSearchButton;

    @FindBy(xpath = "//*[@id=\"vl-flyout-nav\"]/ul/li[3]/a") // Electronics link
    WebElement electronicsSearchButton;

    // Constructor to initialize elements
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to searchFor
    public void searchFor(String keyword) {
        searchBox.sendKeys(keyword);
        searchButton.click();
    }

    //Method to Advance searchFor
    public void advancedSearchFor() {
        advanceSearchButton.click();
    }

    //Method to electronics searchFor
    public void electronicsSearchFor() {
        electronicsSearchButton.click();
    }

    //Method to collections
    public void shopYourStyle() {
        shopYourStyleButton.click();
    }
}
