package com.spring.exercisers1;

public interface ListUserService {
    int addUser(long id, String name); // Add an user. If ok return 1, else return 0.
    User getUser(long id); // Get the user by id.
    int setName(long id, String newName); // Change the name searching by id. If ok return 1, else return 0.
}
