import org.testng.annotations.Test;

import com.mohamedsaidibrahim.AddUOMPage;
import com.mohamedsaidibrahim.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddUOMTest extends BaseTest {

    @Test
    public void verifyAddUOMFunctionality() {
        AddUOMPage uomPage = new AddUOMPage(driver);

        uomPage.enterCode("UOM123");
        uomPage.enterNameEn("Test UOM");
        uomPage.enterNameAr("اختبار");
        uomPage.enterShortName("TU");
        uomPage.selectSystemUnit("Kilogram");
        uomPage.clickSave();

        // Verify the success alert or redirection
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory/masterdata/uom"));
    }

    @Test
    public void verifyMandatoryFieldValidation() {
        driver.findElement(By.id("save")).click();

        // Assert error messages for each mandatory field
        Assert.assertTrue(driver.findElement(By.id("code-error")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("name-en-error")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("name-ar-error")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("short-name-error")).isDisplayed());
    }

    @Test
    public void verifySuccessfulSubmission() {
        driver.findElement(By.id("code")).sendKeys("UOM001");
        driver.findElement(By.id("name-en")).sendKeys("Test UOM");
        driver.findElement(By.id("name-ar")).sendKeys("وحدة اختبار");
        driver.findElement(By.id("short-name")).sendKeys("TU");
        driver.findElement(By.id("system-unit-base")).sendKeys("Kilogram");

        driver.findElement(By.id("save")).click();

        // Assert success message
        Assert.assertTrue(driver.findElement(By.id("success-message")).isDisplayed());
    }

    @Test
    public void verifyCharacterLengthValidation() {
        // Exceed character limit for "Code" field
        driver.findElement(By.id("code")).sendKeys("UOM12345678901234567890"); // Assuming max 10 chars
        driver.findElement(By.id("save")).click();

        // Assert error message
        Assert.assertTrue(driver.findElement(By.id("code-error")).isDisplayed());
    }

    @Test
    public void verifyDropdownValidation() {
        WebElement dropdown = driver.findElement(By.id("system-unit-base"));

        // Select invalid option (if dropdown allows typing)
        dropdown.sendKeys("InvalidOption");
        driver.findElement(By.id("save")).click();

        // Assert error message
        Assert.assertTrue(driver.findElement(By.id("system-unit-base-error")).isDisplayed());
    }

    @Test
    public void verifyResetFunctionality() {
        driver.findElement(By.id("code")).sendKeys("UOM002");
        driver.findElement(By.id("name-en")).sendKeys("Reset Test UOM");
        driver.findElement(By.id("name-ar")).sendKeys("اختبار إعادة");
        driver.findElement(By.id("short-name")).sendKeys("RT");
        driver.findElement(By.id("reset")).click();

        // Assert fields are cleared
        Assert.assertEquals(driver.findElement(By.id("code")).getAttribute("value"), "");
        Assert.assertEquals(driver.findElement(By.id("name-en")).getAttribute("value"), "");
        Assert.assertEquals(driver.findElement(By.id("name-ar")).getAttribute("value"), "");
        Assert.assertEquals(driver.findElement(By.id("short-name")).getAttribute("value"), "");
    }

    @Test
    public void verifyDuplicateEntryValidation() {
        driver.findElement(By.id("code")).sendKeys("UOM003");
        driver.findElement(By.id("name-en")).sendKeys("Duplicate UOM");
        driver.findElement(By.id("name-ar")).sendKeys("نسخة مكررة");
        driver.findElement(By.id("short-name")).sendKeys("DU");

        driver.findElement(By.id("save")).click();

        // Attempt to add the same UOM again
        driver.findElement(By.id("code")).sendKeys("UOM003");
        driver.findElement(By.id("name-en")).sendKeys("Duplicate UOM");
        driver.findElement(By.id("save")).click();

        // Assert duplicate error message
        Assert.assertTrue(driver.findElement(By.id("duplicate-error")).isDisplayed());
    }

    @Test
    public void verifyCancelButton() {
        driver.findElement(By.id("cancel")).click();

        // Assert navigation back to the UOM listing page
        Assert.assertEquals(driver.getCurrentUrl(), "https://mohamed.microtecdev.com:2050/inventory/masterdata/uom");
    }

    @Test
    public void verifyMultiLanguageSupport() {
        driver.findElement(By.id("name-en")).sendKeys("Test UOM");
        driver.findElement(By.id("name-ar")).sendKeys("اختبار وحدة");

        driver.findElement(By.id("save")).click();

        // Assert values saved correctly
        Assert.assertEquals(driver.findElement(By.id("name-en-display")).getText(), "Test UOM");
        Assert.assertEquals(driver.findElement(By.id("name-ar-display")).getText(), "اختبار وحدة");
    }

    @Test
    public void verifyInputTypeValidation() {
        driver.findElement(By.id("code")).sendKeys("Invalid@#"); // Assuming "Code" accepts alphanumeric only
        driver.findElement(By.id("save")).click();

        // Assert error message
        Assert.assertTrue(driver.findElement(By.id("code-error")).isDisplayed());
    }

    @Test
    public void verifyPaginationOrRecordAddition() {
        driver.findElement(By.id("code")).sendKeys("UOM005");
        driver.findElement(By.id("name-en")).sendKeys("Paginated UOM");
        driver.findElement(By.id("save")).click();

        // Navigate to the listing page and search for the new UOM
        driver.navigate().to("https://mohamed.microtecdev.com:2050/inventory/masterdata/uom");
        driver.findElement(By.id("search")).sendKeys("UOM005");

        // Assert record appears
        Assert.assertTrue(driver.findElement(By.xpath("//td[text()='UOM005']")).isDisplayed());
    }


    @Test
public void verifySpecialCharactersValidation() {
    driver.findElement(By.id("name-en")).sendKeys("Test@#UOM");
    driver.findElement(By.id("name-ar")).sendKeys("وحدة#@");

    driver.findElement(By.id("save")).click();

    // Assert error messages for invalid characters
    Assert.assertTrue(driver.findElement(By.id("name-en-error")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.id("name-ar-error")).isDisplayed());
}



@Test
public void verifyFactorFieldValidation() {
    driver.findElement(By.id("factor")).sendKeys("abc123");

    driver.findElement(By.id("save")).click();

    // Assert error message
    Assert.assertTrue(driver.findElement(By.id("factor-error")).isDisplayed());
}



@Test
public void verifyEmptyFactorField() {
    driver.findElement(By.id("code")).sendKeys("UOM010");
    driver.findElement(By.id("name-en")).sendKeys("Empty Factor");
    driver.findElement(By.id("name-ar")).sendKeys("عامل فارغ");
    driver.findElement(By.id("short-name")).sendKeys("EF");

    // Leave "Factor" field empty and try to save
    driver.findElement(By.id("save")).click();

    // Assert error message
    Assert.assertTrue(driver.findElement(By.id("factor-error")).isDisplayed());
}


@Test
public void verifyEditUOM() {
    // Navigate to an existing UOM record
    driver.findElement(By.xpath("//td[text()='UOM005']/following-sibling::td/button[text()='Edit']")).click();

    // Edit the UOM details
    WebElement nameEn = driver.findElement(By.id("name-en"));
    nameEn.clear();
    nameEn.sendKeys("Updated UOM");

    driver.findElement(By.id("save")).click();

    // Assert success message and updated record
    Assert.assertTrue(driver.findElement(By.id("success-message")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Updated UOM']")).isDisplayed());
}



@Test
public void verifyDeleteUOM() {
    // Navigate to an existing UOM record and click "Delete"
    driver.findElement(By.xpath("//td[text()='UOM005']/following-sibling::td/button[text()='Delete']")).click();

    // Confirm deletion
    driver.findElement(By.id("confirm-delete")).click();

    // Assert success message and verify record is removed
    Assert.assertTrue(driver.findElement(By.id("success-message")).isDisplayed());
    Assert.assertFalse(driver.findElements(By.xpath("//td[text()='UOM005']")).size() > 0);
}


@Test
public void verifyInvalidShortName() {
    driver.findElement(By.id("short-name")).sendKeys("123@#");

    driver.findElement(By.id("save")).click();

    // Assert error message
    Assert.assertTrue(driver.findElement(By.id("short-name-error")).isDisplayed());
}


@Test
public void verifyAddingMultipleUOMs() {
    for (int i = 1; i <= 3; i++) {
        driver.findElement(By.id("code")).sendKeys("UOM00" + i);
        driver.findElement(By.id("name-en")).sendKeys("Test UOM " + i);
        driver.findElement(By.id("name-ar")).sendKeys("اختبار وحدة " + i);
        driver.findElement(By.id("short-name")).sendKeys("T" + i);

        driver.findElement(By.id("save")).click();

        // Assert success message
        Assert.assertTrue(driver.findElement(By.id("success-message")).isDisplayed());
        driver.findElement(By.id("reset")).click();
    }
}


@Test
public void verifyCalculationFunctionality() {
    driver.findElement(By.id("code")).sendKeys("UOM011");
    driver.findElement(By.id("name-en")).sendKeys("Calculation Test");
    driver.findElement(By.id("name-ar")).sendKeys("اختبار حسابي");
    driver.findElement(By.id("short-name")).sendKeys("CT");
    driver.findElement(By.id("factor")).sendKeys("10");

    // Assuming a "Calculation" dropdown exists
    WebElement calculation = driver.findElement(By.id("calculation"));
    Select dropdown = new Select(calculation);
    dropdown.selectByVisibleText("Multiply");

    driver.findElement(By.id("save")).click();

    // Assert success message and verify saved details
    Assert.assertTrue(driver.findElement(By.id("success-message")).isDisplayed());
}


@Test
public void verifyPagination() {
    // Navigate to the UOM list page
    driver.get("https://mohamed.microtecdev.com:2050/inventory/masterdata/uom");

    // Click on the next page in pagination
    driver.findElement(By.xpath("//a[text()='2']")).click();

    // Assert records are displayed for the next page
    Assert.assertTrue(driver.findElement(By.xpath("//table/tbody/tr")).isDisplayed());
}


@Test
public void verifySearchFunctionality() {
    // Navigate to the UOM list page
    driver.get("https://mohamed.microtecdev.com:2050/inventory/masterdata/uom");

    // Enter search criteria
    driver.findElement(By.id("search")).sendKeys("UOM001");

    // Assert filtered results
    Assert.assertTrue(driver.findElement(By.xpath("//td[text()='UOM001']")).isDisplayed());
    Assert.assertFalse(driver.findElements(By.xpath("//td[not(text()='UOM001')]")).size() > 0);
}






}
