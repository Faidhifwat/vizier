package com.sultan.vizier.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentMapper commentMapper;

    public void create(List<CommentDto> commentDto) {
        List<Comment> comments = commentMapper.commentDtoToComment(commentDto);
        commentRepository.saveAll(comments);

    }
}
