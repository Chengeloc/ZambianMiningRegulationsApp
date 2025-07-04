package com.charleschildumba.miningregulations;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AIAssistantActivity extends Activity {
    
    private ScrollView chatScroll;
    private LinearLayout chatContainer;
    private EditText messageInput;
    private Button sendButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_assistant);
        
        initializeViews();
        setupClickListeners();
        
        // Check for context from intent
        String context = getIntent().getStringExtra("context");
        if (context != null && !context.isEmpty()) {
            messageInput.setText(context);
        }
    }
    
    private void initializeViews() {
        chatScroll = findViewById(R.id.chat_scroll);
        chatContainer = findViewById(R.id.chat_container);
        messageInput = findViewById(R.id.message_input);
        sendButton = findViewById(R.id.send_button);
    }
    
    private void setupClickListeners() {
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }
    
    private void sendMessage() {
        String message = messageInput.getText().toString().trim();
        if (message.isEmpty()) {
            Toast.makeText(this, "Please enter a message", Toast.LENGTH_SHORT).show();
            return;
        }
        
        // Add user message to chat
        addMessageToChat(message, true);
        
        // Clear input
        messageInput.setText("");
        
        // Generate AI response
        String aiResponse = generateAIResponse(message);
        addMessageToChat(aiResponse, false);
        
        // Scroll to bottom
        chatScroll.post(new Runnable() {
            @Override
            public void run() {
                chatScroll.fullScroll(View.FOCUS_DOWN);
            }
        });
    }
    
    private void addMessageToChat(String message, boolean isUser) {
        // Create message container
        LinearLayout messageContainer = new LinearLayout(this);
        LinearLayout.LayoutParams containerParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        );
        containerParams.setMargins(0, 0, 0, 16);
        messageContainer.setLayoutParams(containerParams);
        messageContainer.setOrientation(LinearLayout.VERTICAL);
        messageContainer.setPadding(24, 24, 24, 24);
        
        if (isUser) {
            messageContainer.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        } else {
            messageContainer.setBackgroundColor(0xFFE8F5E8);
        }
        
        // Create sender label
        TextView senderLabel = new TextView(this);
        senderLabel.setText(isUser ? "You" : "AI Assistant");
        senderLabel.setTextSize(12);
        senderLabel.setTypeface(null, android.graphics.Typeface.BOLD);
        senderLabel.setTextColor(isUser ? getResources().getColor(R.color.colorOnPrimary) : getResources().getColor(R.color.colorPrimary));
        
        LinearLayout.LayoutParams labelParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        );
        labelParams.setMargins(0, 0, 0, 8);
        senderLabel.setLayoutParams(labelParams);
        
        // Create message text
        TextView messageText = new TextView(this);
        messageText.setText(message);
        messageText.setTextSize(14);
        messageText.setTextColor(isUser ? getResources().getColor(R.color.colorOnPrimary) : getResources().getColor(R.color.textColorPrimary));
        
        // Add views to container
        messageContainer.addView(senderLabel);
        messageContainer.addView(messageText);
        
        // Add to chat
        chatContainer.addView(messageContainer);
    }
    
    private String generateAIResponse(String userMessage) {
        String lowerMessage = userMessage.toLowerCase();
        
        // Simple AI logic based on keywords
        if (lowerMessage.contains("mine manager") || lowerMessage.contains("202")) {
            return "The Mine Manager (M.R. 202(1)) is appointed by the Chief Executive Officer or General Manager (Holder). The Mine Manager is responsible for:\n\n• Control, supervision and direction of the mine\n• Control and supervision of operations involving explosives\n• Observing and enforcing regulations\n• Making appointments of Competent Persons (Assistants)\n\nThe Mine Manager has overall responsibility for mine operations and safety compliance.";
        }
        
        if (lowerMessage.contains("chief executive") || lowerMessage.contains("ceo") || lowerMessage.contains("102")) {
            return "The Chief Executive Officer or General Manager (Holder) under M.R. 102 is appointed by the Board of Directors or Mining Rights Holder. Their key responsibilities include:\n\n• Appointing the Mine Manager (M.R. 202(1))\n• Appointing Holder under Explosives Regulations (E.R.103(1))\n• Providing means to the Mine Manager for enforcing regulations\n• Providing means for enforcing explosives regulations\n\nThis is the top-level position in the mining hierarchy.";
        }
        
        if (lowerMessage.contains("electrical engineer") || lowerMessage.contains("209")) {
            return "The Electrical Engineer/Electrician (M.R. 209(1)) is appointed by the Mine Manager or 204(3) Appointee. Their responsibilities include:\n\n• Supervising proper installation, testing, examination and maintenance of all electrical apparatus\n• Making appointments of subordinate engineers and electricians\n• Observing, supervising and enforcing regulations\n\nNote: Any subordinate engineer with clearly defined appointment has the same responsibility as the electrical engineer in general charge.";
        }
        
        if (lowerMessage.contains("mechanical engineer") || lowerMessage.contains("210")) {
            return "The Mechanical Engineer/Subordinate Engineer (M.R. 210(1)) is appointed by the Mine Manager or 204(3) Appointee. Their responsibilities include:\n\n• Supervising proper installation, testing, examination and maintenance of all mechanical apparatus\n• Making appointments of subordinate engineers or other competent persons\n• Observing, supervising and enforcing regulations\n\nNote: Any subordinate engineer with clearly defined appointment has the same responsibility as the mechanical engineer in general charge.";
        }
        
        if (lowerMessage.contains("shift boss") || lowerMessage.contains("213")) {
            return "The Shift Boss (M.R. 213(1)) is appointed by Mine Captain/Competent Person 207/208(2). Key requirements:\n\n• Required when more than 50 persons are employed in underground or open cast workings\n• Must examine at least once during shift every place where any person is working\n• Must examine at least once each week every place through which any person may pass\n• Responsible for observing and enforcing regulations in their assigned section";
        }
        
        if (lowerMessage.contains("surveyor") || lowerMessage.contains("211")) {
            return "The Chief Surveyor (M.R. 211(a)) is appointed by the Mine Manager. Their responsibilities include:\n\n• Carrying out provisions of Part V under the Mining Regulations\n• Making appointments of subordinates if authorized by appointing authority\n• Observing, supervising and enforcing regulations\n\nNote: There is no explicit provision that automatically authorizes 211(a) appointees to make appointments under the regulations.";
        }
        
        if (lowerMessage.contains("ventilation") || lowerMessage.contains("211")) {
            return "The Ventilation Engineer (M.R. 211(b)) is appointed by the Mine Manager. Their responsibilities include:\n\n• Carrying out provisions of Part IX under the Mining Regulations\n• Making appointments of subordinates if authorized by appointing authority\n• Observing, supervising and enforcing regulations\n\nNote: There is no explicit provision that automatically authorizes 211(b) appointees to make appointments under the regulations.";
        }
        
        if (lowerMessage.contains("appointment") || lowerMessage.contains("who appoints")) {
            return "Here's the appointment hierarchy in Zambian mining:\n\n1. Board of Directors → CEO/General Manager (M.R. 102)\n2. CEO/General Manager → Mine Manager (M.R. 202)\n3. Mine Manager → Assistant Manager/Superintendent (M.R. 204)\n4. Mine Manager → Electrical/Mechanical Engineers (M.R. 209/210)\n5. Mine Manager → Chief Surveyor/Ventilation Engineer (M.R. 211)\n6. Assistant Manager/Superintendent → Mine Captain/Competent Person (M.R. 207/208)\n7. Mine Captain/Competent Person → Shift Boss/Shift Foreman (M.R. 213/214)\n8. Shift Boss/Foreman → Person in Charge (M.R. 215/216)";
        }
        
        if (lowerMessage.contains("responsibility") || lowerMessage.contains("duties")) {
            return "All appointed positions in mining have three core responsibilities:\n\n1. **Control, Supervision & Direction (CSD)** - Managing their assigned area/personnel\n2. **Regulatory Compliance** - Observing and enforcing mining regulations\n3. **Appointment Authority** - Making appointments of subordinates (where authorized)\n\nSpecific responsibilities vary by position level and specialization (electrical, mechanical, surveying, ventilation). Each position must also conduct regular inspections of their assigned areas.";
        }
        
        if (lowerMessage.contains("regulation") || lowerMessage.contains("m.r.")) {
            return "The Mining Regulations (M.R.) define the statutory framework for mining operations in Zambia. Key regulation numbers include:\n\n• M.R. 102 - Holder appointments\n• M.R. 202 - Mine Manager appointments\n• M.R. 204 - Assistant Manager/Superintendent\n• M.R. 207/208 - Mine Captain/Competent Person\n• M.R. 209 - Electrical Engineer\n• M.R. 210 - Mechanical Engineer\n• M.R. 211 - Chief Surveyor/Ventilation Engineer\n• M.R. 213 - Shift Boss\n• M.R. 214 - Shift Foreman\n• M.R. 215/216 - Person in Charge\n\nEach regulation specifies appointment authority, responsibilities, and compliance requirements.";
        }
        
        // Search for relevant regulations
        List<MiningRegulation> searchResults = RegulationData.searchRegulations(userMessage);
        if (!searchResults.isEmpty()) {
            MiningRegulation firstResult = searchResults.get(0);
            return "I found information about: " + firstResult.getPosition() + "\n\n" +
                   "Regulation: M.R. " + firstResult.getRegulation() + "\n" +
                   "Appointed by: " + firstResult.getAppointedBy() + "\n\n" +
                   "Key responsibilities:\n" + firstResult.getLegalResponsibility() + "\n\n" +
                   "Would you like more details about this position or other related roles?";
        }
        
        // Default response
        return "I understand you're asking about mining regulations. I can help you with:\n\n• Specific positions and their responsibilities\n• Appointment hierarchies and who appoints whom\n• Mining regulation numbers and their meanings\n• Legal requirements for different roles\n\nCould you be more specific about what you'd like to know? For example, you could ask:\n• 'What does a Mine Manager do?'\n• 'Who appoints the Electrical Engineer?'\n• 'What is M.R. 213 about?'\n• 'What are the responsibilities of a Shift Boss?'";
    }
}

