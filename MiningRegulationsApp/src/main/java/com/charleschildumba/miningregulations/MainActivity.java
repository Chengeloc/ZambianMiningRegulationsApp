package com.charleschildumba.miningregulations;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    
    private EditText searchInput;
    private Button searchButton;
    private Button appointmentsButton;
    private Button aiAssistantButton;
    private Button diagramsButton; // Added for Diagrams
    private Button aboutButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initializeViews();
        setupClickListeners();
    }
    
    private void initializeViews() {
        searchInput = findViewById(R.id.search_input);
        searchButton = findViewById(R.id.search_button);
        appointmentsButton = findViewById(R.id.appointments_button);
        aiAssistantButton = findViewById(R.id.ai_assistant_button);
        diagramsButton = findViewById(R.id.diagrams_button); // Initialize Diagrams button
        aboutButton = findViewById(R.id.about_button);
    }
    
    private void setupClickListeners() {
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });
        
        appointmentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAppointments();
            }
        });
        
        aiAssistantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAIAssistant();
            }
        });

        diagramsButton.setOnClickListener(new View.OnClickListener() { // Click listener for Diagrams
            @Override
            public void onClick(View v) {
                openDiagrams();
            }
        });
        
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAbout();
            }
        });
    }
    
    private void performSearch() {
        String query = searchInput.getText().toString().trim();
        if (query.isEmpty()) {
            Toast.makeText(this, "Please enter a search term", Toast.LENGTH_SHORT).show();
            return;
        }
        
        Intent intent = new Intent(this, SearchActivity.class);
        intent.putExtra("query", query);
        startActivity(intent);
    }
    
    private void openAppointments() {
        Intent intent = new Intent(this, AppointmentActivity.class);
        startActivity(intent);
    }
    
    private void openAIAssistant() {
        Intent intent = new Intent(this, AIAssistantActivity.class);
        startActivity(intent);
    }

    private void openDiagrams() { // Method to open DiagramsActivity
        Intent intent = new Intent(this, DiagramsActivity.class);
        startActivity(intent);
    }
    
    private void showAbout() {
        Toast.makeText(this, "Mining Regulations Guide v1.0\nBuilt by Charles Chilumba - HSE Specialist\n+260779809511", Toast.LENGTH_LONG).show();
    }
}


