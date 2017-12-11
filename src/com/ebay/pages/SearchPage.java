package com.ebay.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage{
	
	private By searchtextarea = By.xpath("//*[@id='gh-ac']");
	private By searchbtn = By.id("gh-btn");
	private By nextbutton=By.xpath(".//*[@id='AnswersModule']/div/div[2]/nav/ul/li[4]/a/div");
	private By links=By.xpath("//a[@class='vip']");
	protected WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitle(){
		String title = driver.getTitle();
		
		return title;
	}
	public boolean verifySearchPageTitle() {
		String expectedPageTitle="eBay";
		return getPageTitle().contains(expectedPageTitle);
	}
	
	public void enterText(String searchText) {
		    WebElement text = driver.findElement(searchtextarea);
			text.sendKeys(searchText);
	}
	
	public void clickOnSearch() {
		 WebElement search = driver.findElement(searchbtn);
	     search.click();
	}

	/*public void nextPageClick() {
			WebElement next = driver.findElement(nextbutton);
		    next.click();
	}*/

	public void storelink() {
		
		List<WebElement>links1= driver.findElements(links);
		System.out.println("size is:" +links1.size());
	}


		
	

}
