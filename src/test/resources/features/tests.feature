Feature: Retail website tests

Background:
  Given I am on the retail homepage
  And click Sign
  And Login to My Account

  Scenario: Update personal information
    When select MyPersonalInformation and update firstname to "TesterFirstName"
    Then update is success

    Scenario: Order T-Shirt and verify Order History
       When I select T-SHIRTS section
      And add the first tshirt to cart
      And proceed to checkout
      And verify the item price "$16.51" in summary page
      And proceed to Address section
      And proceed to Shipping section and accept Terms of service
      And proceed to Payment section
      And click Pay by bank wire and confirm the order
      Then order is successful
      And navigate to order history and verify the order
