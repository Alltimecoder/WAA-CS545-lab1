package com.miu.lab1.service;

import com.miu.lab1.domain.dto.PostDTO;
import java.util.List;

public interface PostService {

  List<PostDTO> findAll();

  PostDTO getById(int id);

  void save(PostDTO p);

  void delete(int id);

  void update(PostDTO p, long id);

  List<PostDTO> filterByAuthor(String author);

}
