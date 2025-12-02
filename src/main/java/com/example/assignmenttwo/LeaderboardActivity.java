package com.example.assignmenttwo;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.whackamole.models.Leaderboard;
import com.example.whackamole.models.Player;

import java.util.List;

public class LeaderboardActivity extends AppCompatActivity {
    private LinearLayout leaderboardLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        leaderboardLayout = findViewById(R.id.leaderboardLayout);

        // Get the leaderboard from the Leaderboard class
        List<Player> leaderboard = Leaderboard.getLeaderboard();

        // Iterate over the leaderboard and add views dynamically
        for (Player player : leaderboard) {
            // Dynamically create a LinearLayout for each player
            LinearLayout playerLayout = new LinearLayout(this);
            playerLayout.setOrientation(LinearLayout.HORIZONTAL);
            playerLayout.setPadding(0, 8, 0, 8);

            // Create an ImageView for the avatar
            ImageView avatarImageView = new ImageView(this);
            avatarImageView.setImageResource(getResources().getIdentifier(player.getAvatar(), "drawable", getPackageName()));
            avatarImageView.setLayoutParams(new LinearLayout.LayoutParams(50, 50));
            avatarImageView.setPadding(12, 0, 12, 0);

            // Create a TextView for the player's name
            TextView nameTextView = new TextView(this);
            nameTextView.setText(player.getName());
            nameTextView.setTextSize(18);
            nameTextView.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));

            // Create a TextView for the player's score
            TextView scoreTextView = new TextView(this);
            scoreTextView.setText(String.valueOf(player.getScore()));
            scoreTextView.setTextSize(18);
            scoreTextView.setTextColor(getResources().getColor(android.R.color.black));

            // Add all the views to the playerLayout
            playerLayout.addView(avatarImageView);
            playerLayout.addView(nameTextView);
            playerLayout.addView(scoreTextView);

            // Add playerLayout to leaderboardLayout
            leaderboardLayout.addView(playerLayout);
        }
    }
}
