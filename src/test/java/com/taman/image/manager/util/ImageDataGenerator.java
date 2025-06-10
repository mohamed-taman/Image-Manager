package com.taman.image.manager.util;

import com.taman.image.manager.api.model.response.ImageResponse;
import net.datafaker.Faker;

public final class ImageDataGenerator {

    private static final Faker dataFaker = new Faker();

    public static ImageResponse newImageResponse =
        new ImageResponse(
                1,
                "Azure AI Search",
                """
                        Azure AI Search (formerly known as "Azure Cognitive Search") is an enterprise-ready
                        information retrieval system for your heterogeneous content that you ingest into a search index,
                        and surface to users through queries and apps
                        """,
                "Azure, AI, Service", "", "Cloud", "Software",
                null);

    public static ImageResponse newImageResponse() {
        return new ImageResponse(
                dataFaker.number().randomDigitNotZero(),
                dataFaker.app().name(),
                """
                        Azure AI Search (formerly known as "Azure Cognitive Search") is an enterprise-ready
                        information retrieval system for your heterogeneous content that you ingest into a search index,
                        and surface to users through queries and apps
                        """,
                "Azure, AI, Service", "", "Cloud", "Software",
                null);
    }


}
