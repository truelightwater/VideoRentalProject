package VideoProject.video.member;

import VideoProject.video.Annotation.NameAnnotation;
import VideoProject.video.Annotation.PhoneNumberAnnotation;
import VideoProject.video.Annotation.RangeAgeAnnotation;
import VideoProject.video.videostore.Video;

import java.util.ArrayList;
import java.util.UUID;

public class Member {
    private UUID id;
    @NameAnnotation(nameLength = 10)
    private String name;
    @PhoneNumberAnnotation
    private String phoneNumber;
    @RangeAgeAnnotation(min = 8, max = 100)
    private int age;

    private ArrayList<Video> arrayList;

    private Member(MemberBuilder builder) {
        this.id = UUID.randomUUID();
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.age = builder.age;
    }

    public static MemberBuilder builder() {
        return new MemberBuilder();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Video> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Video> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                '}';
    }

    public static class MemberBuilder {
        private String name;
        private int age;
        private String phoneNumber;

        public MemberBuilder name(String name) {
            this.name = name;
            return this;
        }

        public MemberBuilder age(int age) {
            this.age = age;
            return this;
        }

        public MemberBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Member build() {
            return new Member(this);

        }
    }
}
