package projects.javacore.orders.services;

import java.util.InputMismatchException;

import java.util.Scanner;

import projects.javacore.orders.App;
import projects.javacore.orders.models.Product;

public class ProductService {
	public void insert() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập thông tin sản phẩm");
		
		try {
			System.out.print("Mã: ");
			int id = input.nextInt();
			
			input.nextLine();
			
			System.out.println("Tên:");
			String name = input.nextLine();
			
			System.out.println("số lượng:");
			int quantity = input.nextInt();
			
			
			
			System.out.println("Gía");
			Float price = input.nextFloat();
			
			input.nextLine();
			
			System.out.println("Ghi chú");
			String description = input.nextLine();
			
			Product p = new Product(id, name, quantity, price, description);
			App.PRODUCTS.add(p);
			
		} catch (InputMismatchException ei) {
    		System.out.println("Bạn đã nhập sai, xin vui lòng nhập lại");
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
	}
	
	public void show() {
		System.out.println("Danh sách sản phẩm");
		String header = String.format("%s%15s%30s%15s%15s", "Mã", "Tên", "Số lượng", "Gía", "Ghi chú");
		System.out.println(header);
		for (Product p : App.PRODUCTS) {
			String row = String.format("%s%15s%30d%15f%15s", p.getId(), p.getName(), p.getQuantity(), p.getPrice(), p.getDescription());
			System.out.println(row);
		}
	}
	
	public void update() {
		Scanner input = new Scanner(System.in);
		
		try {
			System.out.print("Nhập mã: ");
			Integer id = input.nextInt();
			Product product = null;
			
			for(Product p : App.PRODUCTS) {
				if(id.equals(p.getId())) {
					product = p;
					break;
				}
			}
			
			if (product == null) {
				System.out.println("mã sản phẩm không tồn tại. Xin vui lòng nhập lại");
			}
			
			System.out.println("Thông tin sản phẩm");
			String row = String.format("%s%15s%30d%15f%15s", product.getId(), product.getName(), product.getQuantity(), product.getPrice(), product.getDescription());
			System.out.println(row);
			
			for (int i = 0; i < App.PRODUCTS.size(); i++) {
				if (id.equals(App.PRODUCTS.get(i).getId())) {
					
					input.nextLine();
					
					System.out.println("Tên: ");
					String name = input.nextLine();
					
					System.out.println("Số lượng: ");
					int quantity = input.nextInt();
					
					input.nextLine();
					
					System.out.println("Ghi chú");
					String description = input.nextLine();
					
					System.out.println("Giá");
					float price = input.nextFloat();
					
					App.PRODUCTS.get(i).setName(name);
					App.PRODUCTS.get(i).setQuantity(quantity);
					App.PRODUCTS.get(i).setDescription(description);
					App.PRODUCTS.get(i).setPrice(price);
					
				}
			}
			
		} catch (InputMismatchException ei) {
    		System.out.println("Bạn đã nhập sai, xin vui lòng nhập lại");
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
	}
	
	public Product getByID(Integer id) {
		Product product = new Product();
		for (Product p : App.PRODUCTS) {
			if (id.equals(p.getId())) {
				product = p;
				break;
			}
		}
		
		return product;
	}
}
