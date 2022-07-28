package com.sparta.springassignment.controller;

import com.sparta.springassignment.domain.Posting;
import com.sparta.springassignment.repository.PostingRepository;
import com.sparta.springassignment.domain.PostingRequestDto;
import com.sparta.springassignment.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostingController {

    private final PostingRepository postingRepository;
    private final PostingService postingService;

    @PostMapping("/api/postings")
    public Posting create(@RequestBody PostingRequestDto requestDto) {
        Posting posting = new Posting(requestDto);
        return postingRepository.save(posting);
    }

    @GetMapping("/api/postings")
    public List<Posting> get(){
            return postingRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/api/postings/{id}")
    public Posting detail(@PathVariable Long id) {
        Posting posting = postingRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException()
        );
        return posting;
    }

    @DeleteMapping("/api/postings/{id}")
    public boolean delete(@PathVariable Long id, @RequestBody PostingRequestDto requestDto) {
        return postingService.deleteCheck(id, requestDto);
    }

    @PutMapping("/api/postings/{id}")
    public boolean update(@PathVariable Long id, @RequestBody PostingRequestDto requestDto) {
        return postingService.updateCheck(id, requestDto);
    }




}
