package rs.raf.projekat1.anastasija_radonjic_rn6819.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import rs.raf.projekat1.anastasija_radonjic_rn6819.R;

public class LogInActivity extends AppCompatActivity {

    private static final String SIFRA_USER = "123456";
    private static final String SIFRA_ADMIN = "654321";
    private static boolean isAdmin = false;

    //View comps
    private ImageView imageView;
    private TextView textView;
    private EditText editNameText;
    private EditText editEmailText;
    private EditText editPasswordText;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        init();
    }

    private void init() {
        initView();
        initListeners();
    }

    private void initView() {
        imageView = findViewById(R.id.LogInActivityImageView);
        textView = findViewById(R.id.LogInActivityText);
        editNameText = findViewById(R.id.LogInActivityEnterName);
        editEmailText = findViewById(R.id.LogInActivityEnterEmail);
        editPasswordText = findViewById(R.id.LogInActivityEnterPass);
        loginBtn = findViewById(R.id.LogInActivityButton);
    }

    private void initListeners() {
        loginBtn.setOnClickListener(view -> {
            String nameInput = editNameText.getText().toString().trim();
            String emailInput = editEmailText.getText().toString().trim();
            String passwordInput = editPasswordText.getText().toString().trim();

            boolean flag = !(nameInput.isEmpty()
                    || emailInput.isEmpty()
                    || passwordInput.isEmpty());

            if (flag) {
                if (passwordInput.length() < 5) {
                    Toast.makeText(this, "Password must be 5 or more characters !", Toast.LENGTH_LONG).show();
                    return;
                }
                if(nameInput.startsWith("admin")){
                    if(!passwordInput.equals(SIFRA_ADMIN)){
                        Toast.makeText(this, "Incorrect password", Toast.LENGTH_SHORT).show();
                        return;
                    }else{
                        isAdmin = true;
                    }
                }
                else {
                    if (!passwordInput.equals(SIFRA_USER)) {
                        Toast.makeText(this, "Incorrect password", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                if(nameInput.startsWith("admin")){
                    isAdmin  =true;
                }
                else{
                    isAdmin = false;
                }

                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("name", nameInput)
                        .putExtra("email", emailInput)
                        .putExtra("password", passwordInput)
                        .putExtra("isAdmin", isAdmin);


                SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);
                sharedPreferences
                        .edit()
                        .putString("name", nameInput)
                        .putString("email", emailInput)
                        .putString("password", passwordInput)
                        .putBoolean("isAdmin", isAdmin)
                        .apply();

                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Please fill in all fields !", Toast.LENGTH_LONG).show();
            }

        });
    }

}