package rs.raf.projekat1.anastasija_radonjic_rn6819.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import rs.raf.projekat1.anastasija_radonjic_rn6819.R;
import rs.raf.projekat1.anastasija_radonjic_rn6819.activities.TicketsInfoActivity;
import rs.raf.projekat1.anastasija_radonjic_rn6819.recycler.diff.EnhancmentDiffItemCallback;
import rs.raf.projekat1.anastasija_radonjic_rn6819.recycler.diff.adapter.EnhancmentAdapter;
import rs.raf.projekat1.anastasija_radonjic_rn6819.recycler.diff.adapter.InProgressAdapter;
import rs.raf.projekat1.anastasija_radonjic_rn6819.viewmodels.MainViewModel;

public class InProgressFragment extends Fragment {

    //View components
    private EditText searchInProgress;
    private RecyclerView recyclerView;

    private MainViewModel mainViewModel;
    private InProgressAdapter inProgressAdapter;

    public InProgressFragment() {
        super(R.layout.fragment_inprogress);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
//        SharedPreferences preferences = this.getActivity().getSharedPreferences(getActivity().getPackageName(), Context.MODE_PRIVATE);
//        preferences.edit().clear().apply();
//        preferences.
//                edit().
//                putBoolean("isInProgress", true).
//                apply();
        init(view);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void init(View view) {
        initView(view);
        initRecycler(view);
        initObservers();
        initListeners();
    }

    private void initListeners() {
        searchInProgress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mainViewModel.filterTicketsInProgress(editable.toString());
            }
        });
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.InProgressFragmentListRv);
        searchInProgress = view.findViewById(R.id.inputInProgressEt);
    }

    private void initRecycler(View view) {
        inProgressAdapter = new InProgressAdapter(new EnhancmentDiffItemCallback(), enhancment -> {
//            if(enhancment != null && enhancment.getId() != null){
//                Toast.makeText(view.getContext(), enhancment.getId(), Toast.LENGTH_SHORT).show();
//            }
            Intent intent = new Intent(getActivity(), TicketsInfoActivity.class);
            intent.putExtra("drawable", String.valueOf(enhancment.getImage()));
            intent.putExtra("type", enhancment.getType());
            intent.putExtra("priority", enhancment.getPriority());
            intent.putExtra("estimation", String.valueOf(enhancment.getEstimation()));
            intent.putExtra("title", enhancment.getTitle());
            intent.putExtra("description", enhancment.getDescription());
            startActivity(intent);
        }, moveRightTicket ->{
            mainViewModel.moveFromInProgress2InDone(moveRightTicket);
        }, moveLeftTicket ->{
            mainViewModel.moveFromInProgress2InToDo(moveLeftTicket);
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(inProgressAdapter);
    }


    private void initObservers() {
        mainViewModel.getInProgress().observe(requireActivity(), enhancments -> {
            inProgressAdapter.submitList(enhancments);
        });
    }
}
