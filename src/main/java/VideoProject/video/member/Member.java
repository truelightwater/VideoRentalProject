package VideoProject.video.member;

import java.util.ArrayList;
import java.util.UUID;

public class Member {
    private UUID id;
    private String name;
    private String phoneNumber;
    private int age;
    private ArrayList videoList;

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

    public void setAge(Integer age) {
        this.age = age;
    }

    public ArrayList getVideoList() {
        return videoList;
    }

    public void setVideoList(ArrayList arrayList) {
        this.videoList = arrayList;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                ", videoList=" + videoList +
                '}';
    }
}
