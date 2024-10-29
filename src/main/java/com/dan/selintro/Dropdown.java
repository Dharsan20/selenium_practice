package com.dan.selintro;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
    public static void main(String[] args) throws InterruptedException {
        
 WebDriver driver=new ChromeDriver();

    driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); 

    //#static dropdown

    //WebElement staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

    // Select dropdown = new Select(staticdropdown);

       //   dropdown.selectByIndex(3);

    //        System.out.println(dropdown.getFirstSelectedOption().getText());

    //        dropdown.selectByValue("AED");

    //        System.out.println(dropdown.getFirstSelectedOption().getText());

    //        dropdown.selectByVisibleText("INR");

    //        System.out.println(dropdown.getFirstSelectedOption().getText());
   
     
//     driver.findElement(By.id("divpaxinfo")).click();
//     Thread.sleep(5000);
//     int i=1;
//     while (i<5) {
//     driver.findElement(By.id("hrefIncAdt")).click();
//     i++;     
//     }  
   
//     driver.findElement(By.id("btnclosepaxoption")).click();
    
// }

// //#Dynamic DropDown
// driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

// driver.findElement(By.xpath("//a[@value='CJB']")).click();

// driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();

// Thread.sleep(2000);
// driver.findElement(By.xpath("(//a[@value='GOI'])[2]")).click();


// # Auto suggestive dropdown

driver.findElement(By.id("autosuggest")).sendKeys("am");
Thread.sleep(3000);
List<WebElement> countries=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

for (WebElement country:countries)
{
    if (country.getText().equalsIgnoreCase("bahamas")) {
        country.click();
        break;       
    }
    //System.out.println(country.getText());
   
}

    }

    
}
