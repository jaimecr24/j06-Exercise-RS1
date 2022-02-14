package com.spring.exercisers1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class Controlador {

    @Autowired ListUserService lista;

    @PostMapping("/addUser")
    public Object addUser(@RequestBody Map<String,Object> body){
        String error = "Error en los datos de entrada";
        if (body==null) return error;
        if (body.get("id")==null) return error;
        long id = Long.parseLong(body.get("id").toString());
        if (body.get("name")==null) return error;
        String name = body.get("name").toString();
        int res = lista.addUser(id,name);
        if (res==0) return "Error: el id ya existe";
        return new User(id,name);
    }

    @GetMapping("/user/{id}")
    public Object getUser(@PathVariable long id){
        Optional<User> p = Optional.ofNullable(lista.getUser(id));
        if (p.isPresent()) return p.get();
        return "Error: el id no existe";
    }

    @PutMapping("/post")
    public String setUser(@RequestParam(value="id") long id,@RequestParam(value="name") String name){
        int res = lista.setName(id,name);
        if (res==1) return "Usuario modificado";
        else return "id no existe";
    }
}
