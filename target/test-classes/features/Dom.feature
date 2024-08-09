
Feature: Dominos order checkout Evaluation

  Scenario: Checkout with three different pizzas 
    Given the user in the login page
    And the user click the Order Online now
    When the user click the enter the address textbox
    And the user enters pincode
    And the user select the first suggestion
    Then the user go to veg pizza section
    And the user select the addcart in Farmhouse pizza
    And the user increase the qty of Farmhouse pizza to two
    And the user select the addcart in Margherita pizza
    And the user increase the qty of Margherita pizza to two
    And the user select the addcart in Peppy Paneer pizza
    And the user increase the qty of Peppy Paneer pizza to two
    And take screenshot and get checkout
    And sum the product values based on qty
    Then assert the sum with subtotal value

	Scenario: Checkout with pepsi 
		Given the user in the menu page
		And the user select the addcart in Pepsi 
		When the user increase the qty in pepsi
		Then take screenshot and get checkout
		And sum the product values based on qty
		Then assert the sum with subtotal value
		
	Scenario: Checkout after decreasing the qty
		Given the user in the menu page 
		When the user decrease the qty in Margherita
		And the user decrease the qty in pepsi
		Then take screenshot and get checkout
		And sum the product values based on qty
		Then assert the sum with subtotal value