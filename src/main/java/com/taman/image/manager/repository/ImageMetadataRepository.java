package com.taman.image.manager.repository;

import com.taman.image.manager.domain.ImageMetadata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageMetadataRepository extends CrudRepository<ImageMetadata, Integer> {
}
