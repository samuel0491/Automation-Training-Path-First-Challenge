Feature: My Account Login functionality

  Background: User opens the browser and navigates to the page
      Given the user opens the browser and navigates to practice.automationtesting's page
      And the user click on My Account option
      Then the login and register form should show up

  Scenario Outline: TC0001 - Login - Successful  Login
      Given the user typed his username "<username>"
      And the user typed his password "<password>"
      When the user presses login button
      Then my account page show up
      And the text "Hello <username> (not <username>? Sign out)" is showing
      Examples:
        | username    | password |
        |sqa          |Qa2k21.   |

  Scenario Outline: TC0002 - Login - Failed Logins
    Given the user typed his credentials "<username>" and "<password>"
    When the user presses login button
    Then Proper "<message>" error must be displayed by the page
    Examples:
      | username      |        password |message                     |
      |               |                 |Error: Username is required.|
      |sqa@test.com   |                 |Error: Password is required.|
      |sqa@test.com   |qa2k21.          |ERROR: The password you entered for the username sqa@test.com is incorrect.|
      |               |Qa2k21.          |Error: Username is required.|
      |hjdshjdhjdhj   |kjdsjkdsjkdsjk   |ERROR: Invalid username.|

  Scenario: TC0003 - Login - Password field should be masked
     When the user typed username as "sqa@test.com"
     And the user typed password as "Qa2k21."
     Then password field type should be "password" in the DOM

  Scenario: TC0004 - Login - Login authentication
     Given user is logged in successful
      |sqa@test.com|Qa2k21.|
     When the user click on sign out option
     And the login and register form should show up
     And the user click on browser back button
     Then the user should not be logged in
     And the login and register form should show up