package com.example.jdbcdemo.service;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.example.jdbcdemo.domain.Phone;

public class PhoneManagerTest {
	
	
	PhoneManager phoneManager = new PhoneManager();
	
	private final static String MARK_1 = "Apple";
	private final static double PRICE_1 = 5700.00;
	private final static String MODEL_1 = "Iphone X";
	private final static int	VAT_1 = 23;
	
	private final static String MARK_2 = "Samsung";
	private final static double PRICE_2 = 2799.99;
	private final static String MODEL_2 = "EDGE 8+";
	private final static int	VAT_2 = 23;
	
	private final static String MARK_3 = "XIAOMI";
	private final static double PRICE_3 = 1200.00;
	private final static String MODEL_3 = "MI 8";
	private final static int	VAT_3 = 23;
	
	private final static String MARK_4 = "MICROSOFT";
	private final static double PRICE_4 = 2999.99;
	private final static String MODEL_4 = "Lumia";
	private final static int	VAT_4 = 23;
	
	
	Phone phone1 = new Phone(MARK_1, PRICE_1, MODEL_1, VAT_1);
	Phone phone2 = new Phone(MARK_2, PRICE_2, MODEL_2, VAT_2);
	Phone phone3 = new Phone(MARK_3, PRICE_3, MODEL_3, VAT_3);
	Phone phone4 = new Phone(MARK_4, PRICE_4, MODEL_4, VAT_4);
	
	@Test
	public void checkConnection(){
		assertNotNull(phoneManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		Phone phone = new Phone(MARK_1, PRICE_1, MODEL_1, VAT_1);
		
		phoneManager.clearPhone();
		assertEquals(1,phoneManager.addPhone(phone));
		
		List<Phone> phones = phoneManager.getAllPhones();
		Phone phoneRetrieved = phones.get(0);
		
		assertEquals(MARK_1, phoneRetrieved.getMark());
		assertEquals(PRICE_1, phoneRetrieved.getPrice(),5);
		assertEquals(MODEL_1, phoneRetrieved.getModel());
		assertEquals(VAT_1, phoneRetrieved.getVat());
		
	}
	
	@Test
	public void checkAddAll(){
		phoneManager.clearPhone();		
		
		List<Phone> phones = new ArrayList<>();
		phones.add(phone1);
		phones.add(phone2);
		//phones.add(phone2);
		phones.add(phone3);
		phones.add(phone4);
		
		phoneManager.addAllPhones(phones);
		int size = phoneManager.getAllPhones().size();
		
		//assertTrue(size == 0 || size == 4);
		
		assertThat(size, either(is(4)).or(is(0)));
		
	}

	@Test
	public void checkUpdating() {
		assertEquals (1, phoneManager.updatePhone(phone1));
	}
	
	@Test
	public void checkSearching() {
		Phone phoneFromSearch = phoneManager.searchPhone(MARK_1);
		//System.out.print(phoneFromSearch.getModel());
		assertEquals(PRICE_1, phoneFromSearch.getPrice(),5);
		assertEquals(MODEL_1, phoneFromSearch.getModel());
		assertEquals(VAT_1, phoneFromSearch.getVat());
	}
	
	@Test
	public void checkDeleteAll(){
			List<Phone> phones = new ArrayList<>();
			Phone phone5 = new Phone(MARK_1, PRICE_1, MODEL_1, VAT_1);
			phones.add(phone1);
			phones.add(phone2);
			phones.add(phone3);
			phones.add(phone4);
			phones.add(phone5);
			phoneManager.deleteAll(phones);
			int size = phoneManager.getAllPhones().size();
			
			assertThat(size, either(is(4)).or(is(0)));
	}
}
