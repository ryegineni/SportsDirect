Feature: As a end user i am able to search products from search field
Background:I am on sportsdirect.com  home page
    When I launch "https://www.sportsdirect.com/" 
    Then I verify i am on sportsdirect home page

Scenario:Verify that i am able to print the prices of first 10 items
		When I enter "sports shoes" in search field
		And select one of the autosuggestion from the options
		Then I verify i am on the search page
		When I sort search results by "Price (Low To High)"
		Then I print prices of top 10 products 
