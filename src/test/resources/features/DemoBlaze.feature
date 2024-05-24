
@DemoBlaze
Feature: Validate Add to cart functionality in DemoBlaze website
 
  @DashboardDetailsCheck @UserStory_US123 @SIT
  Scenario Outline: Verify add product to cart functionality by adding given product
    Given User is logged into demoblaze website with username "<userName>" and password "<Password>"
    Then User verifies Username "<userName>" in dashboard
    Then User adds "<monitor>" to cart and verifies
 
    Examples:
      | userName    | Password    | monitor          |
      | SathishDemo | SathishDemo | Apple monitor 24 |
 
  @loginFlipkart
  Scenario Outline: Login into flipkart website
    Given User launches Flipkart application and loggs in with Username "<username>" and Password "<password>"
 
    Examples:
      | username | password |
      | Sathish  |   123456 |
 