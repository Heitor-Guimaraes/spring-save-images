package com.salvar.imagem.controllers;

import com.salvar.imagem.service.PhotoService;
import com.salvar.imagem.service.UserService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final PhotoService photoService;

    public UserController(UserService userService, PhotoService photoService) {
        this.userService = userService;
        this.photoService = photoService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> saveUser(@RequestParam String name,
                                      @RequestParam String email,
                                      @RequestParam MultipartFile photo) throws IOException {
        String pathPhoto = photoService.savePhoto(photo);
        userService.cadastrarUsuario(name, email, pathPhoto);
        return ResponseEntity.ok("Usuario cadastrado com sucesso");


    }


}
