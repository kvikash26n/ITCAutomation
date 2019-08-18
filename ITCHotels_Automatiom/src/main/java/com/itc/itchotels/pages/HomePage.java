/**
 * 
 */
package com.itc.itchotels.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.itc.itchotels.baseP.TestBase;



/**
 * @author 29265
 * kumar vikash
 *
 */
public class HomePage extends TestBase {

	

	@FindBy(id = "stayat_txt")
	@CacheLookup
	WebElement chooseDestination;
	

	@FindBy(xpath = "//*[@class='search-btn']")
	WebElement BtnSearch;
	
	/*@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;*/
	
	// Initializing the Page Objects:
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		public String verifyHomePageTitle(){
			return driver.getTitle();
		}
		public boolean verifysearchButton(){
			return BtnSearch.isDisplayed();
		}

}
