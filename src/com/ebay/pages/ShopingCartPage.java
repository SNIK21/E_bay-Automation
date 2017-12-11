package com.ebay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ShopingCartPage {
	protected static WebDriver driver;
	private static By shopingcartdetails=By.xpath(".//*[@id='PageTitle']/h1");
	private static By checkoubutton=By.xpath(".//*[@id='ptcBtnRight']");
	private static By checkoutverify=By.xpath(".//*[@id='sgnTab']/span[2]");
	
	public void verifyShopingCart()
	{
		String cartdetails =driver.findElement(shopingcartdetails).getText();
		Assert.assertEquals("Your eBay Shopping Cart", cartdetails);	
	}
	public void cartCheckout()
	{
		driver.findElement(By.xpath(".//*[@id='ptcBtnRight']")).click();
		String checktext=	driver.findElement(checkoutverify).getText();
		Assert.assertEquals("Sign in", checktext);	
	}
	
	
	
}
