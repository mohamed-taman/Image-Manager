package com.taman.image.manager.repository;

import com.taman.image.manager.domain.ImageContent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageContentRepository extends CrudRepository<ImageContent, Integer> {
}
