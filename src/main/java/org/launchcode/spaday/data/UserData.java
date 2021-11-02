package org.launchcode.spaday.data;

import org.launchcode.spaday.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserData {
    private static Map<Integer,User> users = new HashMap<>();

    public static User getById(int id) {
        return users.get(id);
    }

    public static List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    public static void add(User user) {
        users.put(user.getId(),user);
    }
}
