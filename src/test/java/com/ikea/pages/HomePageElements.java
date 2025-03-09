package com.ikea.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ikea.util.CommonMethods;

public class HomePageElements extends CommonMethods{
	
	
	@FindBy(id="ikea-search-input")
	public WebElement ikeaSearchBar;
	
	@FindBy(id="search-box__searchbutton")
	public WebElement ikeaSeachButton;
	
	@FindBy(xpath="//main[@id='content']//div[@class='plp-content-container']/p")
	public WebElement ikeaSearchContentHeader;
	
	@FindBy(xpath="//div[@class='hnf-tabs']//div//div//div/button")
	public List<WebElement> ikeaCategory;
	
	@FindBy(xpath="//div[@id='hnf-carousel__tabs-navigation-products']/div")
	public List<WebElement> ikeaProductList;
	
	@FindBy(xpath="//div[@id='tab-products']//ul")
	public WebElement ikeaOffersDropdown;
	
	
	
	
	public HomePageElements() {
		
		PageFactory.initElements(driver, this);
	}

}
