package rs.raf.projekat1.anastasija_radonjic_rn6819.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import rs.raf.projekat1.anastasija_radonjic_rn6819.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences =getSharedPreferences(getPackageName(), MODE_PRIVATE);
        Boolean isLoged = sharedPreferences.getBoolean("isLoged", false);

        if(isLoged == true){
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(SplashActivity.this, LogInActivity.class);
            startActivity(intent);
        }

        finish();
    }
}