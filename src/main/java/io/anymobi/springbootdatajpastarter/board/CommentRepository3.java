package io.anymobi.springbootdatajpastarter.board;

import io.anymobi.springbootdatajpastarter.repository.MyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.stream.Stream;

public interface CommentRepository3 extends MyRepository<Comment, Long> {

    List<Comment> findByMessageContains(String keyword);

//    @Query("Select c from Comment AS c")
//    Page<Comment> findFirst10ByRecommendGreaterThanAndPostOrderByIdDesc(int messageCount, Post post, Pageable pageable);

    Page<Comment> findByMessageContainsIgnoreCase(String keyword, Pageable pageable);

    Stream<Comment> findByMessageContains(String keyword, Pageable pageable);

//    @Query(value = "Select count(*) from Comment", nativeQuery = true)
    long countById(Long id);

}
