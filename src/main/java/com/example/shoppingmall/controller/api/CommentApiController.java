package com.example.shoppingmall.controller.api;

import com.example.shoppingmall.domain.Comment;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentApiController {
    @PostMapping
    public Comment addComment(@RequestBody Comment comment){
        comment.setId(100L);
        return comment;
    }
    @GetMapping
    public List<Comment> getComments(){
        List<Comment> list = new ArrayList<>();
        Comment commnet = new Comment();
        commnet.setName("kim");
        commnet.setPasswd("1234");
        commnet.setContent("hello");
        list.add(commnet);

        Comment commnet2 = new Comment();
        commnet2.setName("kim");
        commnet2.setPasswd("1234");
        commnet2.setContent("hello");
        list.add(commnet2);

        return list;
    }
}