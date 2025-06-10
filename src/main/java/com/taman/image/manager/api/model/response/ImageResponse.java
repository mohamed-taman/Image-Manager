package com.taman.image.manager.api.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ImageResponse(@JsonProperty int id,
                            @JsonProperty String name,
                            @JsonProperty String description,
                            @JsonProperty String tags,
                            @JsonProperty String type,
                            @JsonProperty String category,
                            @JsonProperty String group,
                            @JsonProperty byte[] content) {

}
