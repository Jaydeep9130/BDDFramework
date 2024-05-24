@njewelth
Feature: Nj E Welth login
 
Scenario Outline: Verify the given login detailes
Given User is logged in nj e welth app <UserName>
When Custmers logged in successfully
Then Click on Mutual fund button
 
Examples:
	 |UserName|
	|Jaydeep9130|