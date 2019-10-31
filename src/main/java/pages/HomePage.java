package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Optional;

public class HomePage {

    private WebDriver driver;
    private By dropdown = By.id("txtCompanySearch");
    private By dropdownList = By.id("compSearchResults");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public CompanyPage searchCompanyName(String company) {
        enterName(company);
        selectFromDropDownByOther(company);
        return new CompanyPage(driver);
    }

    private void selectFromDropDown(String option) {
        findDropDownElement().selectByVisibleText(option);
    }

    private void selectFromDropDownByOther(String option) {
        if(findDropDownElementByOther(option).isPresent()) {
            WebElement webElement = findDropDownElementByOther(option).get();
            webElement.click();
        }
        else {
            System.out.println("Dropdown Option Not Found!!");
        }
    }

    private Select findDropDownElement() {
        return new Select(driver.findElement(dropdownList));
    }

    private Optional<WebElement> findDropDownElementByOther(String other) {
        return driver.findElements(dropdownList).stream().filter(webElement -> webElement.getText().contains(other)).findFirst();
    }

    private void enterName(String companyName) {
        driver.findElement(dropdown).sendKeys(companyName);
    }

}
