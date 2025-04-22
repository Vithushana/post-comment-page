package com.sharu.back_end.services;

import com.sharu.back_end.model.Comment;
import com.sharu.back_end.model.Post;
import com.sharu.back_end.respository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepo;

    public Post createPost(Post post) {
        return postRepo.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepo.findAllByOrderByCreatedAtDesc();
    }

    public Post addComment(String postId, Comment comment) {
        Post post = postRepo.findById(postId).orElseThrow();
        post.getComments().add(comment);
        return postRepo.save(post);
    }

    public Post updateComment(String postId, String commentId, String text) {
        Post post = postRepo.findById(postId).orElseThrow();
        post.getComments().forEach(c -> {
            if (c.getId().equals(commentId)) {
                c.setText(text);
            }
        });
        return postRepo.save(post);
    }

    public Post toggleLike(String postId) {
        Post post = postRepo.findById(postId).orElseThrow();
        boolean isLiked = post.isLiked();
        post.setLiked(!isLiked);
        post.setLikes(isLiked ? post.getLikes() - 1 : post.getLikes() + 1);
        return postRepo.save(post);
    }
}
