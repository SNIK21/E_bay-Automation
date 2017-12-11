package com.ebay.actionmodule;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ebay.pages.ProductDetailsPage;
import com.ebay.pages.ResultPage;
import com.ebay.pages.SearchPage;
import com.ebay.pages.ShopingCartPage;
import com.ebay.setupmodule.BaseSetUp;

public class SearchPageAction extends BaseSetUp {
private WebDriver driver;
public String s1=excellread();
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	@Test(priority=1)
	public void verifyHomePage() {
		SearchPage searchPage = new SearchPage(driver);
		//System.out.println(searchPage.getPageTitle());
		Assert.assertTrue(searchPage.verifySearchPageTitle());
	}
	@Test(priority=2)
	public void enterText()
	{
		SearchPage searchPage = new SearchPage(driver);
		searchPage.enterText(s1);
	}
	@Test(priority=3)
	public void searchClick()
	{
		SearchPage searchPage = new SearchPage(driver);
		searchPage.clickOnSearch();
	}
	@Test(priority=4)
	public void storeLinkFisrPage()
	{
		List<WebElement> links=driver.findElements(By.xpath("//a[@class='vip']"));
		System.out.println(links.size()); 
		int x=links.size();
	}
	@Test(priority=5)
	public void nextPage()
	{
		ResultPage resultPage = new ResultPage(driver);
		resultPage.nextPageClick();
	}
	@Test(priority=6)
	public void storeLinkNextPage()
	{
		List<WebElement> links=driver.findElements(By.xpath("//a[@class='vip']"));
		System.out.println("size"+links.size()); 			
	}
	@Test(priority=7)
	public void linkcompare(){
		List<WebElement> links=driver.findElements(By.xpath("//a[@class='vip']"));
		List<WebElement> links1=driver.findElements(By.xpath("//a[@class='vip']"));
		 //Assert.assertTrue(links.equals(links1));
		System.out.println(links.equals(links1));
		
	}
	@Test(priority=8)
	public void randomSelection() throws InterruptedException
	{	
		List<WebElement> links=driver.findElements(By.xpath("//a[@class='vip']"));
		System.out.println("size is "+links.size()); 
		int x=links.size();
		Random rand = new Random();
		int random=rand.nextInt(x);
		WebElement  bodyText = links.get(random);
		bodyText.click();
		Thread.sleep(8000);
		}	
	/*@Test(priority=9)
	public void verifyProductDetailPage() {
		ProductDetailsPage pdp=new ProductDetailsPage(driver);
		//System.out.println(searchPage.getPageTitle());
		Assert.assertTrue(pdp.verifyProductPage());
	}*/
	@Test(priority=10)
	public void productDetails(){
		ProductDetailsPage pdp=new ProductDetailsPage(driver);
		pdp.productDetails();
		//String s2=driver.findElement(By.xpath(".//*[@id='prcIsum']")).getText();
		//System.out.println(s2);
	}
	@Test(priority=11)
	public void addCart()
	{
		//driver.findElement(By.xpath(".//*[@id='isCartBtn_btn']")).click();
		ProductDetailsPage pdp=new ProductDetailsPage(driver);
		pdp.addToCart();
		
	}
	@Test(priority=12)
	public void verifyCart()
	{
		ShopingCartPage shopingcart=new ShopingCartPage();
		shopingcart. verifyShopingCart();
		//String cartdetails =driver.findElement(By.xpath(".//*[@id='PageTitle']/h1")).getText();
		//Assert.assertEquals("Your eBay Shopping Cart", cartdetails);	
	}
	@Test(priority=13)
	public void verifycheckout()
	{
		ShopingCartPage shopingcart=new ShopingCartPage();
	    shopingcart. verifyShopingCart();
	    shopingcart. cartCheckout();
			
	}	
	@Test(priority=14)
	public void verifyguestCheckout()
	{
		driver.findElement(By.xpath(".//*[@id='gtChk']")).click();
		String guestcheckout=driver.findElement(By.xpath("html/body/h1")).getText();
		Assert.assertEquals("Guest checkout", guestcheckout);
	}
	
}	



