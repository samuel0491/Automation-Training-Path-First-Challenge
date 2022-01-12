Feature: Shop

  Background:
    Given the user open the browser and navigates to practice.automationtesting page
    And   the user click on Shop menu
    Then  the shop page is displayed

#  Scenario: TC001 Shop filter by price
#    Given the user adjust the filter by price between 400 500 rps
#    When  the user click on the filter button
#    Then  user can view books only between 400 to 500 rps price

  Scenario Outline: TC002 Shop product categories
    When the user click on a product "<category>"
    Then the user can view only that particular product and "<quantity>"
    Examples:
      |category  |   quantity|
      |Android   |          1|
      |HTML      |          3|
      |JavaScript|          3|
      |selenium  |          1|

  Scenario Outline: TC003 Shop sorting by different criterial
     Given the user click on sorting dropdown
     When  the user select a "<criteria>" to sort
     Then the user can view the products ordered by criterion selected
    Examples:
      |criteria                  |
#      |Default sorting           |
      |Sort by popularity        |
#      |Sort by average rating    |
#      |Sort by newness           |
#      |Sort by price: low to high|
#      |Sort by price: high to low|
#
#  Scenario: TC004 Shop Sale
#    When the user click on a product with Sale! icon
#    Then the detail product corresponding is show up
#    And  the user can see the actual price with old price stricken
#
#  Scenario Outline: TC005 Shop Add to Basket-view Basket
#    Given the user Click on the Add To Basket button
#    And   the user can view the product in the Menu item with price
#    And   the user click on View Basket link
#    And   the check out page is displayed
#    And   the user can see the value of Total is Subtotal + Taxes
#    When  the user click on Proceed to Check Out button
#    And   payment gateway page is displayed
#    And   the user enter in the form
#         |First Name   |Last Name   |Company Name |Email Address  |Phone     |Country |Address |Town  |State   |Postcode|
#         |Juan         |Perez       |Tech         |juanp@gmail.com|8092227788|Rep.Dom |Calle 1 |DN    |Sto Dgo |94000   |
#    And  the user can see order details
#    And  the user select a "<payment method>"
#    And  the user click on Place Order button
#    Then the user completes the process and can see the Order confirmation page
#    Examples:
#      |payment method         |
#      |Direct Bank Transfer   |
#      |Check Payments         |
#      |Cash on Delivery       |
#      |PayPal Express Checkout|
















