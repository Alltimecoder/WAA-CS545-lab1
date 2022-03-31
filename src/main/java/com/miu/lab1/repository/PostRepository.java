package com.miu.lab1.repository;

import com.miu.lab1.domain.Post;
import com.miu.lab1.domain.dto.PostDTO;
import java.util.List;

public interface PostRepository {

  Post getPostById(long id);

  List<Post> getAllPost();

  void save(Post post);

  void deleteById(long id);

  void update(PostDTO post, long postId);
}
