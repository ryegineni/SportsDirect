package com.sportsDirect.bdd.step_def;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SportsDirectStepDefs extends PageObjectInit {
	@When("^I launch \"([^\"]*)\"$")
	public void i_launch_website(String arg1) throws Throwable {
		driver.get(arg1);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Then("^I verify i am on sportsdirect home page$")
	public void i_verify_i_am_on_sportsdirect_home_page() throws Throwable {
		sports.clickCloseBtn();
		Thread.sleep(3000);
		Assert.assertTrue(sports.logoDisplay());
	}

	@When("^I enter \"([^\"]*)\" in search field$")
	public void i_enter_in_search_field(String arg1) throws Throwable {
		sports.enterSearchKeyword(arg1);
		Thread.sleep(3000);
	}

	@When("^select one of the autosuggestion from the options$")
	public void select_one_of_the_autosuggestion_from_the_options() throws Throwable {
		sports.clickSearchAutoSugg();
	}

	@Then("^I verify i am on the search page$")
	public void i_verify_i_am_on_the_search_page() throws Throwable {
		Assert.assertEquals("Search Results", sports.getSearchResultsTxt());
	}

	@When("^I sort search results by \"([^\"]*)\"$")
	public void i_sort_search_results_by(String arg1) throws Throwable {
		sports.sortOptions(arg1);
		Thread.sleep(3000);
	}

	@Then("^I print prices of top (\\d+) products$")
	public void i_print_prices_of_top_products(int arg1) throws Throwable {
		sports.printProdPrices(arg1);
	}

}
