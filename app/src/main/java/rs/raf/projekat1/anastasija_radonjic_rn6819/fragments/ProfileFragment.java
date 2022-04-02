package rs.raf.projekat1.anastasija_radonjic_rn6819.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import rs.raf.projekat1.anastasija_radonjic_rn6819.R;
import rs.raf.projekat1.anastasija_radonjic_rn6819.activities.LogInActivity;

public class ProfileFragment extends Fragment {

    //View comps
    private ImageButton imageButton;
    private TextView nameInputText;
    private TextView emailInputText;
    private Button logOutBtn;

    public ProfileFragment() {
        super(R.layout.fragment_profile);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences preferences = this.getActivity().getSharedPreferences(getActivity().getPackageName(), Context.MODE_PRIVATE);
        nameInputText.setText(preferences.getString("name", ""));
        emailInputText.setText(preferences.getString("email", ""));
    }

    private void init(View view) {
        initView(view);
        initListeners(view);
    }

    private void initView(View view) {
        imageButton = (ImageButton) view.findViewById(R.id.ProfileFragmentImageButton);
        nameInputText = (TextView) view.findViewById(R.id.ProfileFragmentNameInput);
        emailInputText = (TextView) view.findViewById(R.id.ProfileFragmentEmailInput);
        logOutBtn = (Button) view.findViewById(R.id.ProfileFragmentLogOutButton);
    }

    private void initListeners(View view) {

        logOutBtn.setOnClickListener(v->{
            SharedPreferences settings = getContext().getSharedPreferences(getActivity().getPackageName(), Context.MODE_PRIVATE);
            settings.edit().clear().apply();
            Intent intent = new Intent(getActivity(), LogInActivity.class);
            startActivity(intent);
            getActivity().finish();
        });

    }
}
