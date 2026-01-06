package com.jpa.test;

import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		/*
		User user = new User();
		
		user.setName("Tarunjeet");
		user.setCity("Jalandhar");
		user.setStatus("I am a backend developer");
		
		User user1 = userRepository.save(user);
		
		System.out.println(user1);
		
		*/
		
		//Create object of User
		/*
		User user1 = new User();
		user1.setName("Gurchintan");
		user1.setCity("Jammu");
		user1.setStatus("Freelande architect");
		
		User user2 = new User();
		user2.setName("Japneet");
		user2.setCity("Patiala");
		user2.setStatus("Psychology student");
		
		//saving single user
		//User resultUser = userRepository.save(user2);
		
		//saving multiple users
		List<User> users =List.of(user1,user2);
		Iterable<User> result = userRepository.saveAll(users);
		
		result.forEach(user->{
			System.out.println(user);
		});
		
		System.out.println("Done!!"); 
		*/
		
		//update the user of id = 2
		
		/*
		Optional<User> optional = userRepository.findById(152);
		
		User user = optional.get();
		user.setName("Gurchintan Kaur");
		user.setStatus("Freelance Architect");

		User result1 = userRepository.save(user);
		System.out.println(result1);
		*/
		
		//Find by Id
		/*
		Iterable <User> itr = userRepository.findAll();
		Iterator<User> iterator = itr.iterator();
		
		while(iterator.hasNext())
		{
			User user = iterator.next();
			System.out.println(user);
		}
		*/
		// Another Way
		/*
		itr.forEach(new Consumer<User>() 
		{
			@Override
			public void accept(User t)
			{
				System.out.println(t);
			}
		});
		*/
		
		//Easy way 
		
		//itr.forEach(user->{System.out.println(user);});
		
		//Deleting the user with id =153
		/*
		userRepository.deleteById(153);
		System.out.println("Deleted!");
		*/
		
		
		//Delete all users
		/*
		Iterable<User> allusers = userRepository.findAll();
		allusers.forEach(user->{System.out.println(user);});
		
		userRepository.deleteAll(allusers);
		
		 */
		
		//Display one with given name
		/*
		List<User> users = userRepository.findByName("Tarunjeet");
		
		users.forEach(e->System.out.println(e));
		*/
		//Display all users
		List<User> allUser = userRepository.getAllUser();
		
		allUser.forEach(e->{
			System.out.println(e);
			});
		
		System.out.println("______________________________________");
		
		List<User> userByName = userRepository.getUserByName("Japneet");
		
		userByName.forEach(e->{
			System.out.println(e);
			});
		
		System.out.println("______________________________________");
		
		userRepository.getUsers().forEach(e->System.out.println(e));
	}

}
