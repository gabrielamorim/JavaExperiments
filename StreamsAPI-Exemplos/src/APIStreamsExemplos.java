import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class APIStreamsExemplos {

	public static void main(String[] args) {

		// Lista de ordens utilizada nos exemplos
		List<Order> orders = new ArrayList<Order>();

		orders.add(new Order(1, 100.00));
		orders.add(new Order(2, 17.89));
		orders.add(new Order(3, 376.65));
		orders.add(new Order(4, 87.00));
		orders.add(new Order(5, 165.76));

		// Listagem 1. Método corriqueiro para percorrer uma lista e obter o
		// valor total.
		System.out
				.println("Listagem 1. Método corriqueiro para percorrer uma lista e obter o valor total.");
		System.out.println("Total: "
				+ new APIStreamsExemplos().getOrdersTotal(orders));

		// Listagem 2. Código utilizando a Streams API para percorrer uma lista
		// e obter o valor total.
		System.out
				.println("Listagem 2. Código utilizando a Streams API para percorrer uma lista e obter o valor total.");
		Double ordersTotal = orders.stream()
				.mapToDouble((order) -> order.getValue()).sum();
		System.out.println("Total: " + ordersTotal);

		// Listagem 4. Diferentes modos de usar o método Stream.of().
		Double results[] = { 10.0, 9.4, 8.6, 10.0 };
		Stream<Double> fromArray = Stream.of(results);
		Stream<Double> fromArguments = Stream.of(10.0, 9.4, 8.6, 10.0);
		Stream<String> emptyStream = Stream.empty();

		// Listagem 5. Exemplo de uso do método Stream.filter().
		System.out
				.println("Listagem 5. Exemplo de uso do método Stream.filter().");
		orders = new ArrayList<Order>();
		Stream<Order> bigOrders = orders.stream().filter(
				(order) -> order.getValue() > 999.00);
		System.out.println("Total de ordens com total maior que 999: "
				+ bigOrders.count());

		// Listagem 6. Exemplo de uso do método Stream.sorted().
		System.out
				.println("Listagem 6. Exemplo de uso do método Stream.sorted().");
		orders = new ArrayList<Order>();
		Stream<Order> sortedOrders = orders.stream().sorted(
				(order1, order2) -> Double.compare(order1.getValue(),
						order2.getValue()));

		// Listagem 7. Exemplo de uso do método Stream.map().
		System.out
				.println("Listagem 7. Exemplo de uso do método Stream.map().");
		Stream<Double> ordersValues = orders.stream().map(
				(order) -> order.getValue());

		// Listagem 8. Exemplo de uso do método Stream.collect().
		System.out
				.println("Listagem 8. Exemplo de uso do método Stream.map().");
		List<Double> ordersValuesList = orders.stream()
				.map((order) -> order.getValue())
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

		// Listagem 9. Exemplo de uso do método Stream.collect().
		System.out
				.println("Listagem 9. Exemplo de uso do método Stream.collect().");
		ordersValuesList = orders.stream().map((order) -> order.getValue())
				.collect(Collectors.toList());

		// Listagem 10. Uso do método Collectors.joining() para concatenar
		// elementos de uma stream com delimitador.
		System.out
				.println("Listagem 10. Uso do método Collectors.joining() para concatenar elementos de uma stream com delimitador.");
		String ordersString = orders.stream()
				.map((order) -> String.valueOf(order.getValue()))
				.collect(Collectors.joining(", "));

		// Listagem 11. Exemplo de uso do método Collectors.toMap().
		System.out
				.println("Listagem 11. Exemplo de uso do método Collectors.toMap().");
		Map<Long, Double> ordersMap = orders.stream().collect(
				Collectors.toMap((order) -> order.getId(),
						(order) -> order.getValue()));

		// Listagem 12. Exemplo de uso do método Collectors.groupingBy().
		System.out
				.println("Listagem 12. Exemplo de uso do método Collectors.groupingBy().");
		Map<Long, List<Order>> ordersGroupedByVendors = orders.stream()
				.collect(Collectors.groupingBy((order) -> order.getVendor()));

		// Listagem 13. Exemplo de uso do método Collectors.summing().
		System.out
				.println("Listagem 13. Exemplo de uso do método Collectors.summing().");
		ordersTotal = orders.stream().collect(
				Collectors.summingDouble((order) -> order.getValue()));
	}

	// Listagem 1. Método corriqueiro para percorrer uma lista e obter o valor
	// total.
	public double getOrdersTotal(List<Order> orders) {

		double ordersTotal = 0.0;

		for (Order order : orders) {
			ordersTotal = ordersTotal + order.getValue();
		}

		return ordersTotal;
	}
}

// Listagem 3. Classe Order, utilizada na maioria dos exemplos do artigo e
// criação da lista de ordens.
class Order {

	private long id;
	private double value;

	public Order(long id, double value) {
		this.id = id;
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public long getId() {
		return id;
	}

	// retorna o ID do vendedor para a Listagem 12
	public long getVendor() {
		return 0L;
	}
}
