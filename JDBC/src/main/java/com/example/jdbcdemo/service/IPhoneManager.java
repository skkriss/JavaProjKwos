package com.example.jdbcdemo.service;

import java.sql.Connection;
import java.util.List;

import com.example.jdbcdemo.domain.Phone;

public interface IPhoneManager {
	
	public int addPhone(Phone phone);
	public List<Phone> getAllPhones();
	public int updatePhone(Phone phone);
	public int deletePhone(Phone phone);
	public Phone searchPhone(String mark);
	public void clearPhone();
	public Connection getConnection();
	public void addAllPhones(List<Phone> phones);
	public void deleteAll(List<Phone> phones);

}
