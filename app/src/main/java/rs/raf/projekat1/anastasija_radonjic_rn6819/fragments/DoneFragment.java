package rs.raf.projekat1.anastasija_radonjic_rn6819.fragments;

import android.content.Intent;
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
import rs.raf.projekat1.anastasija_radonjic_rn6819.recycler.diff.adapter.DoneAdapter;
import rs.raf.projekat1.anastasija_radonjic_rn6819.recycler.diff.adapter.EnhancmentAdapter;
import rs.raf.projekat1.anastasija_radonjic_rn6819.viewmodels.MainViewModel;

public class DoneFragment extends Fragment {

    //View components
    private EditText searchDone;
    private RecyclerView recyclerView;

    private MainViewModel mainViewModel;
    private DoneAdapter doneAdapter;

    public DoneFragment() {
        super(R.layout.fragment_done);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        init(view);
    }

    private void init(View view) {
        initView(view);
        initRecycler(view);
        initObservers();
        initListeners();
    }

    private void initListeners() {
        searchDone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mainViewModel.filterTicketsInDone(editable.toString());
            }
        });
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.DoneFragmentListRv);
        searchDone = view.findViewById(R.id.inputDoneEt);
    }

    private void initRecycler(View view) {
        doneAdapter = new DoneAdapter(new EnhancmentDiffItemCallback(), enhancment -> {
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
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(doneAdapter);
    }


    private void initObservers() {
        mainViewModel.getInDone().observe(requireActivity(), enhancments -> {
            doneAdapter.submitList(enhancments);
        });
    }
}
