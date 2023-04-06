package VideoProject.video.member;

import VideoProject.video.videostore.Video;

import java.util.ArrayList;

public class Member {
    private Long id;
    private String name;
    private String phoneNumber;
    private String address;
    private Integer age;
    private ArrayList videoList;

    public Member(Long id, String name, String phoneNumber, String address, Integer age) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
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
                ", address='" + address + '\'' +
                ", age=" + age +
                ", videoList=" + videoList +
                '}';
    }
}
