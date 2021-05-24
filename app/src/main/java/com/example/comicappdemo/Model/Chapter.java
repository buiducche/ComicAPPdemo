package com.example.comicappdemo.Model;

public class Chapter {
        private int ID;
        private String Name;
        private int MangaId;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getMangaId() {
        return MangaId;
    }

    public void setMangaId(int mangaId) {
        MangaId = mangaId;
    }

    public Chapter(int ID, String name, int mangaId) {
        this.ID = ID;
        Name = name;
        MangaId = mangaId;
    }
}
