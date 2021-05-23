package com.example.comicappdemo.Model;

public class Banner {
    private int ID;
    private String Link;

    public Banner(int ID, String link) {
        this.ID = ID;
        Link = link;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "ID=" + ID +
                ", Link='" + Link + '\'' +
                '}';
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
}
