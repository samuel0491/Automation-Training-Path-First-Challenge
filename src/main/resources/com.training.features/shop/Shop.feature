Feature: Shop

  Background:
    Given the user open the browser and navigates to practice.automationtesting's page
    And   the user click on Shop menu
    Then  the shop page is displayed

  Scenario: TC001 Shop filter by price
    When the user click on the price bar
    And  adjust the filter by price between <150 - 450> rps
    And  the user click on the filter button
    Then user can view books only between 150 to 450 rps price

  Scenario: TC002 Shop product categories
    When the user click on a product category
    Then the user can view only that particular product

  Scenario: TC003 Shop default sorting by Popular products
     When the user click on Default sorting dropdown
     And  the user Click on Sort by Popularity item in Default sorting dropdown
     Then the user can view the popular products only

  Scenario: TC004  Shop default sorting by Average ratings
    When the user click on Default sorting dropdown
    And  the user Click on Sort by Average ratings in Default sorting dropdown
    Then the user can view the popular products only

  Scenario: TC005 Shop default sorting by Newness ratings
    When the user click on Default sorting dropdown
    And  the user Click on Sort by Newness ratings in Default sorting dropdown
    Then the user can view the popular products only

  Scenario: TC006 Shop default sorting by Low to High Item
    When the user click on Default sorting dropdown
    And  the user Click on Sort by Low to High Item in Default sorting dropdown
    Then the user can view the popular products only

  Scenario: TC007 Shop default sorting by High to Low Item
    When the user click on Default sorting dropdown
    And  the user Click on Sort by High to Low Item in Default sorting dropdown
    Then the user can view the popular products only

  Scenario: TC008 Shop Read more
    When the user click on read more button in home page
    And  Read More option indicates the item is Out Of Stock
    Then User cannot add the product to the car

  Scenario: TC009 Shop Sale
    When the user click on Sale written product in home page
    Then User can view the actual price with old price stricken for the sale written products

  Scenario: TC010 Shop Add to Basket-view Basket
    When the user Click on the Add To Basket button
    Then the user can view that Book in the Menu item with price
    And  the user click on View Basket link
    Then the check out page is displayed
    And  the user can see the value of Total  is Subtotal + Taxes
    And  the user click on Proceed to Check Out button
    Then payment gateway page is displayed
    And  the user enter in the form
        |First Name   |Last Name   |Company Name    |Email Address  |Phone     |Country |Address |Town / City|State / County |Postcode / ZIP |
        |Juan         |Perez       |Tech            |juanp@gmail.com|8092227788|Rep.Dom |Calle 1 |DN         |Sto Dgo        |94000          |
    And the user can see order details
    And the user select a payment method
    And the user click on Place Order button
    Then the user completes the process and can see the Order confirmation page

  Scenario: TC011 Shop Add to Basket through item link
    When the user Click on the Add To Basket button
    Then the user can view that Book in the Menu item with price
    And  the user click on Item link
    Then the check out page is displayed
    And  the user can see the value of Total  is Subtotal + Taxes
    And  the user click on Proceed to Check Out button
    Then payment gateway page is displayed
    And  the user enter in the form
      |First Name   |Last Name   |Company Name    |Email Address  |Phone     |Country |Address |Town / City|State / County |Postcode / ZIP |
      |Juan         |Perez       |Tech            |juanp@gmail.com|8092227788|Rep.Dom |Calle 1 |DN         |Sto Dgo        |94000          |
    And the user can see order details
    And the user select a payment method
    And the user click on Place Order button
    Then the user completes the process and can see the Order confirmation page

  Scenario: TC012 Shop Add to Basket view basket tax
    When the user Click on the Add To Basket button
    Then the user can view that Book in the Menu item with price
    And  the user click on Item link
    Then the check out page is displayed
    And  the user can see the value of Total  is Subtotal + Taxes
    Then Tax rate for indian should be 2% and for abroad it should be 5%













