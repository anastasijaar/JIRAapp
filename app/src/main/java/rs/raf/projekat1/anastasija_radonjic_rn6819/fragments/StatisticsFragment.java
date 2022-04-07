package rs.raf.projekat1.anastasija_radonjic_rn6819.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import rs.raf.projekat1.anastasija_radonjic_rn6819.R;
import rs.raf.projekat1.anastasija_radonjic_rn6819.viewmodels.MainViewModel;

public class StatisticsFragment extends Fragment {

    //View comps
    private TextView textView;
    private TextView toDoText;
    private TextView toDoInputText;
    private TextView toDoEnhancementsText;
    private TextView toDoEnhancementsInputText;
    private TextView toDoBugsText;
    private TextView toDoBugsInputText;
    private TextView inProgressText;
    private TextView inProgressInputText;
    private TextView inProgressEnhancementsText;
    private TextView inProgressEnhancementsInputText;
    private TextView inProgressBugsText;
    private TextView inProgressBugsInputText;
    private TextView doneText;
    private TextView doneInputText;
    private TextView doneEnhancementsText;
    private TextView doneEnhancementsInputText;
    private TextView doneBugsText;
    private TextView doneBugsInputText;

    private MainViewModel mainViewModel;

    public StatisticsFragment() {
        super(R.layout.fragment_statistics);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        init(view);
    }

    private void init(View view) {
        initView(view);
        initListeners(view);
    }

    private void initView(View view) {
        textView = (TextView) view.findViewById(R.id.StatisticsFragmentText);
        toDoText = (TextView) view.findViewById(R.id.StatisticsFragmentToDoText);
        toDoInputText = (TextView) view.findViewById(R.id.StatisticsFragmentToDoInput);
        toDoEnhancementsText = (TextView) view.findViewById(R.id.StatisticsFragmentToDoEnhancementsText);
        toDoEnhancementsInputText = (TextView) view.findViewById(R.id.StatisticsFragmentToDoEnhancementsInput);
        toDoBugsText = (TextView) view.findViewById(R.id.StatisticsFragmentToDoBugsText);
        toDoBugsInputText = (TextView) view.findViewById(R.id.StatisticsFragmentToDoBugsInput);
        inProgressText = (TextView) view.findViewById(R.id.StatisticsFragmentInProgressText);
        inProgressInputText = (TextView) view.findViewById(R.id.StatisticsFragmentInProgressInput);
        inProgressEnhancementsText = (TextView) view.findViewById(R.id.StatisticsFragmentInProgressEnhancementsText);
        inProgressEnhancementsInputText = (TextView) view.findViewById(R.id.StatisticsFragmentInProgressEnhancementsInput);
        inProgressBugsText = (TextView) view.findViewById(R.id.StatisticsFragmentInProgressBugsText);
        inProgressBugsInputText = (TextView) view.findViewById(R.id.StatisticsFragmentInProgressBugsInput);
        doneText = (TextView) view.findViewById(R.id.StatisticsFragmentDoneText);
        doneInputText = (TextView) view.findViewById(R.id.StatisticsFragmentDoneInput);
        doneEnhancementsText = (TextView) view.findViewById(R.id.StatisticsFragmentDoneEnhancementsText);
        doneEnhancementsInputText = (TextView) view.findViewById(R.id.StatisticsFragmentDoneEnhancementsInput);
        doneBugsText = (TextView) view.findViewById(R.id.StatisticsFragmentDoneBugsText);
        doneBugsInputText = (TextView) view.findViewById(R.id.StatisticsFragmentDoneBugsInput);

        //to-do lista
        mainViewModel.getEnhancment().observe(getViewLifecycleOwner(), v->{
            toDoEnhancementsInputText.setText(String.valueOf(mainViewModel.getEnhancmentSum()));
        });

        mainViewModel.getEnhancment().observe(getViewLifecycleOwner(), v->{
            toDoBugsInputText.setText(String.valueOf(mainViewModel.getBugSum()));
        });

        mainViewModel.getEnhancment().observe(getViewLifecycleOwner(), v->{
            toDoInputText.setText(String.valueOf(mainViewModel.getBugSum()+mainViewModel.getEnhancmentSum()));
        });

        //inprogress lista
        mainViewModel.getInProgress().observe(getViewLifecycleOwner(), v->{
            inProgressEnhancementsInputText.setText(String.valueOf(mainViewModel.getInProgressEnhancmentSum()));
        });

        mainViewModel.getInProgress().observe(getViewLifecycleOwner(), v->{
            inProgressBugsInputText.setText(String.valueOf(mainViewModel.getInProgressBugSum()));
        });

        mainViewModel.getInProgress().observe(getViewLifecycleOwner(), v->{
            inProgressInputText.setText(String.valueOf(mainViewModel.getInProgressBugSum()+mainViewModel.getInProgressEnhancmentSum()));
        });

        //done lista
        mainViewModel.getInDone().observe(getViewLifecycleOwner(), v->{
            doneEnhancementsInputText.setText(String.valueOf(mainViewModel.getDoneEnhancmentSum()));
        });

        mainViewModel.getInDone().observe(getViewLifecycleOwner(), v->{
            doneBugsInputText.setText(String.valueOf(mainViewModel.getDoneBugSum()));
        });

        mainViewModel.getInDone().observe(getViewLifecycleOwner(), v->{
            doneInputText.setText(String.valueOf(mainViewModel.getDoneBugSum()+mainViewModel.getDoneEnhancmentSum()));
        });
    }

    private void initListeners(View view) {
    }

}
