package firefox;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

 class Product {

	String name;
	Double price;

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}
 
	
		public static void main(String[] args) {
			List<Product> searchResult = new ArrayList<>();
			searchResult.add(new Product("MADISON OVEREAR HEADPHONES", 125.00));
			searchResult.add(new Product("MADISON EARBUDS", 35.00));
			searchResult.add(new Product("MP3 PLAYER WITH AUDIO", 185.00));
			searchResult.sort(new Demo());
		System.out.println(searchResult.get(1).getPrice());
	}

}

class Demo implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
	
		return o1.getPrice().compareTo(o2.getPrice());
	}
	
	
}