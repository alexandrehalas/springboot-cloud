package com.springboot.cloud.springbootcloud.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 3;
	
	static {
		users.add(new User(1, "Ale", new Date()));
		users.add(new User(2, "Bel", new Date()));
		users.add(new User(3, "Gabi", new Date()));
	}
	
	public User findOne(int id) {
		for (User user: users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User deleteById(int id) {
		Iterator<User> usersIterator = users.iterator();
		while (usersIterator.hasNext()) {
			User user = usersIterator.next();
			if (user.getId() == id) {
				usersIterator.remove();
				return user;
			}
		}
		return null;
	}
	
}
