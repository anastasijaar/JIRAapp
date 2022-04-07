package rs.raf.projekat1.anastasija_radonjic_rn6819.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import rs.raf.projekat1.anastasija_radonjic_rn6819.R;
import timber.log.Timber;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TicketsInfoActivity extends AppCompatActivity {

    //View components
    private ImageView imageView;
    private TextView textView;
    private TextView typeText;
    private TextView typeInputText;
    private TextView priorityText;
    private TextView priorityInputText;
    private TextView estimationText;
    private TextView estimationInputText;
    private TextView loggedTimeText;
    private Button loggedTimeButton;
    private TextView ticketDescText;
    private TextView ticketDescInputText;
    private Button editBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets_info);
        init();
    }

    private void init() {
        initView();
        initListeners();
    }

    private void initView() {
        imageView = findViewById(R.id.TicketsInfoActivityIv);
        textView = findViewById(R.id.TicketsInfoActivityText);
        typeText = findViewById(R.id.TicketsInfoActivityType);
        typeInputText = findViewById(R.id.TicketsInfoActivityTypeInput);
        priorityText = findViewById(R.id.TicketsInfoActivityPriority);
        priorityInputText = findViewById(R.id.TicketsInfoActivityPriorityInput);
        estimationText = findViewById(R.id.TicketsInfoActivityEstimation);
        estimationInputText = findViewById(R.id.TicketsInfoActivityEstimationInput);
        loggedTimeText = findViewById(R.id.TicketsInfoActivityLoggedTime);
        loggedTimeButton = findViewById(R.id.TicketsInfoActivityLoggedTimeBtn);
        ticketDescText = findViewById(R.id.TicketsInfoActivityDesc);
        ticketDescInputText = findViewById(R.id.TicketsInfoActivityDescInput);
        editBtn = findViewById(R.id.TicketsInfoActivityButton);
    }

    private int loggedTime = 0;

    private void initListeners() {

        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        typeInputText.setText(type);
        if(type.startsWith("En")) {
            imageView.setImageDrawable(getDrawable(R.drawable.ic_enhancment));
        }
        else if(type.startsWith("Bu")){
            imageView.setImageDrawable(getDrawable(R.drawable.ic_bug));
        }
        String priority = intent.getStringExtra("priority");
        priorityInputText.setText(priority);
        String estimation = intent.getStringExtra("estimation");
//        Timber.e("Estimation je: " + estimation);
        estimationInputText.setText(String.valueOf(estimation));
        String description = intent.getStringExtra("description");
        ticketDescInputText.setText(description);
        Timber.e("prosledjen desc u intentu je: "+ticketDescInputText.getText().toString());
        String title = intent.getStringExtra("title");
        textView.setText(title);


        loggedTimeButton.setText(String.valueOf(loggedTime));

        loggedTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loggedTime ++;
                loggedTimeButton.setText(loggedTime+"");
            }
        });

        loggedTimeButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                int curr = Integer.parseInt(String.valueOf(loggedTime));
                curr --;
                loggedTimeButton.setText(curr+"");
                Timber.e("long click***********");
                return true;
            }
        });

        SharedPreferences preferences = getSharedPreferences(this.getPackageName(), Context.MODE_PRIVATE);
        Boolean isAdmin = preferences.getBoolean("isAdmin", false);

        if(!isAdmin) {
            findViewById(R.id.TicketsInfoActivityButton).setVisibility(View.GONE);
        }

        editBtn.setOnClickListener(v->{
            Intent intent2 = new Intent(TicketsInfoActivity.this, TicketsEditInfoActivity.class);
            intent2.putExtra("type", typeInputText.getText());
            intent2.putExtra("priority", priorityInputText.getText());
            intent2.putExtra("estimation", String.valueOf(estimationInputText.getText()));
            intent2.putExtra("title", textView.getText());
            intent2.putExtra("description", ticketDescInputText.getText().toString());
            Timber.e("u intent2 stavljam: "+ ticketDescInputText.getText());
            startActivity(intent2);
        });
    }
}