package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompanyPage {
    private WebDriver driver;
    private By companyNameHeader = By.id("lblCName");
    private By companyDesciption = By.id("company-Description");
    private By companyHolder = By.id("companyholder");

    public CompanyPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean companyDescriptionIsPresent() {
        return driver.findElement(companyDesciption).isDisplayed();
    }

    public boolean companyDescriptionHasCompanyContent(String companyName) {
        return driver.findElement(companyDesciption).getText().contains(companyName);
    }

    public boolean correctCompanyPage(String companyName) {
        return driver.findElement(companyNameHeader).getText().contains(companyName);
    }

    public List<String> getAllHeaders() {
        List<WebElement> elements = driver.findElement(companyHolder).findElements(By.cssSelector(".row.DivHead"));

        List<String> allHeaders = new ArrayList<>();
        String header = "";
        for (WebElement webelement : elements) {
            List<WebElement> elements2 = webelement.findElements(By.cssSelector(".col-lg-12"));
            for (WebElement webelement2 : elements2) {
                List<WebElement> elements3 = webelement2.findElements(By.cssSelector(".row"));
                for (WebElement webelement3 : elements3) {
                    List<WebElement> elements4 = webelement3.findElements(By.cssSelector(".col-lg-8"));
                    for (WebElement webelement5 : elements4) {
                        List<WebElement> elements5 = webelement5.findElements(By.cssSelector(".box-title"));
                        for (WebElement webelement6 : elements5) {
                            header = webelement6.getText().trim();
                            allHeaders.add(header);
                        }
                    }
                }
            }
        }

        allHeaders.removeAll(Arrays.asList("", " ", null));
        return allHeaders;
    }
}
