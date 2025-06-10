package com.taman.image.manager.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * Class represents ImageContent domain model, as JPA Entity.
 *
 * @author Mohamed Taman
 * @version 1.0
 */
@Entity
@Table(name = "img_content")
@Getter
@Setter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@ToString
public class ImageContent implements Serializable {

    @Serial
    private static final long serialVersionUID = 5850186091684263879L;

    @NonNull
    @Id
    @Basic(optional = false)
    @Column(name = "METADATA_ID", nullable = false)
    private Integer metadataId;

    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "METADATA_ID", referencedColumnName = "ID", nullable = false)
    private ImageMetadata imageMetadata;

    @ToString.Exclude
    @Lob
    @Basic(optional = false, fetch = FetchType.LAZY)
    @Column(name = "CONTENT", columnDefinition="BLOB", nullable = false)
    private byte @NonNull [] content;

    @ToString.Exclude
    @Lob
    @Basic(optional = false)
    @Column(name = "THUMBNAIL", columnDefinition="BLOB", nullable = false)
    private byte @NonNull [] thumbnail;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ImageContent that)) return false;
        return Objects.equals(getMetadataId(), that.getMetadataId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getMetadataId());
    }
}
