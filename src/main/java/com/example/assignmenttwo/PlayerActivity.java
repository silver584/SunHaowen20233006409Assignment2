package com.example.assignmenttwo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlayerActivity extends AppCompatActivity {
    private EditText playerNameEditText;
    private RadioGroup avatarGroup;
    private Button submitButton;
    private TextView finalScoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        playerNameEditText = findViewById(R.id.etPlayerName);
        avatarGroup = findViewById(R.id.rgAvatar);
        submitButton = findViewById(R.id.btnSubmit);
        finalScoreTextView = findViewById(R.id.tvFinalScore);

        // Get the score passed from the game activity
        int finalScore = getIntent().getIntExtra("score", 0);
        finalScoreTextView.setText("Score: " + finalScore);

        submitButton.setOnClickListener(v -> {
            String playerName = playerNameEditText.getText().toString();
            if (playerName.isEmpty()) {
                playerNameEditText.setError("Please enter your name");
                return;
            }


            // Go to the leaderboard activity
            Intent intent = new Intent(PlayerActivity.this, LeaderboardActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
