Feature: Line activation  	

	Background:
  		Given the country code is 55
	
	Scenario Outline: Activate line
  		Given I have an order to <operation> a line with the 1198767653 number
  		When the order is received
  		Then the service invoked must be <service>
  		And the input to the legacy system should contains /data/service = <service> 

	Examples:
  	  | operation 	| service           |
  	  | activate   	| SVC_ACTIVATE_LINE |
  	  | cancel      | SVC_CANCEL_LINE   |