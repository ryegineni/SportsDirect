package com.sportsDirect.bdd.pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class SportsDirectPage {
	public SportsDirectPage(WebDriver driver) {

		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);

	}

	@FindBy(xpath = "	//button[@data-dismiss='modal']")
	private List<WebElement> closeBtn;

	@FindBy(id = "dnn_dnnLogo_imgSDLogo")
	private WebElement logo;

	@FindBy(xpath = "//input[@id='txtSearch']")
	private WebElement searchField;

	@FindBy(css = ".ui-menu-item")
	private List<WebElement> searchAutoSugg;

	@FindBy(id = "dnn_ctr178840_ViewTemplate_ctl00_CategoryHeaderTop_lblCategoryHeader")
	private WebElement searchResultsTxt;

	@FindBy(id = "dnn_ctr178840_ViewTemplate_ctl00_sortOptions1_ddlSortOptions")
	private WebElement sortByDropdown;

	@FindBy(css = ".s-largered")
	private List<WebElement> itemPrice;

	public void clickCloseBtn() {
		closeBtn.get(1).click();
	}

	public boolean logoDisplay() {
		return logo.isDisplayed();
	}

	public void enterSearchKeyword(String keyword) throws InterruptedException {
		searchField.sendKeys(keyword);
		Thread.sleep(3000);
		searchField.sendKeys(Keys.BACK_SPACE);
		
	}

	public void clickSearchAutoSugg() {
		searchAutoSugg.get(0).click();
	}

	public String getSearchResultsTxt() {
		return searchResultsTxt.getText().trim();
	}

	public void sortOptions(String optType) {
		Select sortDropdown = new Select(sortByDropdown);
		sortDropdown.selectByVisibleText(optType);
	}

	public void printProdPrices(int no) {
		for (int i = 0; i < no; i++) {
			System.out.println("Item " + (i + 1) + "price=" + itemPrice.get(i).getText().trim());
		}
	}
}
