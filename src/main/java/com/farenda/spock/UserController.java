package com.farenda.spock;

public class UserController {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser(String name) {
        User user = new User(name);
        if (!userService.exists(user)) {
            userService.add(user);
        }
    }
}
