package rs.raf.projekat1.anastasija_radonjic_rn6819.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import rs.raf.projekat1.anastasija_radonjic_rn6819.R;
import rs.raf.projekat1.anastasija_radonjic_rn6819.viewpager.PagerAdapterTab;

public class TicketsListFragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    public TicketsListFragment() {
        super(R.layout.fragment_ticketslist);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        initView(view);
        initTabs(view);
    }

    private void initView(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.TicketsListFcvViewPager);
        tabLayout = (TabLayout) view.findViewById(R.id.TicketsListFcvTabLayout);
    }

    private void initTabs(View view) {
        viewPager.setAdapter(new PagerAdapterTab(getActivity().getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }
}
