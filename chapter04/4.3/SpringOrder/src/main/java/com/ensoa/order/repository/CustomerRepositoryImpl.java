package com.ensoa.order.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ensoa.order.entity.CustomerEntity;
import com.ensoa.order.entity.Pageable;

//@Component("customerRepository")
@Repository("customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository {
	@Override
	public CustomerEntity findOne(long id) {
		CustomerEntity customer = new CustomerEntity();
		customer.setId(id);
		customer.setName("전병선");
		customer.setAddress("서울시");
		customer.setEmail("bsjun@ensoa.co.kr");
		return customer;
	}
	@Override
	public List<CustomerEntity> findAll() {
		List<CustomerEntity> customers = new ArrayList<CustomerEntity>();
		for(int i = 0; i < 10; ++i) {
			CustomerEntity customer = new CustomerEntity();
			customer.setId(i);
			customer.setName("이름"+i);
			customer.setAddress("주소"+i);
			customer.setEmail("kim"+i+"@gmail.com");
			customers.add(customer);
		}
		return customers;
	}
	@Override
	public List<CustomerEntity> findAll(Pageable page) {
		List<CustomerEntity> customers = new ArrayList<CustomerEntity>();
		int index = page.getIndex();
		int size = page.getSize();
		for(int i = index; i < index+size; ++i) {
			CustomerEntity customer = new CustomerEntity();
			customer.setId(i);
			customer.setName("이름"+i);
			customer.setAddress("주소"+i);
			customer.setEmail("kim"+i+"@gmail.com");
			customers.add(customer);
		}
		return customers;
	}
	@Override
	public void save(CustomerEntity customer) {
		System.out.println(customer + "가 저장되었습니다.");
	}
	@Override
	public void delete(long id) {
		CustomerEntity customer = findOne(id);
		System.out.println(customer + "가 삭제되었습니다.");
	}
}