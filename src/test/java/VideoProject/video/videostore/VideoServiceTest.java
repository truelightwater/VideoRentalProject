package VideoProject.video.videostore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class VideoServiceTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    @DisplayName("name 에 공백이 담기면 안된다.")
    void blankTest() {
        Video video = new Video(" ");
        Set<ConstraintViolation<Video>> violations = validator.validate(video);

        violations.forEach(i -> System.out.println(i.getMessage()));

        assertThat(violations.size()).isEqualTo(1);

    }
}
