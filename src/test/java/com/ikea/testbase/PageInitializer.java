package com.ikea.testbase;

import com.ikea.pages.HomePageElements;

public class PageInitializer extends BaseClass {

	
//		Create path like that.
//		public static LoginPageElements loginPage; 

	public static HomePageElements homePage;

	


	public static void initialize() {

//	Don't forget initialize your page..
//	loginPage = new LoginPageElements();

		homePage = new HomePageElements();
		

	}
}
