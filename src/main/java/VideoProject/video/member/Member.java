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

    public Member() {
        this.id = UUID.randomUUID();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
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
}
