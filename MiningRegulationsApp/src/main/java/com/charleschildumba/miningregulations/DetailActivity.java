package com.charleschildumba.miningregulations;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends Activity {
    
    private TextView positionTitle;
    private TextView regulationNumber;
    private TextView appointedByText;
    private TextView legalResponsibilityText;
    private Button aiHelpButton;
    private Button backButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        
        initializeViews();
        populateData();
        setupClickListeners();
    }
    
    private void initializeViews() {
        positionTitle = findViewById(R.id.position_title);
        regulationNumber = findViewById(R.id.regulation_number);
        appointedByText = findViewById(R.id.appointed_by_text);
        legalResponsibilityText = findViewById(R.id.legal_responsibility_text);
        aiHelpButton = findViewById(R.id.ai_help_button);
        backButton = findViewById(R.id.back_button);
    }
    
    private void populateData() {
        Intent intent = getIntent();
        String regulation = intent.getStringExtra("regulation");
        String position = intent.getStringExtra("position");
        String appointedBy = intent.getStringExtra("appointedBy");
        String legalResponsibility = intent.getStringExtra("legalResponsibility");
        
        positionTitle.setText(position != null ? position : "Unknown Position");
        regulationNumber.setText("Mining Regulation: " + (regulation != null ? regulation : "Unknown"));
        appointedByText.setText(appointedBy != null ? appointedBy : "Unknown");
        legalResponsibilityText.setText(legalResponsibility != null ? legalResponsibility : "No details available");
    }
    
    private void setupClickListeners() {
        aiHelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, AIAssistantActivity.class);
                intent.putExtra("context", "I need help understanding the role of " + positionTitle.getText().toString());
                startActivity(intent);
            }
        });
        
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

