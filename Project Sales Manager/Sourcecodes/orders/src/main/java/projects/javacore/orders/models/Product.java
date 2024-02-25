package projects.javacore.orders.models;

public class Product {
		private Integer id;
		private String name;
		private Integer quantity;
		private String description;
		private Float price;
		
		public Product() {
			
		}
		
		
		
		public Product(Integer id, String name, Integer quantity, Float price, String description) {
			this.id = id;
			this.name = name;
			this.quantity = quantity;
			this.price = price;
			this.description = description;
		}
		
		public Product( String name, Integer quantity, Float price, String description) {
			this.name = name;
			this.quantity = quantity;
			this.price = price;
			this.description = description;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		public float getPrice() {
			return this.price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		
}
