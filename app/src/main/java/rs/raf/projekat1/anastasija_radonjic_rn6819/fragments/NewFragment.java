package rs.raf.projekat1.anastasija_radonjic_rn6819.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import rs.raf.projekat1.anastasija_radonjic_rn6819.R;
import rs.raf.projekat1.anastasija_radonjic_rn6819.viewmodels.MainViewModel;
import timber.log.Timber;

public class NewFragment extends Fragment {

    //View comps
    private TextView textView;
    private Spinner spinnerType;
    private Spinner spinnerPriority;
    private EditText estInputText;
    private EditText ticketTitleInputText;
    private EditText ticketDescInputText;
    private Button addBtn;

    private MainViewModel mainViewModel;

    public NewFragment() {
        super(R.layout.fragment_new);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        init(view);
    }

    private void init(View view) {
        initView(view);
        initTypeSpinner(view);
        initPrioritySpinner(view);
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


    private void initTypeSpinner(View view) {
        spinnerType = view.findViewById(R.id.NewFragmentTypeSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.spinnerTypeItems, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(adapter);
    }


    private void initPrioritySpinner(View view) {
        spinnerPriority = view.findViewById(R.id.NewFragmentPrioritySpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.spinnerPriorityItems, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPriority.setAdapter(adapter);
    }

    private void initListeners(View view) {
        addBtn.setOnClickListener(v -> {
            boolean flag = !(estInputText.getText().toString().isEmpty()
                    || ticketTitleInputText.getText().toString().isEmpty()
                    || ticketDescInputText.getText().toString().isEmpty());

            int spinnerPos = spinnerType.getSelectedItemPosition();

            if(flag){
                if (spinnerPos == 1){
                        mainViewModel.addTicket("Enhancment",String.valueOf(spinnerPriority.getSelectedItem()), Integer.parseInt(estInputText.getText().toString()),
                                ticketTitleInputText.getText().toString(),
                                ticketDescInputText.getText().toString());

                    clearFields();
                    Toast.makeText(getContext(), "Ticket has been added successfully", Toast.LENGTH_SHORT).show();
                }else if(spinnerPos == 2){
                        mainViewModel.addTicket("Bug",String.valueOf(spinnerPriority.getSelectedItem()), Integer.parseInt(estInputText.getText().toString()),
                                ticketTitleInputText.getText().toString(),
                                ticketDescInputText.getText().toString());
                    clearFields();
                    Toast.makeText(getContext(), "Bug has been added successfully", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void clearFields() {
        estInputText.getText().clear();
        ticketTitleInputText.getText().clear();
        ticketDescInputText.getText().clear();
    }

}
