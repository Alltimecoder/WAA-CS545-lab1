package com.miu.lab1.service.impl;

import com.miu.lab1.domain.Post;
import com.miu.lab1.domain.dto.PostDTO;
import com.miu.lab1.repository.PostRepository;
import com.miu.lab1.service.PostService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;
  private final ModelMapper modelMapper;

  @Autowired
  public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
    this.postRepository = postRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public List<PostDTO> findAll() {
    return postRepository.getAllPost().stream()
        .map(post -> modelMapper.map(postRepository.getPostById(post.getId()), PostDTO.class))
        .collect(Collectors.toList());
  }

  @Override
  public PostDTO getById(int id) {
    return modelMapper.map(postRepository.getPostById(id), PostDTO.class);
  }

  @Override
  public void save(PostDTO p) {
    postRepository.save(modelMapper.map(p, Post.class));
  }

  @Override
  public void delete(int id) {
    postRepository.deleteById(id);
  }

  @Override
  public void update(PostDTO p, long id) {
    postRepository.update(p, id);
  }

  @Override
  public List<PostDTO> filterByAuthor(String author) {
    return findAll().stream()
        .filter(postDTO -> postDTO.getAuthor().equals(author))
        .collect(Collectors.toList());
  }
}
