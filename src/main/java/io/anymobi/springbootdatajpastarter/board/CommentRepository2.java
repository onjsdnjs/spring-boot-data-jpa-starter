package io.anymobi.springbootdatajpastarter.board;

import io.anymobi.springbootdatajpastarter.repository.MyRepository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

public interface CommentRepository2 extends MyRepository<Comment, Long> {

}
