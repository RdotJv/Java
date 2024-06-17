package com.example.sqltesting.model;

//record Profile2(String userName, int userAge) {
//    private int userid;
//
//    @Override
//    public String toString() {
//        return "Profile{" +
//                "userid=" + userid +
//                ", username='" + userName + '\'' +
//                ", userage=" + userAge +
//                '}';
//    }
//}

public class Profile {
    private int userId;
    private String userName;
    private int userAge;

    public Profile(String userName, int userAge) {
        this.userName = userName;
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "userid=" + userId +
                ", username='" + userName + '\'' +
                ", userage=" + userAge +
                '}';
    }

    public void setUserid(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserAge() {
        return userAge;
    }
}

