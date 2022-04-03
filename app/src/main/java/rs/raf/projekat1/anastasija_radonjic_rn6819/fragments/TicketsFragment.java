package rs.raf.projekat1.anastasija_radonjic_rn6819.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import rs.raf.projekat1.anastasija_radonjic_rn6819.R;

public class TicketsFragment extends Fragment {

    public TicketsFragment() {
        super(R.layout.fragment_tickets);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        initInnerFragment();
    }

    private void initInnerFragment() {
        //making inner fragment for list of tickets
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.TicketsFcv, new TicketsListFragment());
        transaction.commit();
    }
}
