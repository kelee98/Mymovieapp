package com.example.mymovieapp;

public class CommentItem {
    String user;
    String contents;

    public CommentItem(String user, String contents) {
        this.user = user;
        this.contents = contents;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "reviewItems{" +
                "user='" + user + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
