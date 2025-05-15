package com.mystore.actiondriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import com.mystore.base.BaseClass;

public class Action {
	
	public static void doClick(WebDriver driver, WebElement ele) {
	    try {
	        if (ele.isDisplayed()) {
	            Actions act = new Actions(driver);
	            act.moveToElement(ele).click().build().perform();
	        } else {
	            System.out.println("Element is not visible to click.");
	        }
	    } catch (Exception e) {
	        System.out.println("Unable to click on element: " + e.getMessage());
	    }
	}
	public static boolean doSendKeys(WebElement ele, String value) {
	    try {
	        if (ele.isDisplayed()) {
	            ele.clear();
	            ele.sendKeys(value);
	            return true;
	        }
	    } catch (Exception e) {
	        System.out.println("Unable to send keys: " + e.getMessage());
	    }
	    return false;
	}
	public static boolean isElementPresent(WebElement ele) {
	    try {
	        return ele.isDisplayed();
	    } catch (NoSuchElementException e) {
	        return false;
	    } catch (Exception e) {
	        return false;
	    }
	}
	public static boolean isDisplayed(WebElement ele) {
	    try {
	        boolean flag = ele.isDisplayed();
	        System.out.println(flag ? "The element is Displayed" : "The element is not Displayed");
	        return flag;
	    } catch (Exception e) {
	        System.out.println("Element not displayed: " + e.getMessage());
	        return false;
	    }
	}
	public static boolean sendKeysIfPrefilledMatchesOrFill(WebElement ele, String value) {
	    try {
	        if (ele != null && ele.isDisplayed() && ele.isEnabled()) {
	            String existingValue = ele.getAttribute("value");
	            if (existingValue != null && existingValue.equals(value)) {
	                System.out.println("Field already prefilled with the correct value: " + existingValue);
	                return true;  // No action needed, already correct
	            } else {
	                ele.clear();
	                ele.sendKeys(value);
	                System.out.println("Field value set to: " + value);
	                return true;
	            }
	        } else {
	            System.out.println("Element is not interactable.");
	        }
	    } catch (Exception e) {
	        System.out.println("Exception while sending keys conditionally: " + e.getMessage());
	    }
	    return false;
	}
	
	public static void explicitWait(WebDriver driver, WebElement element, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
	  

