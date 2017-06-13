package net.viralpatel.spring.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import net.viralpatel.spring.config.SpringMongoConfig;
import net.viralpatel.spring.model.Customer;

public class CostomerMongoRepo {
	
	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

	public void saveCustomer(Customer user){
		mongoOperation.save(user);
	}
	
	public List<Customer> getCustomers(){
		List<Customer> customers = mongoOperation.findAll(Customer.class);
		return customers;
	}
	
	public Customer getCustomers(Long id){
		Query searchUserQuery = new Query(Criteria.where("id").gte(id));
		Customer customer = mongoOperation.findOne(searchUserQuery, Customer.class);
		System.out.println("query1 - " + searchUserQuery.toString());
		System.out.println("userTest1 - " + customers);
		return customer;
	}
}
