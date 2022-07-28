package com.sparta.springassignment.repository;

import com.sparta.springassignment.domain.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostingRepository extends JpaRepository<Posting, Long> {
    List<Posting> findAllByOrderByModifiedAtDesc();
}
