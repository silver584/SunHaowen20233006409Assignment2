package com.example.assignmenttwo;

import java.util.ArrayList;
import java.util.List;

public class Leaderboard {
    private static List<Player> leaderboard = new ArrayList<>();

    // Add a player to the leaderboard
    public static void addPlayerScore(Player player) {
        leaderboard.add(player);
    }

    // Get the list of players
    public static List<Player> getLeaderboard() {
        return leaderboard;
    }
}
