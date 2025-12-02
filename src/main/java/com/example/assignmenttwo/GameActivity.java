package com.example.assignmenttwo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    private Handler moleHandler = new Handler();
    private Runnable moleRunnable;
    private int score = 0;
    private TextView scoreTextView;
    private int[] moleImageIds = {R.id.iv_without_mole_01, R.id.iv_without_mole_02, R.id.iv_without_mole_03,
            R.id.iv_without_mole_04, R.id.iv_without_mole_05, R.id.iv_without_mole_06,
            R.id.iv_without_mole_07, R.id.iv_without_mole_08, R.id.iv_without_mole_09};
    private final long MOLE_DISPLAY_TIME = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        scoreTextView = findViewById(R.id.tv_score_text);

        moleRunnable = new Runnable() {
            @Override
            public void run() {
                // Randomly pick a mole and make it visible
                int randomMole = (int) (Math.random() * moleImageIds.length);
                ImageView mole = findViewById(moleImageIds[randomMole]);
                mole.setImageResource(R.drawable.img_with_mole);

                // Set click listener for mole to increase score
                mole.setOnClickListener(v -> {
                    score++;
                    updateScore();
                    mole.setImageResource(R.drawable.img_without_mole);  // Mole disappears
                });

                // Mole disappears after a short time
                moleHandler.postDelayed(() -> mole.setImageResource(R.drawable.img_without_mole), MOLE_DISPLAY_TIME);

                // Schedule the next mole appearance
                moleHandler.postDelayed(this, MOLE_DISPLAY_TIME);
            }
        };
        moleHandler.post(moleRunnable);  // Start the loop

        // Start a countdown timer for 30 seconds

    }

    private void updateScore() {
        scoreTextView.setText("Score: " + score);
    }
}
