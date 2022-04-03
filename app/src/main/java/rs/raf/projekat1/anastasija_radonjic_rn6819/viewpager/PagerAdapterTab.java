package rs.raf.projekat1.anastasija_radonjic_rn6819.viewpager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import rs.raf.projekat1.anastasija_radonjic_rn6819.fragments.DoneFragment;
import rs.raf.projekat1.anastasija_radonjic_rn6819.fragments.InProgressFragment;
import rs.raf.projekat1.anastasija_radonjic_rn6819.fragments.ToDoFragment;

public class PagerAdapterTab extends FragmentPagerAdapter {

    private final int FRAGMENT_COUNT = 3;
    public static final int FRAGMENT_1 = 0;
    public static final int FRAGMENT_2 = 1;
    public static final int FRAGMENT_3 = 2;

    public PagerAdapterTab(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case FRAGMENT_1:
                fragment = new ToDoFragment();
                break;
            case FRAGMENT_2:
                fragment = new InProgressFragment();
                break;
            default:
                fragment = new DoneFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case FRAGMENT_1:
                return "ToDo";
            case FRAGMENT_2:
                return "In progress";
            default:
                return "Done";
        }
    }
}