package com.anuwat.mongocrud;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.anuwat.mongocrud.beans.Account;
import com.anuwat.mongocrud.beans.Address;
import com.anuwat.mongocrud.beans.Customer;
import com.anuwat.mongocrud.config.MongoConnection;
import com.google.gson.Gson;
import com.mongodb.MongoException;

import dev.morphia.Datastore;


public class App {

	private static final Datastore datastore = MongoConnection.getConnection();
	private static final Gson GSON = new Gson();

	public static void main(String[] args) throws UnknownHostException, MongoException {

		Address address = new Address();
		address.setNumber("81");
		address.setStreet("Mongo Street");
		address.setTown("City");
		address.setPostcode("CT81 1DB");

		Account account = new Account();
		account.setName("Personal Account");

		List<Account> accounts = new ArrayList<Account>();
		accounts.add(account);

		Customer customer = new Customer();
		customer.setAddress(address);
		customer.setName("Anuwat");
		customer.setAccounts(accounts);
		
		Customer customerSaved = App.saveEmployee(customer);
		System.out.println(GSON.toJson(customerSaved));
		
		List<Customer> customersList = getEmployee("Anuwat");
		System.out.println(GSON.toJson(customersList));
		
		

	}

	public static List<Customer> getEmployee(String name) {
		System.out.println("Name " + name);
		return datastore.createQuery(Customer.class).field("name").equal(name).asList();

	}

	public static Customer saveEmployee(Customer customer) {
		System.out.println("Customer is " + customer);
		datastore.save(customer);
		return customer;

	}



}
