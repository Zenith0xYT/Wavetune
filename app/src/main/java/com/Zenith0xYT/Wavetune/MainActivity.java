package com.zenith.wavetune;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText searchQuery;
    Switch toggleSwitch;
    Button searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchQuery = findViewById(R.id.searchQuery);
        toggleSwitch = findViewById(R.id.toggleSwitch);
        searchBtn = findViewById(R.id.searchBtn);

        searchBtn.setOnClickListener(view -> {
            String query = searchQuery.getText().toString().trim();
            boolean isVideo = toggleSwitch.isChecked();

            if (!query.isEmpty()) {
                Intent intent = new Intent(MainActivity.this, YouTubeActivity.class);
                intent.putExtra("QUERY", query);
                intent.putExtra("IS_VIDEO", isVideo);
                startActivity(intent);
            }
        });
    }
}
