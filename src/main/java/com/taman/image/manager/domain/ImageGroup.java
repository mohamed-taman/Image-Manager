package com.taman.image.manager.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

/**
 * Class represents ImageGroup domain model, as JPA Entity.
 *
 * @author Mohamed Taman
 * @version 1.0
 */
@Entity
@Table(name = "img_group")
@Getter
@Setter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@ToString
public class ImageGroup implements Serializable {

    @Serial
    private static final long serialVersionUID = 5666668516577592568L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    protected Integer id;

    @NonNull
    @Basic(optional = false)
    @Column(name = "NAME", nullable = false, length = 100)
    protected String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "group", fetch = LAZY)
    private List<ImageCategory> categories;
}
