package com.taman.image.manager.repository;

import com.taman.image.manager.domain.ImageGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageGroupRepository extends CrudRepository<ImageGroup, Integer> {
}
