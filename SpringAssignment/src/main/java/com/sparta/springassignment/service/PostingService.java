package com.sparta.springassignment.service;

import com.sparta.springassignment.domain.Posting;
import com.sparta.springassignment.domain.PostingRepository;
import com.sparta.springassignment.domain.PostingRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostingService {

    private final PostingRepository postingRepository;

    @Transactional
    public Long update(Long id, PostingRequestDto requestDto) {

        Posting posting = postingRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시물이 존재하지 않습니다.")
        );
        posting.update(requestDto);
        return posting.getId();
    }

    public boolean passwordCheck(Long id, @RequestBody PostingRequestDto requestDto) {
        Posting posting = postingRepository.findById(id).get();
        return requestDto.getPassword().equals(posting.getPassword());
    }
}
