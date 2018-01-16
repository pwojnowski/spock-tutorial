package com.farenda.spock;

import java.util.Set;

public interface UserService {

    /**
     * Return true when user exists.
     */
    boolean exists(User user);

    /**
     * Add a new user, but only if it doesn't exist yet.
     *
     * @param user to add
     */
    void add(User user);

    /**
     * Remove a user with given name.
     *
     * @param name of user to remove
     */
    void remove(String name);

    /**
     * Return all users.
     *
     * @return All users or empty Set.
     */
    Set<User> getAll();
}
