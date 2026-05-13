package com.salvar.imagem.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class PhotoService {

    @Value("{upload.Dir")
    private String uploadDir;

    // `MultipartFile` representa o arquivo enviado pelo formulário (ex.: uma foto) para ser processado no backend.
    public String  savePhoto(MultipartFile photo) throws IOException {

        String originalName = photo.getOriginalFilename();

        // Substring serve para pegar um pedaço do nome
        String extension = originalName.substring(originalName.lastIndexOf("."));

        // Gera um UUID para o novo nome do arquivo, gerando um nome novo e aleatorio para cada arquivo
        String newName = UUID.randomUUID() + extension;

        Path directory =  Path.of(uploadDir);
        Files.createDirectories(directory);

        Path pathUrl = directory.resolve(newName);
        Files.copy(photo.getInputStream(), pathUrl);

        return  uploadDir + "/" + newName;
    }

}
