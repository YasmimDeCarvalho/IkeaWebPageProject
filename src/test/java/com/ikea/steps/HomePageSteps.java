package com.ikea.steps;

import org.junit.Assert;

import com.ikea.util.CommonMethods;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class HomePageSteps extends CommonMethods{
	
	@Given("user is taken to homepage and verifying tittle")
	public void user_is_taken_to_homepage_and_verifying_tittle() {
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Shop Affordable Home Furnishings & Home Goods - IKEA";
	   
	   Assert.assertEquals(expectedTitle, actualTitle);
		
	
	}
	
	
	@Given("user will search for a Product and verify products are displayed")
	public void user_will_search_for_a_product_and_verify_products_are_displayed() {
	   sendText(homePage.ikeaSearchBar, "Chairs");
	   click(homePage.ikeaSeachButton);
	   wait(2);
	   System.out.println(homePage.ikeaSearchContentHeader.getText());
		
	}
	
	
	@Given("user will navigate to a Product Category")
	public void user_will_navigate_to_a_product_category() {
		
		click(homePage.ikeaCategory,"Products");
		wait(1);
		click(homePage.ikeaProductList,"Offers");
		wait(2);
	    
		
	}
	
	
	@And("Click on Offers category and verify that the correct page is displayed.")
	public void click_on_offers_category_and_verify_that_the_correct_page_is_displayed() {
	    
		waitForVisibility(homePage.ikeaOffersDropdown);
		Assert.assertEquals("Offers Dropdown IS NOT Displayed.",homePage.ikeaOffersDropdown.isDisplayed(), true);
		wait(1);
	}

}
