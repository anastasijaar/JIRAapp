package rs.raf.projekat1.anastasija_radonjic_rn6819.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import rs.raf.projekat1.anastasija_radonjic_rn6819.R;
import rs.raf.projekat1.anastasija_radonjic_rn6819.recycler.diff.EnhancmentDiffItemCallback;
import rs.raf.projekat1.anastasija_radonjic_rn6819.recycler.diff.adapter.EnhancmentAdapter;
import rs.raf.projekat1.anastasija_radonjic_rn6819.viewmodels.MainViewModel;

public class InProgressFragment extends Fragment {

    //View components
    private EditText searchInProgress;
    private RecyclerView recyclerView;

    private MainViewModel mainViewModel;
    private EnhancmentAdapter enhancmentAdapter;

    public InProgressFragment() {
        super(R.layout.fragment_inprogress);
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
        searchInProgress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mainViewModel.filterTickets(editable.toString());
            }
        });
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.InProgressFragmentListRv);
        searchInProgress = view.findViewById(R.id.inputInProgressEt);
    }

    private void initRecycler(View view) {
        enhancmentAdapter = new EnhancmentAdapter(new EnhancmentDiffItemCallback()); //enhancment -> {
////            Toast.makeText(view.getContext(), income.getId(), Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(getActivity(), TicketsInfoActivity.class);
//            intent.putExtra("type", enhancment.getType());
//            intent.putExtra("priority", enhancment.getPriority());
//            intent.putExtra("estimation", enhancment.getEstimation());
//            intent.putExtra("title", enhancment.getTitle());
//            intent.putExtra("description", enhancment.getDescription());
//            startActivity(intent);
//            return null;
//    });
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(enhancmentAdapter);
    }


    private void initObservers() {
        mainViewModel.getEnhancment().observe(requireActivity(), enhancments -> {
            enhancmentAdapter.submitList(enhancments);
        });
    }
}
