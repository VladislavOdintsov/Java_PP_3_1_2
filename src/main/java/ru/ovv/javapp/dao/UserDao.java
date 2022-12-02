package ru.ovv.javapp.dao;


import ru.ovv.javapp.model.User;

import java.util.List;

public interface UserDao {
    List<User> allUsers();
    void addUser(User user);
    void changeUser(long id, User updatedUser);
    void deleteUser(long id);
    User getUserById(long id);


}
