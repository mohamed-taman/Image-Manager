package com.taman.image.manager.api.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ImageUpSrtRequest(@JsonProperty @NotBlank String name,
                                @JsonProperty String description,
                                @JsonProperty @NotBlank String tags,
                                @JsonProperty @NotBlank String type,
                                @JsonProperty @NotBlank String category,
                                @JsonProperty @NotBlank String group) {

}
