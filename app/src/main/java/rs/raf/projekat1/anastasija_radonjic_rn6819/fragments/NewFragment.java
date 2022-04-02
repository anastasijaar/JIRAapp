package rs.raf.projekat1.anastasija_radonjic_rn6819.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import rs.raf.projekat1.anastasija_radonjic_rn6819.R;

public class NewFragment extends Fragment {

    //View comps
    private TextView textView;
    private Spinner spinnerType;
    private Spinner spinnerPriority;
    private EditText estInputText;
    private EditText ticketTitleInputText;
    private EditText ticketDescInputText;
    private Button addBtn;

    public NewFragment() {
        super(R.layout.fragment_new);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        initView(view);
        initListeners(view);
    }

    private void initView(View view) {
        textView = (TextView) view.findViewById(R.id.NewFragmentText);
        spinnerType = (Spinner) view.findViewById(R.id.NewFragmentTypeSpinner);
        spinnerPriority = (Spinner) view.findViewById(R.id.NewFragmentPrioritySpinner);
        estInputText = (EditText) view.findViewById(R.id.NewFragmentEstInput);
        ticketTitleInputText = (EditText) view.findViewById(R.id.NewFragmentTicketTitleInput);
        ticketDescInputText = (EditText) view.findViewById(R.id.NewFragmentTicketDescInput);
        addBtn = (Button) view.findViewById(R.id.NewFragmentButton);
    }

    private void initListeners(View view) {
    }
}
