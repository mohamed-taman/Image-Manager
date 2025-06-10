package com.taman.image.manager.repository;

import com.taman.image.manager.domain.ImageGroup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ImageGroupRepositoryTest {

    @Autowired
    private ImageGroupRepository repository;

    @Test
    void contextLoads() {
        assertThat(this.repository).isNotNull();
    }

    @Test
    void whenFindGroupById_thenReturnTheRelevantImageGroup() {

        // when
        var optionalGroup = repository.findById(1);

        // then
        assertThat(optionalGroup.isPresent()).isTrue();
        assertThat(optionalGroup.get().getId()).isEqualTo(1);
        assertThat(optionalGroup.get().getName()).isEqualTo("Software");
        assertThat(optionalGroup.get().getCategories()).isNotNull();
        assertThat(optionalGroup.get().getCategories().size()).isEqualTo(1);
    }

    @Test
    void whenSaveImageGroup_thenReturnCreatedImageGroup() {
        // given
        var group = repository.save(new ImageGroup("Food"));

        // when
        var optionalGroup = repository.findById(group.getId());

        // then
        assertThat(optionalGroup.isPresent()).isTrue();
        assertThat(optionalGroup.get().getId()).isEqualTo(group.getId());
        assertThat(optionalGroup.get().getName()).isEqualTo("Food");
        assertThat(optionalGroup.get().getCategories()).isNull();
    }
}