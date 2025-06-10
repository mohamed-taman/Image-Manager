package com.taman.image.manager.service;

import com.taman.image.manager.repository.ImageCategoryRepository;
import com.taman.image.manager.repository.ImageContentRepository;
import com.taman.image.manager.repository.ImageGroupRepository;
import com.taman.image.manager.repository.ImageMetadataRepository;
import com.taman.image.manager.service.impl.ImageManagementServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
class ImageManagementServiceTest {

    @Mock
    private ImageMetadataRepository metadataRepository;

    @Mock
    private ImageContentRepository contentRepository;

    @Mock
    private ImageCategoryRepository categoryRepository;

    @Mock
    private ImageGroupRepository groupRepository;

    // Assume ImageManagementService uses all mocked repositories
    @InjectMocks
    private ImageManagementServiceImpl imageManagementService;

    @Test
    void contextLoads() {
        assertThat(this.imageManagementService).isNotNull();
    }

}