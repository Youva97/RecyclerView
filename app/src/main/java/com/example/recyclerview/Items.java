package com.example.recyclerview;

public class Items {

    private int image;
    private String titre, description;

    public Items(int image, String titre, String description){
        this.image = image;
        this.titre = titre;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
