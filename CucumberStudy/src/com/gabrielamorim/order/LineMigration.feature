Feature: Line migrations
	
	The operators' system have to be able to change 
  	the customer's linetype between a set of options and plans.

  	Rules:
  	- Clients can't to change to the same type of plan he was before
  
  	Scenario: Migration Pre to Pos
  		Given I have an order with a ProductCategory LINHA and a ProductType DADOS_MOVEL and an ActionCode -
  		Given I have an order with a ProductCategory PLANO and a ProductType POS_PAGO and an ActionCode Excluir
  		Given I have an order with a ProductCategory PLANO and a ProductType PRE_PAGO and an ActionCode Incluir
  		Then the entire order Order.xml has the above definitions  	