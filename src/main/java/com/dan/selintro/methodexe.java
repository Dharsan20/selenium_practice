package com.dan.selintro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class methodexe {
    
     public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
   // WebDriverManager.edgedriver().setup();
   //WebDriverManager.firefoxdriver().setup();

    WebDriver driver=new ChromeDriver();
    
    driver.get("https://rahulshettyacademy.com/locatorspractice/");

   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
   
  String password = getpassword(driver);
  driver.findElement(By.cssSelector(".go-to-login-btn")).click();
  driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
driver.findElement(By.cssSelector("input[name$='inputPassword']")).sendKeys(password);
driver.findElement(By.cssSelector("#chkboxOne")).click();  
driver.findElement(By.cssSelector("#chkboxTwo")).click();
driver.findElement(By.cssSelector(".submit.signInBtn")).click();
}


public static String getpassword(WebDriver driver) throws InterruptedException{

    driver.findElement(By.linkText("Forgot your password?")).click();
    Thread.sleep(2000);

driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

String passwordname=driver.findElement(By.cssSelector("form p")).getText();

String[] passwordsplit=passwordname.split("'");

String passwordgen=passwordsplit[1].split("'")[0];
return passwordgen;

}

}
