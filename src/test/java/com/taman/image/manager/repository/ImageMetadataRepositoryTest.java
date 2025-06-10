package com.taman.image.manager.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ImageMetadataRepositoryTest {

    @Autowired
    private ImageMetadataRepository repository;

    @Test
    void contextLoads() {
        assertThat(this.repository).isNotNull();
    }
}