package com.salvar.imagem.service;

import com.salvar.imagem.entities.User;
import com.salvar.imagem.reposiotiries.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository UserRepository;

    public UserService(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    public User cadastrarUsuario( String name, String email, String path){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhoto(path);
        return UserRepository.save(user);
    };


}
