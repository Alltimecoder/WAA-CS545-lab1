package com.miu.lab1.repository.impl;

import com.miu.lab1.domain.Post;
import com.miu.lab1.domain.dto.PostDTO;
import com.miu.lab1.repository.PostRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepositoryImpl implements PostRepository {

  private static List<Post> posts;
  private static int id_counter = 100;

  static {
    posts = new ArrayList<>();
    Post post1 = new Post(id_counter, "title 1", "custom content", "Sayal");
    id_counter++;

    Post post2 = new Post(id_counter, "title 2", "custom content", "Sayal");
    id_counter++;

    Post post3 = new Post(id_counter, "title 3", "custom content", "Sayal");
    id_counter++;

    posts.add(post1);
    posts.add(post2);
    posts.add(post3);
  }

  @Override
  public Post getPostById(long id) {
    return posts.stream()
        .filter(post -> post.getId() == id)
        .findFirst()
        .orElse(null);
  }

  @Override
  public List<Post> getAllPost() {
    return posts;
  }

  @Override
  public void save(Post post) {
    posts.add(post);
    id_counter++;
  }

  @Override
  public void deleteById(long id) {
    var post = posts
        .stream()
        .filter(l -> l.getId() == id)
        .findFirst().get();
    posts.remove(post);
    id_counter--;
  }

  @Override
  public void update(PostDTO post, long postId) {
    Post toUpdate = getPostById(postId);
    toUpdate.setTitle(post.getTitle());
    toUpdate.setAuthor(post.getAuthor());
    toUpdate.setContent(post.getContent());
  }
}
