Feature: End to end Flow process
  Validating the end to end flow

  Background: 
    Given user navigates to the your logo website
    Then user in on the your logo landing page
   	When user click on the Sign in button
    Then user is navigated to login page
    When user enters "omjisaini25@gmail.com" in username field
    And enters "testwebsite" in password field
    And clicks on Sign in button
    

  @tag1
  Scenario: Placing an Order
  	Given user is successfully signed in with name "Omji Saini"
    When user clicks on Women tab
    Then User is navigated to "women" products page
    When user adds "Printed Dress" product to cart
    Then product "Printed Dress" is added with message "Product successfully added to your shopping cart"
    When user clicks on Proceed to Checkout button
    Then user is navigated to "SHOPPING-CART SUMMARY" page
    And product "Printed Dress" is shown in the cart
    When user clicks on Proceed to checkout button on summary page
    Then user is navigated to "Addresses" page
    
    
    
    
						
    