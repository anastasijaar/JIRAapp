package rs.raf.projekat1.anastasija_radonjic_rn6819.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import rs.raf.projekat1.anastasija_radonjic_rn6819.R;
import rs.raf.projekat1.anastasija_radonjic_rn6819.viewmodels.SplashViewModel;

public class MainActivity extends AppCompatActivity {

    private SplashViewModel splashViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashViewModel = new ViewModelProvider(this).get(SplashViewModel.class);
        // Handle the splash screen transition.
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);
        splashScreen.setKeepOnScreenCondition(() -> {
            Boolean value = splashViewModel.isLoading().getValue();
            if (value == null) return false;
            return value;
        });
        setContentView(R.layout.activity_main);

    }
}