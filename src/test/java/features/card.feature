Feature: Product Card

  Scenario:
    Given i have logged in with email: "hello@getir.com" and password: "hello"
    When i navigate to "Kişisel Bakım" category
    And i add a "Sabun" to card
    And i navigate back from category
    And i navigate to "Ev Bakımı" category
    And i add a "Deterjan" to card
    And i navigate to cart page
    And delete every product from card
    Then i expect to see that product card is empty
