package com.taman.image.manager.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import static java.time.LocalDateTime.now;

/**
 * Class represents ImageMetadata domain model, as JPA Entity.
 *
 * @author Mohamed Taman
 * @version 1.0
 */
@Entity
@Table(name = "img_metadata")
@Getter
@Setter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@ToString
public class ImageMetadata implements Serializable {

    @Serial
    private static final long serialVersionUID = -9127236872277349206L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;

    @NonNull
    @Basic(optional = false)
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @NonNull
    @Basic(optional = false)
    @Column(name = "DESCRIPTION", nullable = false, length = 600)
    private String description;

    @NonNull
    @Basic(optional = false)
    @Column(name = "TAGS", nullable = false)
    private String tags;

    @NonNull
    @Basic(optional = false)
    @Column(name = "TYPE", nullable = false, length = 20)
    private String type;

    @NonNull
    @Basic(optional = false)
    @Column(name = "LOCATION", nullable = false)
    private String location;

    @Basic(optional = false)
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt = now();

    @Basic(optional = false)
    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    @ToString.Exclude
    @OneToOne(mappedBy = "imageMetadata")
    private ImageContent imageContent;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID", nullable = false)
    private ImageCategory imageCategory;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ImageMetadata that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(),
                that.getName()) && Objects.equals(getType(), that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getType());
    }
}
