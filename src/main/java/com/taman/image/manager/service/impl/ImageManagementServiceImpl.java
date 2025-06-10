package com.taman.image.manager.service.impl;

import com.taman.image.manager.api.model.response.ImageResponse;
import com.taman.image.manager.repository.ImageCategoryRepository;
import com.taman.image.manager.repository.ImageContentRepository;
import com.taman.image.manager.repository.ImageGroupRepository;
import com.taman.image.manager.repository.ImageMetadataRepository;
import com.taman.image.manager.service.ImageManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Collections.emptyList;

@Service
@Log4j2
@RequiredArgsConstructor
public class ImageManagementServiceImpl implements ImageManagementService {

    private final ImageCategoryRepository categoryRepository;
    private final ImageGroupRepository groupRepository;
    private final ImageMetadataRepository metadataRepository;
    private final ImageContentRepository contentRepository;

    @Override
    public List<ImageResponse> getAllImages() {
        return emptyList();
    }

    @Override
    public ImageResponse getImage(int imageId) {
        return null;
    }
}
