package com.dan.selintro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

;

public class Navigatio {
     public static void main(String[] args){
 
    WebDriver driver=new ChromeDriver();

    driver.get("https://talentx.kgisl.com/Home/Index"); 
    driver.navigate().to("https://mail.kgisl.co.in/#1");
    driver.navigate().back();
}
}