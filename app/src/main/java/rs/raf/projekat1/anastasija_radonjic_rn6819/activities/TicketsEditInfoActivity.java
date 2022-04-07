package rs.raf.projekat1.anastasija_radonjic_rn6819.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import rs.raf.projekat1.anastasija_radonjic_rn6819.R;
import timber.log.Timber;

public class TicketsEditInfoActivity extends AppCompatActivity {

    //View comps
    private TextView textView;
    private Spinner spinnerEditType;
    private Spinner spinnerEditPriority;
    private EditText estEditInputText;
    private EditText ticketEditTitleInputText;
    private EditText ticketEditDescInputText;
    private Button saveBtn;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets_edit_info);
        sharedPreferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        init();
    }

    private void init() {
        initView();
        initTypeSpinner();
        initPrioritySpinner();
        initListeners();
    }

    private void initView() {
        textView = findViewById(R.id.TicketsEditInfoActivityText);
        spinnerEditType = findViewById(R.id.TicketsEditInfoActivityTypeSpinner);
        spinnerEditPriority = findViewById(R.id.TicketsEditInfoActivityPrioritySpinner);
        estEditInputText = findViewById(R.id.TicketsEditInfoActivityEstInput);
        ticketEditTitleInputText = findViewById(R.id.TicketsEditInfoActivityTicketTitleInput);
        ticketEditDescInputText = findViewById(R.id.TicketsEditInfoActivityTicketDescInput);
        saveBtn = findViewById(R.id.TicketsEditInfoActivityButton);
    }

    private void initTypeSpinner() {
        spinnerEditType = findViewById(R.id.TicketsEditInfoActivityTypeSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinnerTypeItems, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEditType.setAdapter(adapter);
    }


    private void initPrioritySpinner() {
        spinnerEditPriority = findViewById(R.id.TicketsEditInfoActivityPrioritySpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinnerPriorityItems, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEditPriority.setAdapter(adapter);
    }

    private void initListeners() {
        Intent intent = getIntent();
//        String type = intent.getStringExtra("type");
//        intent.putExtra("type",String.valueOf(spinnerEditType.getSelectedItemPosition()));
        Timber.e("tip jeee"+intent.getStringExtra("type"));
        String type = intent.getStringExtra("type");
        if(type.equals("Enhancment")){
            spinnerEditType.setSelection(1);
        }else if(type.equals("Bug")){
            spinnerEditType.setSelection(2);
        }
//        String priority = intent.getStringExtra("priority");
        String priority = intent.getStringExtra("priority");
        if(priority.equals("Highest")){
            spinnerEditPriority.setSelection(1);
        }else if(priority.equals("High")){
            spinnerEditPriority.setSelection(2);
        }else if(priority.equals("Medium")){
            spinnerEditPriority.setSelection(3);
        }else if(priority.equals("Low")){
            spinnerEditPriority.setSelection(4);
        }else if(priority.equals("Lowest")){
            spinnerEditPriority.setSelection(5);
        }
        String estimation = intent.getStringExtra("estimation");
        Timber.e("Estimation je: " + estimation);
        estEditInputText.setText(String.valueOf(estimation));
        String description = intent.getStringExtra("description");
        ticketEditDescInputText.setText(description);
        Timber.e(description+" descriotionnn");
        String title = intent.getStringExtra("title");
        ticketEditTitleInputText.setText(title);

        saveBtn.setOnClickListener(v->{
            intent.putExtra("type", spinnerEditType.getSelectedItemPosition());
            intent.putExtra("priority", spinnerEditPriority.getSelectedItemPosition());
            intent.putExtra("estimation", String.valueOf(estEditInputText.getText()));
            intent.putExtra("title", ticketEditTitleInputText.getText());
            intent.putExtra("description", ticketEditDescInputText.getText().toString());
            Toast.makeText(this, "You have successfully saved the ticket", Toast.LENGTH_SHORT).show();
            finish();
        });

    }

}