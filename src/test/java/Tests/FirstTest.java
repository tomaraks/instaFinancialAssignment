package Tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CompanyPage;

import java.util.ArrayList;
import java.util.List;

public class FirstTest extends BaseTest {

    private final List<String> headerNames = new ArrayList<>();

    @BeforeClass
    public void setUpForClass() {
        headerNames.add("Company Highlights");
        headerNames.add("KYC Infomation");
        headerNames.add("Industry Classification");
        headerNames.add("Credit Ratings ( available for last 24 months)");
        headerNames.add("Directors Detail");
        headerNames.add("Signatories Details");
        headerNames.add("Past Directors / Past Signatories");
        headerNames.add("Potential Related Party");
        headerNames.add("Open Charges / Borrowings");
        headerNames.add("Locations");
        headerNames.add("Employment Trend (₹ in lakhs)");
        headerNames.add("Directors Info and Other Directorships");
    }

    @DataProvider(name = "Company Names")
    public static Object[] companyNamesDP() {

        return new Object[]{"ITC CLASSIC FINANCE LTD", "ITC AGRO-TECH FINANCE AND INVESTMENTS LTD", "ITC BHADRACHALAM PAPER BOARDS LIMITED", "ITC CLASSIC FUNDS MANAGEMENT LTD",
                "ITC CLASIC AGENCIES & TRUSTEES LTD", "AGC APPS PRIVATE LIMITED", "AGC ASIA PACIFIC (INDIA) PRIVATE LIMITED",
                "AGC CONSULTING AND HOLDINGS PRIVATE LIMITED", "GOOGLE CAPITAL ADVISORS INDIA PRIVATE LIMITED", "GOOGLE CLOUD INDIA PRIVATE LIMITED", "ITC CLASSIC FINANCE LTD", "ITC AGRO-TECH FINANCE AND INVESTMENTS LTD", "ITC BHADRACHALAM PAPER BOARDS LIMITED", "ITC CLASSIC FUNDS MANAGEMENT LTD",
                "ITC CLASIC AGENCIES & TRUSTEES LTD", "AGC APPS PRIVATE LIMITED", "AGC ASIA PACIFIC (INDIA) PRIVATE LIMITED",
                "AGC CONSULTING AND HOLDINGS PRIVATE LIMITED", "GOOGLE CAPITAL ADVISORS INDIA PRIVATE LIMITED", "GOOGLE CLOUD INDIA PRIVATE LIMITED", "ITC CLASSIC FINANCE LTD", "ITC AGRO-TECH FINANCE AND INVESTMENTS LTD", "ITC BHADRACHALAM PAPER BOARDS LIMITED", "ITC CLASSIC FUNDS MANAGEMENT LTD",
                "ITC CLASIC AGENCIES & TRUSTEES LTD", "AGC APPS PRIVATE LIMITED", "AGC ASIA PACIFIC (INDIA) PRIVATE LIMITED",
                "AGC CONSULTING AND HOLDINGS PRIVATE LIMITED", "GOOGLE CAPITAL ADVISORS INDIA PRIVATE LIMITED", "GOOGLE CLOUD INDIA PRIVATE LIMITED",
                "ITC CLASIC AGENCIES & TRUSTEES LTD", "AGC APPS PRIVATE LIMITED", "AGC ASIA PACIFIC (INDIA) PRIVATE LIMITED",
                "AGC CONSULTING AND HOLDINGS PRIVATE LIMITED", "GOOGLE CAPITAL ADVISORS INDIA PRIVATE LIMITED", "GOOGLE CLOUD INDIA PRIVATE LIMITED"};
    }

    @Test(dataProvider = "Company Names")
    public void verifyCompanyContent(String companyName) {
        CompanyPage companyPage = homePage.searchCompanyName(companyName);
        Assert.assertTrue(companyPage.correctCompanyPage(companyName), "Wrong Page!!!!");
        List<String> getAllHeader = new ArrayList<>(companyPage.getAllHeaders());
        Assert.assertEquals(headerNames, getAllHeader, "Header Names Didn't Matched");
    }
}
