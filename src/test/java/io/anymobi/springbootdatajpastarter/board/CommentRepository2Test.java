package io.anymobi.springbootdatajpastarter.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepository2Test {

    @Autowired
    CommentRepository2 commentRepository2;

    @Test
    public void commentCrud() {

        Comment comment2 = new Comment();
        comment2.setMessage("Comment Test2");

        Comment newComment = commentRepository2.save(comment2);
        commentRepository2.save(null);
        List<Comment> comments = commentRepository2.findAll();
        long count = commentRepository2.count();
        Optional<Comment> byIdOptional = commentRepository2.findById(newComment.getId());


        assertThat(newComment.getMessage()).isEqualTo("Comment Test2");
        assertThat(comments.size()).isEqualTo(1);
        assertThat(count).isEqualTo(1);
        assertThat(byIdOptional).isEmpty();


    }


}