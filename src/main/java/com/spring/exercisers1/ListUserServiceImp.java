package com.spring.exercisers1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ListUserServiceImp implements ListUserService {

    ArrayList<User> lista = new ArrayList<>();

    public int addUser(long id, String name){
        if (lista.stream().anyMatch(e -> e.getId()==id)) return 0; // error: duplicate id.
        lista.add(new User(id,name));
        return 1;
    }

    public User getUser(long id) {
        Optional<User> opcUser = lista.stream().filter(e -> e.getId()==id).findFirst();
        return (opcUser.orElse(null));
    }

    public int setName(long id, String newName) {
        Optional<User> opcUser = lista.stream().filter(e -> e.getId()==id).findFirst();
        if (opcUser.isPresent()) {
            User p = opcUser.get();
            p.setName(newName);
            return 1;
        }
        else return 0;
    }
}
