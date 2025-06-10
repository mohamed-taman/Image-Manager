package com.taman.image.manager.service;

import com.taman.image.manager.api.model.response.ImageResponse;

import java.util.List;

public interface ImageManagementService {
    List<ImageResponse> getAllImages();

    ImageResponse getImage(int imageId);

}
