Feature: Verify cart functionality in sacuedemo website 

Scenario: Verify add to cart button is working
Given User is logged in and on the product page
When User adds multiple products to cart
Then cart icon should display the total number of items added



