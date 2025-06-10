package com.taman.image.manager.repository;

import com.taman.image.manager.domain.ImageCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageCategoryRepository extends CrudRepository<ImageCategory, Integer> {
}
