
package com.test.SelinumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
    public static void main( String[] args )
    {
       
    	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/java/driver/chromedriver.exe");
    	
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://www.fb.com");
    	
    	
    	
    }
}
