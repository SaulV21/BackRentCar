package com.rentcar.BackRentCar.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/image")
public class ImageController {

    private static String UPLOAD_DIR = "uploads";

    @PostMapping("/subir")
    public void uploadImage(@RequestParam("image") MultipartFile image) throws IOException {
        byte[] bytes = image.getBytes();
        Path path = Paths.get(UPLOAD_DIR + "/" + image.getOriginalFilename());
        Files.write(path, bytes);
    }
    @GetMapping("/images/{imageName}")
    public byte[] getImagen(@PathVariable String imageName) throws IOException {
        Path path = Paths.get(UPLOAD_DIR + "/" + imageName);
        return Files.readAllBytes(path);
    }
}
