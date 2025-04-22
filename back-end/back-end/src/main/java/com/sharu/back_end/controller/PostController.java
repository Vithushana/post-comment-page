package com.sharu.back_end.controller;

import com.sharu.back_end.model.Comment;
import com.sharu.back_end.model.Post;
import com.sharu.back_end.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.createPost(post));
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @PostMapping("/{postId}/comment")
    public ResponseEntity<Post> addComment(@PathVariable String postId, @RequestBody Comment comment) {
        return ResponseEntity.ok(postService.addComment(postId, comment));
    }

    @PutMapping("/{postId}/comment/{commentId}")
    public ResponseEntity<Post> updateComment(@PathVariable String postId, @PathVariable String commentId, @RequestBody String text) {
        return ResponseEntity.ok(postService.updateComment(postId, commentId, text));
    }

    @PutMapping("/{postId}/like")
    public ResponseEntity<Post> toggleLike(@PathVariable String postId) {
        return ResponseEntity.ok(postService.toggleLike(postId));
    }
}
