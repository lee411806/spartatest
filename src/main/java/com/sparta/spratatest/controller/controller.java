package com.sparta.spratatest.controller;

import com.sparta.spratatest.dto.RequestDto;
import com.sparta.spratatest.dto.ResponseDto;
import com.sparta.spratatest.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class controller {

    private final Service service;

    @PostMapping
    public ResponseDto createPost(@RequestBody RequestDto requestDto){
       return service.createPost(requestDto);
    }


    @GetMapping
    public List<ResponseDto> getAllPosts(){

        return service.getAllPosts();
    }

    @PutMapping("/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody RequestDto requestDto){
        return service.updatePost(id,requestDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id){
        return service.deletePost(id);

    }
}
