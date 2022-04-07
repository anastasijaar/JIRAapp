package rs.raf.projekat1.anastasija_radonjic_rn6819.recycler.diff;

import androidx.recyclerview.widget.DiffUtil;

import rs.raf.projekat1.anastasija_radonjic_rn6819.models.Ticket;

public class EnhancmentDiffItemCallback extends DiffUtil.ItemCallback<Ticket> {

    @Override
    public boolean areItemsTheSame(Ticket oldItem, Ticket newItem) {
        return oldItem.getId().equals(newItem.getId());
    }

    @Override
    public boolean areContentsTheSame(Ticket oldItem, Ticket newItem) {
        return oldItem.getTitle().equals(newItem.getTitle())
                && oldItem.getEstimation() == newItem.getEstimation()
                && oldItem.getDescription().equals(newItem.getDescription());
    }
}
