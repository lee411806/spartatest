package com.sparta.spratatest.service;


import com.sparta.spratatest.dto.RequestDto;
import com.sparta.spratatest.dto.ResponseDto;
import com.sparta.spratatest.entity.Item;
import com.sparta.spratatest.repository.postRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {

    private final postRepository postRepository;

    public ResponseDto createPost(RequestDto requestDto) {

        Item item = new Item(requestDto);

        Item saveItem = postRepository.save(item);

        ResponseDto responseDto = new ResponseDto(item);

        return responseDto;
    }

    public List<ResponseDto> getAllPosts() {
            return postRepository.findAll().stream().map(ResponseDto::new).toList();
    }

    @Transactional
    public Long updatePost(Long id, RequestDto requestDto) {
        Item item = findPost(id);

        item.update(requestDto);

        return id;
    }




    private Item findPost(Long id){
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
    }

    public ResponseEntity<String> deletePost(Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return ResponseEntity.ok("삭제 완료");
        } else {
            return ResponseEntity.status(404).body("Post with ID " + id + " not found.");
        }


    }
}
