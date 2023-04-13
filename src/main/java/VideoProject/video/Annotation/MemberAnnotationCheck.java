package VideoProject.video.Annotation;

import VideoProject.video.member.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

public class MemberAnnotationCheck {

    private final Logger log = LoggerFactory.getLogger(getClass());

    public boolean memberValidation(Member member) {
        Field[] fields = member.getClass().getDeclaredFields();

        for (Field field : fields) {
            NameAnnotation maxLength = field.getAnnotation(NameAnnotation.class);
            PhoneNumberAnnotation numberCheck = field.getAnnotation(PhoneNumberAnnotation.class);

            if (field.isAnnotationPresent(RangeAgeAnnotation.class) && field.getType() == int.class) {
                RangeAgeAnnotation ageCheck = field.getAnnotation(RangeAgeAnnotation.class);
                int min = ageCheck.min();
                int max = ageCheck.max();
                field.setAccessible(true);

                try {
                    int value = field.getInt(member);
                    if (value < min) {
                        log.info("나이가 너무 어립니다.");
                        return false;
                    } else if (value > max) {
                        log.info("나이가 너무 많습니다.");
                        return false;
                    }

                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }

            } else if (maxLength != null && field.getType() == String.class) {
                int lengthLimit = maxLength.nameLength();
                field.setAccessible(true);      // private 로 선언된 필드를 접근가능하게 한다.

                try {
                    String value = (String) field.get(member);
                    if (value.length() > lengthLimit) {
                        log.info("이름의 길이가 너무 깁니다.");
                        return false;
                        //throw new IllegalArgumentException("이름의 길이가 " + lengthLimit + "을 초과합니다.");
                    }

                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }

            } else if (numberCheck != null && field.getType() == String.class) {
                field.setAccessible(true);

                try {
                    String phoneNumber = (String) field.get(member);
                    if (!phoneNumber.matches("\\d{3}-\\d{3,4}-\\d{4}")) {
                        log.info("올바른 휴대폰 번호가 아닙니다.");
                        return false;
                        // throw new IllegalArgumentException("올바른 휴대폰 번호가 아닙니다.");
                    }

                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }

        }

        return true;
    }
}
