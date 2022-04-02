package rs.raf.projekat1.anastasija_radonjic_rn6819.viewpager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import rs.raf.projekat1.anastasija_radonjic_rn6819.fragments.NewFragment;
import rs.raf.projekat1.anastasija_radonjic_rn6819.fragments.ProfileFragment;
import rs.raf.projekat1.anastasija_radonjic_rn6819.fragments.StatisticsFragment;
import rs.raf.projekat1.anastasija_radonjic_rn6819.fragments.TicketsFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    private final int ITEM_COUNT = 4;
    public static final int FRAGMENT_1 = 0;
    public static final int FRAGMENT_2 = 1;
    public static final int FRAGMENT_3 = 2;
    public static final int FRAGMENT_4 = 3;

    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case FRAGMENT_1: fragment = new StatisticsFragment(); break;
            case FRAGMENT_2: fragment = new NewFragment(); break;
            case FRAGMENT_3: fragment = new TicketsFragment(); break;
            default: fragment = new ProfileFragment(); break;
        }
        return fragment;
    }

    @Override
    public int getCount() {return ITEM_COUNT;}

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case FRAGMENT_1: return "1";
            case FRAGMENT_2: return "2";
            case FRAGMENT_3: return "3";
            default: return "4";
        }
    }
}
