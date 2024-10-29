package com.dan.selintro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locator {
   
  public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();


    String name="rahul";

    WebDriver driver=new ChromeDriver();
    
    driver.get("https://rahulshettyacademy.com/locatorspractice/"); 
    driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
driver.findElement(By.cssSelector("input[name$='inputPassword']")).sendKeys("rahulshettyacademy");
driver.findElement(By.cssSelector("#chkboxOne")).click();
driver.findElement(By.cssSelector("#chkboxTwo")).click();
driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

Thread.sleep(3000);

System.out.println(driver.findElement(By.tagName("p")).getText());
Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");

Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Hello "+name+",");

driver.findElement(By.xpath("//button[text()='Log Out']")).click();
driver.close();
}
}
