package rs.raf.projekat1.anastasija_radonjic_rn6819.recycler.diff.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import rs.raf.projekat1.anastasija_radonjic_rn6819.R;

import rs.raf.projekat1.anastasija_radonjic_rn6819.models.Enhancment;

public class EnhancmentAdapter extends ListAdapter<Enhancment, EnhancmentAdapter.ViewHolder> {


    public EnhancmentAdapter(@NonNull DiffUtil.ItemCallback<Enhancment> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.enhancment_list_item, parent, false);
        return new ViewHolder(view, parent.getContext());//, position -> {
            //Enhancment enhancment = getItem(position);
            //onFinansijaClicked.apply(finansija);
            //return null;

        //},position ->{
            //Enhancment enhancment = getItem(position);
            //onFinansijaDelete.apply(finansija);
            //return null;
        //}, position ->{
            //Enhancment enhancment = getItem(position);
            //onFinansijaEdit.apply(finansija);
            //return null;
       // });
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //hvatamo ticket koji treba trenutno da se prikaze
        Enhancment enhancment = getItem(position);
        holder.bind(enhancment);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final Context context;

        public ViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
        }

        public void bind(Enhancment enhancment){
            ((TextView)itemView.findViewById(R.id.titleTv)).setText(enhancment.getTitle());
            ((TextView)itemView.findViewById(R.id.descriptionTv)).setText(enhancment.getDescription());
        }

    }
}
