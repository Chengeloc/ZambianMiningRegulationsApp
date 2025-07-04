package com.charleschildumba.miningregulations;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.drawable.Drawable;
import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

public class DiagramsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagrams);

        LinearLayout diagramsContainer = findViewById(R.id.diagrams_container);
        AssetManager assetManager = getAssets();

        // Add Organizational Structure Diagram
        addDiagram(diagramsContainer, assetManager, "organizational_structure.png", "Organizational Structure");

        // Add Appointment Process Diagram
        addDiagram(diagramsContainer, assetManager, "appointment_process.png", "Appointment Process");
    }

    private void addDiagram(LinearLayout container, AssetManager assetManager, String fileName, String title) {
        TextView titleView = new TextView(this);
        titleView.setText(title);
        titleView.setTextSize(20);
        titleView.setTextColor(getResources().getColor(R.color.colorPrimary));
        titleView.setPadding(0, 16, 0, 8);
        container.addView(titleView);

        ImageView imageView = new ImageView(this);
        try {
            InputStream ims = assetManager.open("diagrams/" + fileName);
            Drawable d = Drawable.createFromStream(ims, null);
            imageView.setImageDrawable(d);
            ims.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            // Handle error, e.g., show a placeholder image or error message
        }
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        container.addView(imageView);
    }
}

