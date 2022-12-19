package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class P03_homePage {
    public WebElement currency() {
        WebElement currency = Hooks.driver.findElement(By.id("customerCurrency"));
        Select select = new Select(currency);
        select.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");
        return currency;
    }
public void productsPrice(){
    WebElement price_span = Hooks.driver.findElement(By.xpath("//span[@class='price actual-price']"));
    new Actions(Hooks.driver).scrollToElement(price_span).perform();
    WebElement firstResult = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='price actual-price']")));


    for(int i=0;i<4;i++)
    {
        String list=Hooks.driver.findElements(By.xpath("//span[@class='price actual-price']")).get(i).getText();
        System.out.println(list);
        Assert.assertTrue(list.contains("€"));
    }
}

//    public List<WebElement> productsPrice() throws InterruptedException {
//        Thread.sleep(2000);
//
//        List<WebElement> productsPrice = productsPrice();
//
//        if (!productsPrice.isEmpty()){
//            for (WebElement product : productsPrice) {
//                System.out.println(product.getText());
//                Assert.assertTrue(product.getText().contains("€"));
//            }
//        }
//        return Hooks.driver.findElements(By.xpath("//span[@class='price actual-price']"));
//    }
// Search_Feature
    public WebElement searchBox(){
        WebElement searchBox = Hooks.driver.findElement(By.id("small-searchterms"));

        return searchBox;
    }
    public WebElement searchBtn(){
        WebElement searchBtn = Hooks.driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        return searchBtn;
    }
    public String searchUrl() {
        String searchUrl = Hooks.driver.getCurrentUrl();
        return searchUrl;
    }

    public List<WebElement> productsTitles() {
        return Hooks.driver.findElements(By.xpath("//h2[@class='product-title']//a"));
    }
    public void search_Result_Count(String name)
    {
        WebElement searchResult = Hooks.driver.findElement(By.xpath("//div[@class='search-results']"));
        new Actions(Hooks.driver).scrollToElement(searchResult).perform();

        int search_Count=Hooks.driver.findElements(By.xpath("//h2[@class='product-title']")).size();
        System.out.println("Search count is " +search_Count);
        for (int i=0;i<search_Count;i++)
        {
            String search_Result = Hooks.driver.findElements(By.xpath("//h2[@class='product-title']")).get(i).getText().toLowerCase();
            System.out.println("Search result is "+i+" : "+search_Result);
            System.out.println("Product Name "+i+" : "+name);
            SoftAssert soft = new SoftAssert();
            soft.assertTrue(search_Result.contains(name));

        }
    }

    public WebElement skuLabel() {
        return Hooks.driver.findElement(By.xpath("//div[@class='sku']//span[@class='value']"));
    }

    //F05_ Hover Categories (electronics)
    public void categoriesMenu() throws InterruptedException {
        Actions actions = new Actions(Hooks.driver);
        // hover on "electronics"
        WebElement electronics = Hooks.driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/electronics\"]"));
        actions.moveToElement(electronics).perform();
        Thread.sleep(3000);
    }
    public void clickSubCategory(){
        WebElement cellPhones = Hooks.driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/cell-phones\"]"));

        cellPhones.click();
    }



   public void verifyTitle(){
       WebElement pageTitle=Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"] h1"));
       String expectedTitle="cell phones";
       String actualTitle= pageTitle.getText().toLowerCase().trim();
       System.out.println("actual Title"+ actualTitle);
       System.out.println("expected Title"+ expectedTitle);
   }
    //F06_ Home Sliders

    public WebElement Slider_1(){
        return Hooks.driver.findElement(By.className("nivoSlider"));
    }

    public WebElement Slider_2(){
        return Hooks.driver.findElement(By.className("nivoSlider"));
    }
    // Follow Us Methods
    public WebElement followUsLinks(String socialMedia){
        return Hooks.driver.findElement(By.className(socialMedia));
    }
    public String url() {
        return Hooks.driver.getCurrentUrl();
    }
    //Wishlist methods
    public WebElement getItemWishList(){
        return Hooks.driver.findElement(By.cssSelector(".item-box:nth-child(3) .add-to-wishlist-button"));
    }
    public WebElement getSuccessMsg() {
        return Hooks.driver.findElement(By.className("content"));
    }

    public String getMessageBkColor() {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]")).getCssValue("background-color");
    }

    public WebElement openWishlist() {
        return Hooks.driver.findElement(By.className("ico-wishlist"));
    }

    public WebElement verifyQuantity() {
        return Hooks.driver.findElement(By.className("qty-input"));
    }
    public WebElement poorRadio(){
        WebElement poorRadio = Hooks.driver.findElement(By.id("pollanswers-3"));
        return poorRadio;
    }
    public WebElement pressVote(){
        return Hooks.driver.findElement(By.id("vote-poll-1"));
    }
    public WebElement errorMsg(){
        return Hooks.driver.findElement(By.id("block-poll-vote-error-1"));
    }
}

