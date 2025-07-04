package com.charleschildumba.miningregulations;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SearchActivity extends Activity {
    
    private EditText searchInput;
    private Button searchButton;
    private TextView resultsHeader;
    private ListView resultsList;
    private TextView noResultsMessage;
    
    private List<MiningRegulation> currentResults;
    private ArrayAdapter<MiningRegulation> adapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        
        initializeViews();
        setupClickListeners();
        
        // Get initial query from intent
        String initialQuery = getIntent().getStringExtra("query");
        if (initialQuery != null && !initialQuery.isEmpty()) {
            searchInput.setText(initialQuery);
            performSearch(initialQuery);
        }
    }
    
    private void initializeViews() {
        searchInput = findViewById(R.id.search_input);
        searchButton = findViewById(R.id.search_button);
        resultsHeader = findViewById(R.id.results_header);
        resultsList = findViewById(R.id.results_list);
        noResultsMessage = findViewById(R.id.no_results_message);
    }
    
    private void setupClickListeners() {
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = searchInput.getText().toString().trim();
                if (query.isEmpty()) {
                    Toast.makeText(SearchActivity.this, "Please enter a search term", Toast.LENGTH_SHORT).show();
                    return;
                }
                performSearch(query);
            }
        });
        
        resultsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (currentResults != null && position < currentResults.size()) {
                    MiningRegulation selectedRegulation = currentResults.get(position);
                    openDetailView(selectedRegulation);
                }
            }
        });
    }
    
    private void performSearch(String query) {
        currentResults = RegulationData.searchRegulations(query);
        
        if (currentResults.isEmpty()) {
            resultsList.setVisibility(View.GONE);
            noResultsMessage.setVisibility(View.VISIBLE);
            resultsHeader.setText("No results found for: " + query);
        } else {
            noResultsMessage.setVisibility(View.GONE);
            resultsList.setVisibility(View.VISIBLE);
            resultsHeader.setText("Search Results (" + currentResults.size() + " found)");
            
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_2, android.R.id.text1, currentResults) {
                @Override
                public View getView(int position, View convertView, android.view.ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    MiningRegulation regulation = currentResults.get(position);
                    
                    TextView text1 = view.findViewById(android.R.id.text1);
                    TextView text2 = view.findViewById(android.R.id.text2);
                    
                    text1.setText(regulation.getPosition());
                    text2.setText("Regulation: " + regulation.getRegulation() + " | Appointed by: " + regulation.getAppointedBy());
                    
                    return view;
                }
            };
            
            resultsList.setAdapter(adapter);
        }
    }
    
    private void openDetailView(MiningRegulation regulation) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("regulation", regulation.getRegulation());
        intent.putExtra("position", regulation.getPosition());
        intent.putExtra("appointedBy", regulation.getAppointedBy());
        intent.putExtra("legalResponsibility", regulation.getLegalResponsibility());
        startActivity(intent);
    }
}

