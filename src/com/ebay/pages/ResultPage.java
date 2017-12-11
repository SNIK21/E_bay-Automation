package com.ebay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage {
	
	private static By nextbutton=By.xpath(".//*[@id='AnswersModule']/div/div[2]/nav/ul/li[4]/a/div");
	protected static WebDriver driver;

	public ResultPage(WebDriver driver) {
		this.driver = driver;
	}
	public void nextPageClick() {
		WebElement next = driver.findElement(nextbutton);
	    next.click();
}
}
