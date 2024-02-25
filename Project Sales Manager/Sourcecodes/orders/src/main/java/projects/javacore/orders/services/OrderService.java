package projects.javacore.orders.services;

import java.util.InputMismatchException;
import java.util.Scanner;

import projects.javacore.orders.App;
import projects.javacore.orders.models.Order;
import projects.javacore.orders.models.OrderDetail;
import projects.javacore.orders.models.Product;

public class OrderService {
	public void order() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("----------------Mua sản phẩm----------------");
		
		try {
			System.out.println("Mã đặt hàng: ");
			int id = input.nextInt();
			
			input.nextLine();
			
			System.out.println("Nhập tên khách hàng: ");
			String customerName = input.nextLine();
			
			input.nextLine();
			
			System.out.println("Nhập số điện thoại: ");
			String phone = input.nextLine();
			
			input.nextLine();
			
			System.out.println("Nhập địa chỉ email: ");
			String email = input.nextLine();
			
			Order order = new Order(id, customerName, phone, email);
			
			Integer productId = -1;
			
			while (true) {
				input = new Scanner(System.in);
				
				System.out.println("Nhập mã sản phẩm:");
				productId = input.nextInt() ;
				
				if (productId.equals(-1)) {
					break;
				}
				
				//Kiểm tra mã sản phẩm có tồn tại hay không
				
				System.out.println("Nhập số lượng");
				int quantity = input.nextInt();
				
				Product product = null;
				
				for (Product p : App.PRODUCTS) {
					if (productId.equals(p.getId())) {
						product = p;
						break;
					}
				}
				
				if (product == null) {
					System.out.println("Mã sản phẩm không tồn tại");
				}
				
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setId(1);
				orderDetail.setOrderId(order.getId());
				orderDetail.setPrice(product.getPrice());
				orderDetail.setProductId(productId);
				orderDetail.setQuantity(quantity);
				
				order.getOrderDetail().add(orderDetail);
				
				
			} ;
			
			App.ORDER.add(order);
			
		} catch (InputMismatchException ei) {
    		System.out.println("Bạn đã nhập sai, xin vui lòng nhập lại");
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
	}
	
	public void show() {
		System.out.println("Danh sách sản phẩm");
		String header = String.format("%s%15s%30s%30s", "Mã", "Tên khách hàng", "Số điện thoai", "Email ");
		System.out.println(header);
		ProductService productService = new ProductService();
		
		
		for (Order order : App.ORDER) {
			String row = String.format("%s%15s%30s%30s", order.getId(), order.getCustomerName(), order.getPhone(), order.getEmail());
			
			System.out.println(row);
			
			String orderDetailHeader = String.format("%30s%10s%30s%30s", "STT", "Tên sản phẩm", "Gía", "Số lượng ");
			System.out.println(orderDetailHeader);
			
			int i = 1;
			for (OrderDetail od: order.getOrderDetail()) {
				
				Product p  = productService.getByID(od.getProductId());
				
				String orderDetailHeaderRow = String.format("%30s%10s%30s%30s", i, "Tên sản phẩm", "Gía", "Số lượng ");
				System.out.println(orderDetailHeaderRow);
				i++;
			}
			}
		}
}