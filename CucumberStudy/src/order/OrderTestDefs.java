package order;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 *
 * @author Gabriel Amorim
 * 
 * Classe que define todos os steps presentes no arquivo de features LineMigrations.feature.
 *
 */
public class OrderTestDefs {
	
	List<OrderItem> orderItemsList = new ArrayList<OrderItem>();
	
	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	XPathFactory xFactory;
	XPath xpath;
	
	/**
	 * Inicializa objetos e componentes necessários nos steps dos testes.
	 * 
	 * @throws ParserConfigurationException
	 */
	@Before
	public void initialize() throws ParserConfigurationException {
		factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();		
	    xFactory = XPathFactory.newInstance();
	    xpath = xFactory.newXPath();
	}
	
	/**
	 * De acordo com o cenário cria um {@link OrderItem}
	 * e o adiciona a uma lista para auxiliar nas
	 * validações dos próximos steps.
	 * 
	 * @param productCategory
	 * @param productType
	 * @param actionCode
	 */
	@Given("I have an order with a ProductCategory (.+) and a ProductType (.+) and an ActionCode (.+)")
	public void addItem(String productCategory, String productType, String actionCode) {		
		orderItemsList.add(new OrderItem(productCategory, productType, actionCode));
	}
	
	/**
	 * Valida o payload da ordem de acordo com
	 * a lista de {@link OrderItem}. 
	 * 
	 * Recebe como parâmetro o nome do arquivo que
	 * contém o payload da ordem.
	 * 
	 * @param orderFileName
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws XPathExpressionException
	 */
	@Then("the entire order (.+) has the above definitions")
	public void loadOrderTemplate(String orderPayload) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {		
		
		String filePath = "./resources/" + orderPayload;
		
		File orderPayloadFile = new File(filePath);		
		assertThat((orderPayloadFile.exists() && orderPayloadFile.isFile()), equalTo(true));
	    
	    Document doc = builder.parse(filePath);    
	    
	    for(OrderItem item : orderItemsList) {
	    	XPathExpression expr = xpath.compile("/Order/ListOfOrderLineItems/OrderLineItem["
	    			+ "ProductCategory='" + item.productCategory + "' "
	    			+ "and ProductType='" + item.productType + "' "
	    			+ "and ActionCode='" + item.actionCode + "']");
	    	
	    	Object result = expr.evaluate(doc, XPathConstants.NODESET);	    	
	    	NodeList nodes = (NodeList) result;
	        
	    	assertThat(nodes.getLength() > 0, equalTo(true));	    	
	    }
	}
}

class OrderItem {
	
	public OrderItem(String productCategory, String productType, String actionCode) {
		this.productCategory = productCategory;
		this.productType = productType;
		this.actionCode = actionCode;
	}
	
	String productCategory;
	String productType;
	String actionCode;
}
