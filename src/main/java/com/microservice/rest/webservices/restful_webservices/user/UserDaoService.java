package com.microservice.rest.webservices.restful_webservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users=new ArrayList<>();
	private static int usersCount=0;
	static {
		users.add(new User(++usersCount,"Shatanshu",LocalDate.now().minusYears(24)));
		users.add(new User(++usersCount,"Shreya",LocalDate.now().minusYears(23)));
		users.add(new User(++usersCount,"Sumit",LocalDate.now().minusYears(27)));

	}
	public List<User>findall(){
		return users;
	}
	public User findOne(int id) {
		Predicate<? super User> predicate=user -> user.getId()==id;
		return users.stream().filter(predicate).findFirst().orElse(null);
		/*if(user.getId()==id) {
			return user.getId();
		}*/
		
	}
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}

}
