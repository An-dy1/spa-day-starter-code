package org.launchcode.spaday.data;

import org.launchcode.spaday.models.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserData {

	private static final Map<Integer, User> users = new HashMap<>();

	public static void addUser(User newUser) {
		users.put(newUser.getId(), newUser);
	}

	public static Collection<User> getAllUsers() {
		return users.values();
	}

	public static User getUserById(int id) {
		return users.get(id);
	}

	public static void remove(int id) {
		users.remove(id);
	}
}
