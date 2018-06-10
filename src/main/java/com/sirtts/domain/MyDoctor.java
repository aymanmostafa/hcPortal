package com.sirtts.domain;

public class MyDoctor {

    private User doctor;

    private Boolean isFriend;

    public User getDoctor() {
        return doctor;
    }

    public String getDoctorName() {
        return doctor.getLogin();
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public Boolean getFriend() {
        return isFriend;
    }

    public void setFriend(Boolean friend) {
        isFriend = friend;
    }

    @Override
    public String toString() {
        return "MyDoctor{" +
            "doctor=" + doctor +
            ", isFriend=" + isFriend +
            '}';
    }
}
