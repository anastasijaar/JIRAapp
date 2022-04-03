package rs.raf.projekat1.anastasija_radonjic_rn6819.recycler.diff;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import rs.raf.projekat1.anastasija_radonjic_rn6819.models.Enhancment;

public class EnhancmentDiffItemCallback extends DiffUtil.ItemCallback<Enhancment> {

    @Override
    public boolean areItemsTheSame(@NonNull Enhancment oldItem, @NonNull Enhancment newItem) {
        return oldItem.getId().equals(newItem.getId());
    }

    @Override
    public boolean areContentsTheSame(@NonNull Enhancment oldItem, @NonNull Enhancment newItem) {
        return oldItem.getTitle().equals(newItem.getTitle())
                && oldItem.getEstimation() == newItem.getEstimation()
                && oldItem.getDescription().equals(newItem.getDescription());
    }
}
