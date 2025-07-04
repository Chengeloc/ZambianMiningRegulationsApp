package com.charleschildumba.miningregulations;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class AppointmentActivity extends Activity {
    
    private Button filterAll;
    private Button filterManager;
    private Button filterEngineer;
    private ListView appointmentsList;
    
    private List<MiningRegulation> currentAppointments;
    private ArrayAdapter<MiningRegulation> adapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        
        initializeViews();
        setupClickListeners();
        loadAllAppointments();
    }
    
    private void initializeViews() {
        filterAll = findViewById(R.id.filter_all);
        filterManager = findViewById(R.id.filter_manager);
        filterEngineer = findViewById(R.id.filter_engineer);
        appointmentsList = findViewById(R.id.appointments_list);
    }
    
    private void setupClickListeners() {
        filterAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActiveFilter(filterAll);
                loadAllAppointments();
            }
        });
        
        filterManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActiveFilter(filterManager);
                loadFilteredAppointments("manager");
            }
        });
        
        filterEngineer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActiveFilter(filterEngineer);
                loadFilteredAppointments("engineer");
            }
        });
        
        appointmentsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (currentAppointments != null && position < currentAppointments.size()) {
                    MiningRegulation selectedAppointment = currentAppointments.get(position);
                    openDetailView(selectedAppointment);
                }
            }
        });
    }
    
    private void setActiveFilter(Button activeButton) {
        // Reset all buttons
        filterAll.setBackgroundColor(getResources().getColor(R.color.textColorSecondary));
        filterManager.setBackgroundColor(getResources().getColor(R.color.textColorSecondary));
        filterEngineer.setBackgroundColor(getResources().getColor(R.color.textColorSecondary));
        
        // Set active button
        activeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
    }
    
    private void loadAllAppointments() {
        currentAppointments = RegulationData.getAllRegulations();
        updateListView();
    }
    
    private void loadFilteredAppointments(String filter) {
        currentAppointments = RegulationData.searchRegulations(filter);
        updateListView();
    }
    
    private void updateListView() {
        adapter = new ArrayAdapter<MiningRegulation>(this, android.R.layout.simple_list_item_2, android.R.id.text1, currentAppointments) {
            @Override
            public View getView(int position, View convertView, android.view.ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                MiningRegulation appointment = currentAppointments.get(position);
                
                TextView text1 = view.findViewById(android.R.id.text1);
                TextView text2 = view.findViewById(android.R.id.text2);
                
                text1.setText(appointment.getPosition());
                text2.setText("M.R. " + appointment.getRegulation() + " | Appointed by: " + appointment.getAppointedBy());
                
                return view;
            }
        };
        
        appointmentsList.setAdapter(adapter);
    }
    
    private void openDetailView(MiningRegulation appointment) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("regulation", appointment.getRegulation());
        intent.putExtra("position", appointment.getPosition());
        intent.putExtra("appointedBy", appointment.getAppointedBy());
        intent.putExtra("legalResponsibility", appointment.getLegalResponsibility());
        startActivity(intent);
    }
}

