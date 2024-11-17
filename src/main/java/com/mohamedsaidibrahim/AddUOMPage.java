package com.mohamedsaidibrahim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddUOMPage {
    WebDriver driver;

    public AddUOMPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By codeField = By.id("code");
    private By nameEnField = By.id("name-en");
    private By nameArField = By.id("name-ar");
    private By shortNameField = By.id("short-name");
    private By systemUnitDropdown = By.id("system-unit-base");
    private By saveButton = By.id("save");

    // Actions
    public void enterCode(String code) {
        driver.findElement(codeField).sendKeys(code);
    }

    public void enterNameEn(String nameEn) {
        driver.findElement(nameEnField).sendKeys(nameEn);
    }

    public void enterNameAr(String nameAr) {
        driver.findElement(nameArField).sendKeys(nameAr);
    }

    public void enterShortName(String shortName) {
        driver.findElement(shortNameField).sendKeys(shortName);
    }

    public void selectSystemUnit(String unitName) {
        driver.findElement(systemUnitDropdown).sendKeys(unitName);
    }

    public void clickSave() {
        driver.findElement(saveButton).click();
    }
}

