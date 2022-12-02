package ru.ovv.javapp.service;


import ru.ovv.javapp.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    void addUser(User user);
    void changeUser(long id, User updatedUser);
    void deleteUser(long id);
    User getUserById(long id);

}
