package io.anymobi.springbootdatajpastarter.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepository3Test {

    @Autowired
    CommentRepository3 commentRepository3;

    @Autowired
    PostRepository postRepository;

    @Test
    public void commnetCrud() {

        Comment comment = new Comment();
        comment.setMessage("Comment Test1");
        comment.setRecommend(100);

        Comment comment2 = new Comment();
        comment2.setMessage("Comment Test2");
        comment2.setRecommend(50);

        /*Post post = new Post();
        post.setTitle("Post test");
        post.addComment(comment);*/

        commentRepository3.save(comment);
        commentRepository3.save(comment2);

//        postRepository.save(post);

//        Page<Comment> page = commentRepository3.findFirst10ByRecommendGreaterThanAndPostOrderByIdDesc(2, post, PageRequest.of(0,10));
/*
        Page<Comment> page = commentRepository3.findByMessageContainsIgnoreCase("COMMENT", PageRequest.of(0,10, Sort.by(Sort.Direction.DESC,"recommend")));
        assertThat(page.getTotalElements()).isEqualTo(2);
        assertThat(page).first().hasFieldOrPropertyWithValue("recommend", 100);
*/

        try(Stream<Comment> comments = commentRepository3.findByMessageContains("Comment", PageRequest.of(0,10, Sort.by(Sort.Direction.DESC,"recommend")))){
            Comment comment1 = comments.findFirst().get();
            assertThat(comment1.getMessage()).isEqualTo("Comment Test1");
        }

    }

}