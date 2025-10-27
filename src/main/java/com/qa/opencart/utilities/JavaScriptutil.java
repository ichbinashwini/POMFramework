package com.qa.opencart.utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptutil {
	private WebDriver driver;
	private JavascriptExecutor js;

	public JavaScriptutil(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		
	}

	public void flash(WebElement element) {
		String bgcolor = element.getCssValue("backgroundColor");//grey
		for (int i = 0; i < 7; i++) {
			changeColor("rgb(0,200,0)", element);// green
			changeColor(bgcolor, element);// grey
		}
	}

	private void changeColor(String color, WebElement element) {
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}
	
	public void scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
	public void scrollToTop() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
	}
	/*
	 * // 1️⃣ Handling a simple alert (OK button)
	 * driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click()
	 * ; Alert simpleAlert = driver.switchTo().alert();
	 * System.out.println("Alert Text: " + simpleAlert.getText());
	 * simpleAlert.accept(); // Clicks OK Thread.sleep(1000);
	 * 
	 * // 2️⃣ Handling a confirmation alert (OK / Cancel)
	 * driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click
	 * (); Alert confirmAlert = driver.switchTo().alert();
	 * System.out.println("Confirm Text: " + confirmAlert.getText());
	 * confirmAlert.dismiss(); // Clicks Cancel Thread.sleep(1000);
	 * 
	 * // 3️⃣ Handling a prompt alert (input + OK / Cancel)
	 * driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click(
	 * ); Alert promptAlert = driver.switchTo().alert();
	 * System.out.println("Prompt Text: " + promptAlert.getText());
	 * promptAlert.sendKeys("Selenium Test"); // Enter text promptAlert.accept(); //
	 * Click OK Thread.sleep(1000);
	 */

}
