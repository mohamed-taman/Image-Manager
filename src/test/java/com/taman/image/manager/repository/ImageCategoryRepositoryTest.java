package com.taman.image.manager.repository;

import com.taman.image.manager.domain.ImageCategory;
import com.taman.image.manager.domain.ImageGroup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ImageCategoryRepositoryTest {

    @Autowired
    private ImageCategoryRepository categoryRepository;

    @Autowired
    private ImageGroupRepository groupRepository;

    @Test
    void contextLoads() {
        assertThat(this.categoryRepository).isNotNull();
        assertThat(this.groupRepository).isNotNull();
    }

    @Test
    void whenFindCategoryById_thenReturnTheRelevantImageCategory() {

        // when
        var optionalCategory = categoryRepository.findById(1);

        // then
        assertThat(optionalCategory.isPresent()).isTrue();
        var imageCategory = optionalCategory.get();

        assertThat(imageCategory.getId()).isEqualTo(1);
        assertThat(imageCategory.getName()).isEqualTo("Cloud");

        //Check category group
        assertThat(imageCategory.getGroup()).isNotNull();
        assertThat(imageCategory.getGroup().getId()).isEqualTo(1);
        assertThat(imageCategory.getGroup().getName()).isEqualTo("Software");
    }

    @Test
    void whenSaveImageCategory_thenReturnCreatedImageCategory() {
        // given
        var group = groupRepository.save(new ImageGroup("Vegetables"));
        var category = categoryRepository.save(new ImageCategory("Tomato", group));

        // when
        var optionalCategory = categoryRepository.findById(category.getId());

        // then
        assertThat(optionalCategory.isPresent()).isTrue();
        var imageCategory = optionalCategory.get();

        assertThat(imageCategory.getId()).isEqualTo(2);
        assertThat(imageCategory.getName()).isEqualTo("Tomato");

        //Check category group
        assertThat(imageCategory.getGroup()).isNotNull();
        assertThat(imageCategory.getGroup().getId()).isEqualTo(2);
        assertThat(imageCategory.getGroup().getName()).isEqualTo("Vegetables");
    }
}