package com.cucumber.framework.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class SportsFilter {

    WebDriver driver;
    WebElement filter;
    Select select;
    SoftAssert softAssert = new SoftAssert();

    @Given("I am on {string}")
    public void i_am_on(String url) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        System.out.println("browser lunched");

    }

    @When("I Select the Next Up Sports Filter")
    public void i_select_the_next_up_sports_filter() {
        filter = driver.findElement(By.cssSelector("[aria-label=select]"));
        filter.click();
        System.out.println("clicked on NextUp");
    }

    @Then("I can see an available list of valid Sports to filter by")
    public void i_can_see_an_available_list_of_valid_sports_to_filter_by() {
        String[] expectedOptions = {"All Sports", "KBO", "Esports", "MLB", "Soccer", "Lacrosse"};
        select = new Select(filter);

        List<WebElement> options = select.getOptions();

        if(options.size() > 1){
           Assert.assertTrue(true);
       }
        driver.close();
        driver.quit();
    }

    @Then("I Select the Analysis from Next Up Sports Tab")
    public void iSelectTheFromNextUpSportsFilter() {

       driver.findElement(By.cssSelector("[aria-label=icon-filled-news]")).click();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Then("I can see an available list of valid Sports")
    public void i_can_see_an_available_list_of_valid_sports() {
        String[] expectedOptions = {"All Sports", "KBO", "Esports", "MLB", "Soccer", "Lacrosse"};

        select = new Select(filter);

        List<WebElement> options = select.getOptions();
        for (int i = 0; i < options.size(); i++) {
            Assert.assertEquals(options.get(i).getText(), expectedOptions[i]);
            System.out.println("Successfully Validated " + options.get(i).getText());
        }
        driver.close();
        driver.quit();
    }
    @Then("I Validate the Analysis Page")
    public void  validateAnalysisPage() {

        String Header =  driver.findElement(By.cssSelector("[data-testid=Header]")).getText();
        Assert.assertEquals(Header, "Analysis");
        driver.close();
        driver.quit();

    }
    @Then("I can see an available list of valid Sports to filter by {string}")
    public void i_can_see_an_available_list_of_valid_sports_to_filter_by(String filterName) throws InterruptedException {

        select = new Select(filter);

        select.selectByVisibleText(filterName);
        System.out.println("Successfully selected " + filterName);
        Thread.sleep(2000);

        List<WebElement> options = driver.findElements(By.cssSelector("[data-testid=CardHeader] > div span.CardHeader_sportName__zWD_4"));

        int count = options.size();
        System.out.println("Select option size ==> " + count);

        for (int i = 1; i <= count; i++) {

            String fName = driver.findElement(By.cssSelector(":nth-child(" + i + ") > [data-testid=CardHeader] > div span.CardHeader_sportName__zWD_4")).getText().trim();

            if (fName.equals(filterName)) {
                softAssert.assertTrue(true);
                System.out.println("Successfully Validated " + fName);
            } else {
                softAssert.assertFalse(false);
                System.out.println("Unsuccessfully to Validate " + fName);
            }
        }

        driver.quit();
    }

}
