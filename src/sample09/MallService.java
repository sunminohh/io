package sample09;

import java.io.IOException;
import java.util.List;

public class MallService {

	// 사용자 정보를 제공하는 저장소 객체 
	private UserRepository userRepo = new UserRepository();
	// 상품 정보를 제공하는 저장소 객체
	private ProductRepository productRepo = new ProductRepository();
	// 주문 정보를 제공하는 저장소 객체
	private OrderRepository orderRepo = new OrderRepository();
	
	/*
	 * 모든 상품정보 목록을 반환한다.
	 *  반환타입: List<Product>
	 *  메소드이름: getAllProducts
	 *  매개변수: 없음
	 */
	public List<Product> getAllProducts() {
		return productRepo.getProducts();
	}
	
	
	/*
	 * 아이디, 비밀번호를 전달받아서 사용자를 인증하고, 인증된 사용정보를 반환한다.
	 *  반환타입: User
	 *  메소드 이름: login
	 *  매개변수: String id, String, password
	 *  예외: RuntiemExeption, 사용자 정보가 없거나 비밀번호가 일치하지 않는 경우
	 */
	public User login(String id, String password) {
		User user = userRepo.getUserById(id);
		if (user == null) {
			throw new RuntimeException("["+id+"] 사용자정보가 존재하지 않습니다.");
		}
		
		if (!(user.getPassword().equals(password))) {
			throw new RuntimeException("비밀번호가 일치하지 않습니다.");
		}
		
		return user;
	}
	
}








