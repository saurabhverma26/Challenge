package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class Test1 {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
         driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.t-mobile.com/tablets");
        Thread.sleep(5000);
        selectFilter("Brands", "Apple");
        selectFilter("Deals", "All");
        selectFilter("Operating System", "all");
    }


   public static void selectFilter(String brandName, String... values){
        By header = By.xpath("//legend[normalize-space()='"+brandName+"']");
        driver.findElement(header).click();
       for (String value: values) {
           if (value.equalsIgnoreCase("all")){
              List<WebElement> options =  driver.findElements(By.xpath("//legend[normalize-space()='"+brandName+"']/ancestor::mat-expansion-panel-header/following-sibling::div//label[contains(@class,'mat-checkbox')]"));
               for (WebElement e:options) {
                   e.click();
               }
               break;
           }
           else {
               By valueLocator = By.xpath("//span[normalize-space()='"+value+"']/ancestor::label");
               driver.findElement(valueLocator).click();
           }
       }
    }


}
