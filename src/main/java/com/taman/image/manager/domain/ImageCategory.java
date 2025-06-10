package com.taman.image.manager.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

import static jakarta.persistence.FetchType.LAZY;

/**
 * Class represents ImageCategory domain model, as JPA Entity.
 *
 * @author Mohamed Taman
 * @version 1.0
 */
@Entity
@Table(name = "img_category")
@Getter
@Setter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@ToString
public class ImageCategory implements Serializable {

    @Serial
    private static final long serialVersionUID = -4975104206005360547L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;


    @NonNull
    @Basic(optional = false)
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @ToString.Exclude
    @NonNull
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = LAZY)
    private ImageGroup group;
}
