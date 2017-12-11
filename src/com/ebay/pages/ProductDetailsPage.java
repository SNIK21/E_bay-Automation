package com.ebay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage {
	
	
	
	protected static WebDriver driver;
	
	private static By productdetails=By.xpath(".//*[@id='prcIsum']");
	private static By addtocart=By.xpath(".//*[@id='isCartBtn_btn']");
	private static By productdetails1=By.xpath(".//*[@id='itemTitle']");
	private static By itemcondition=By.xpath(".//*[@id='vi-itm-cond']");
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
	}
	public void productDetails(){
		WebElement cartbutton=driver.findElement(productdetails);
		String productinfo=cartbutton.getText();
		WebElement name=driver.findElement(productdetails1);
		String productinfo1=name.getText();
		WebElement item=driver.findElement(itemcondition);
		String productinfo2=item.getText();
	}
public void addToCart(){
		WebElement cartbutton=driver.findElement(addtocart);
		cartbutton.click();
	}

/*public boolean verifyProductPage() {
	// TODO Auto-generated method stub
	return false;
}*/

	
}
