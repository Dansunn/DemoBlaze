Feature: Add Product to Cart

  @Product @Positive
  Scenario: Navigate through product categories
    Given User is on the homepage
    When User clicks on a product category
    Then Products from the selected category should be displayed

  @Product @Positive
  Scenario Outline: Add a product to the cart
    Given User is on a product page
    When User clicks on "<productName>"
    And User clicks add to cart button
    Then The product should be added to the cart with a confirmation message "Product added" shown
    And User clicks the home button

    Examples:
      |   productName       |
      |   Iphone 6 32gb     |
      |   Nexus 6           |
      |   HTC One M9        |
      |   Sony xperia z5    |
      |   Samsung galaxy s7 |

  @Product @Positive
  Scenario: Remove an item from the cart
    Given User has products in the cart
    When User removes a product from the cart
    Then The product should no longer be in the cart

  @Product @Positive
  Scenario: Ensure total price updates correctly
    Given User see the current total price
    When User removes the first product from the cart
    Then The total price should be updated accordingly

  @Product @Negative
  Scenario: Not fill all the information needed when Checkout
    Given User has added products to the cart
    When User proceeds to checkout
    And User enters payment details but not fill the name and credit card
    Then User should see an error message "Please fill out Name and Creditcard."

  @Product @Positive
  Scenario: Complete a purchase
    Given User fill all the information needed
    When User proceeds to purchase
    Then User should see a success message confirming the order