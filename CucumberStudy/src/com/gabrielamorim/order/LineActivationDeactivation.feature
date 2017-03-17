Feature: Line activation / deactivation

	Background:
  		Given the country code is 55
  
   	Scenario: Activate line
  		Given I have an order to activate a line with the 1198767653 number
  		When the order is received
  		Then the service invoked must be SVC_ACTIVATE_LINE
  		And the input to the legacy system should contains /data/service = 'ACTIVATE_LINE'
  		
  	Scenario: Deactivate line
  		Given I have an order to deactivate a line with the 1198767653 number
  		When the order is received
  		Then the service invoked must be SVC_CANCEL_LINE
  		And the input to the legacy system should contains /data/service = 'DEACTIVATE_LINE'