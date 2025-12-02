package com.example.assignmenttwo;

public class Player {
    private String name;
    private int score;
    private String avatar;

    // Constructor
    public Player(String name, int score, String avatar) {
        this.name = name;
        this.score = score;
        this.avatar = avatar;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getAvatar() {
        return avatar;
    }
}
