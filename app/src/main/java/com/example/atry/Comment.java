package com.example.atry;

public class Comment {
    private static String Name;
    private String Comment;
    private  Integer Phone;

    public Comment() {
    }

    public String getName() {
        return Name;
    }

    public static void setName(String name) {
        Name = name;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public Integer getPhone() {
        return Phone;
    }

    public void setPhone(Integer phone) {
        Phone = phone;
    }
}
