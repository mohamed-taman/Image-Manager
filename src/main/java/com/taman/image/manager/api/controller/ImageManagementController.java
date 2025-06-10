package com.taman.image.manager.api.controller;

import com.taman.image.manager.api.model.request.ImageUpSrtRequest;
import com.taman.image.manager.api.model.response.ImageResponse;
import com.taman.image.manager.service.ImageManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

/**
 * Image Management controller used to handle images API functions.
 *
 * @author Mohamed Taman
 * @version 1.0
 */
@Log4j2
@Tag(name = "Image Management",
        description = "A set of APIs, for getting and managing images.")
@RestController
@RequestMapping("images")
@RequiredArgsConstructor
public class ImageManagementController {

    private final ImageManagementService imageMgmtService;

    @Operation(summary = "Get all images.",
            description = "Get all images as pages max 10 images per page.")
    @GetMapping
    public List<ImageResponse> getAllImages() {
        return this.imageMgmtService.getAllImages();
    }

    @Operation(summary = "Get specific image.",
            description = "Get selected image by its id.")
    @GetMapping("{id}")
    public ImageResponse getImage(@Parameter(description = "image Id")
                                  @PathVariable(name = "id")
                                  @Min(1) @Max(Integer.MAX_VALUE) int imageId) {
        return this.imageMgmtService.getImage(imageId);
    }

    //Add Image
    @Operation(summary = "Upload image(s).",
            description = "Upload one image, or a zip file contains more than one image.")
    @PostMapping
    public ResponseEntity<String> uploadImages(@RequestBody @Valid ImageUpSrtRequest request,
                                               @Parameter(name = "file", required = true,
                                                       description = "Select image(s) file to upload.")
                                               @RequestPart("file") MultipartFile imagesFile) {
        //this.imageMgmtService.addImages();

        return new ResponseEntity<>("Image(s) uploaded successfully.", OK);
    }

    //Update Image
    @Operation(summary = "Update image.",
            description = "Update the selected image and its information if any..")
    @PutMapping("{id}")
    public ResponseEntity<String> updateImage(@Parameter(description = "image Id")
                                              @PathVariable(name = "id")
                                              @Min(1) @Max(Integer.MAX_VALUE) int imageId,
                                              @RequestBody @Valid ImageUpSrtRequest request,
                                              @Parameter(name = "image", required = true,
                                                      description = "Select image to update.")
                                              @RequestPart("file") MultipartFile image) {

        //this.imageMgmtService.updateImage();

        return new ResponseEntity<>("Image updated successfully.", OK);
    }

    //Delete image
    @Operation(summary = "Delete image.",
            description = """
                    Delete an image that is obsolete,
                    but if there is a replacement you can use <i>Update image operation</i>.
                    """)
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteImage(@Parameter(description = "Image Id")
                                              @PathVariable(name = "id")
                                              @Min(1) @Max(Integer.MAX_VALUE) int imageId) {

        //this.imageMgmtService.deleteImage(imageId);

        return new ResponseEntity<>("Image deleted successfully.", OK);
    }


}
