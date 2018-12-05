package io.anymobi.springbootdatajpastarter.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {


    @Autowired
    CommentRepository commentRepository;

    @Test
    public void commentCrud() {

        Comment comment = new Comment();
        comment.setMessage("Comment Test");

        Comment newComment = commentRepository.save(comment);
        List<Comment> comments = commentRepository.findAll();

        assertThat(newComment.getMessage()).isEqualTo("Comment Test");
        assertThat(comments.size()).isEqualTo(1);


    }

}