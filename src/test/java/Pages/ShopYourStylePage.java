package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShopYourStylePage {
    WebDriver driver;

    // Locator for the first product in the search results
    @FindBy(xpath = "//*[@id=\"nid-r05-3\"]/button")
    WebElement sortDropDown;


    // Constructor to initialize elements
    public ShopYourStylePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method Used In collections Page
    public void sortProducts() {
// Get all radio button options inside the dropdown
        List<WebElement> radioOptions = driver.findElements(By.xpath("//*[@id=\"nid-h2f-3\"]/button"));
        System.out.println(radioOptions);

        // Loop through options and select the desired one
        for (WebElement option : radioOptions) {
            String value = option.getAttribute("value");
            if (value.equals("Buy It Now")) { // Replace with the actual value you want to select
                option.click();
                break;
            }
        }

        }}




