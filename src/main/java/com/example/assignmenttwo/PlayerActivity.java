package com.example.assignmenttwo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Button btnSubmit = findViewById(R.id.btnSubmit);

        // Submit button listener
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Here you can add logic for saving the player's name and score
                // After that, navigate back to MainActivity or to another relevant activity
                Intent intent = new Intent(PlayerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
