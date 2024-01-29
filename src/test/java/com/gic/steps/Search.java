package com.gic.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Search {
    WebDriver driver;

    @Given("User is on the Home page")
    public void user_is_on_the_home_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://3.13.126.58/AMS3.0");
        driver.findElement(By.id("inputEmail")).sendKeys("admin@gic.com");
        driver.findElement(By.id("inputPassword")).sendKeys("Admin123");
        driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div[2]/div/form/div[3]/div[2]/button")).click();
        driver.get("http://3.13.126.58/AMS3.0");
    }

    @When("User clicks on Products")
    public void user_clicks_on_products() {
        driver.findElement(By.xpath("/html/body/div[2]/div/nav/ul/li[3]/a")).click();
    }

    @Then("User should be able to see List products and Add product.")
    public void user_should_be_able_to_see_list_products_and_add_product() throws InterruptedException {
        String listProducts = "List Products";
        String expectedListProducts = driver.findElement(By.id("products_index")).getText();
        Assert.assertEquals(expectedListProducts, listProducts.trim());

        String addProduct = "Add Product";
        String expectedAddProducts = driver.findElement(By.id("products_add")).getText();
        Assert.assertEquals(expectedAddProducts, addProduct);

        driver.close();

    }
}

