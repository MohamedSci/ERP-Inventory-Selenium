package com.mohamedsaidibrahim.Helper_Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mohamedsaidibrahim.BaseTest;

public class SeleniumHelper extends BaseTest {

    // Function to find an element by 'data-testid' attribute value
    static public WebElement getElementByTestId(String testIdValue) {
        try {
            // Locate the element using CSS Selector
            return driver.findElement(By.xpath("//*[contains(@data-testid," + testIdValue + ")]"));
        } catch (Exception e) {
            System.out.println("Element not found with data-testid: " + testIdValue);
            e.printStackTrace();
            return null; // Return null if the element is not found
        }
    }
}
