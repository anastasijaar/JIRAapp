package rs.raf.projekat1.anastasija_radonjic_rn6819.recycler.diff;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import rs.raf.projekat1.anastasija_radonjic_rn6819.models.Bug;

public class BugDiffItemCallback extends DiffUtil.ItemCallback<Bug>{

    @Override
    public boolean areItemsTheSame(@NonNull Bug oldItem, @NonNull Bug newItem) {
        return oldItem.getId().equals(newItem.getId());
    }

    @Override
    public boolean areContentsTheSame(@NonNull Bug oldItem, @NonNull Bug newItem) {
        return oldItem.getTitle().equals(newItem.getTitle())
                && oldItem.getDescription().equals(newItem.getDescription());
    }
}
