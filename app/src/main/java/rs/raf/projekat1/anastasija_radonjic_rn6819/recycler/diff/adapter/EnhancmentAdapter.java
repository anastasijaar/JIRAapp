package rs.raf.projekat1.anastasija_radonjic_rn6819.recycler.diff.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.function.Consumer;

import rs.raf.projekat1.anastasija_radonjic_rn6819.R;

import rs.raf.projekat1.anastasija_radonjic_rn6819.models.Ticket;
import timber.log.Timber;

public class EnhancmentAdapter extends ListAdapter<Ticket, EnhancmentAdapter.ViewHolder> {

    public final Consumer<Ticket> onEnhancmentClicked;
    public final Consumer<Ticket> onMoveTicket;
    public final Consumer<Ticket> onDeleteTicket;

    public EnhancmentAdapter(@NonNull DiffUtil.ItemCallback<Ticket> diffCallback, Consumer<Ticket> onEnhancmentClicked,
                             Consumer<Ticket> onMoveTicket,
                             Consumer<Ticket> onDeleteTicket) {
        super(diffCallback);
        this.onEnhancmentClicked = onEnhancmentClicked;
        this.onMoveTicket = onMoveTicket;
        this.onDeleteTicket = onDeleteTicket;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.enhancment_list_item, parent, false);
        return new ViewHolder(view, parent.getContext(), position -> {
            Ticket ticket = getItem(position);
            onEnhancmentClicked.accept(ticket);
        },position ->{
            Ticket ticket = getItem(position);
            onMoveTicket.accept(ticket);
        }, position ->{
            Ticket ticket = getItem(position);
            onDeleteTicket.accept(ticket);
        });
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //hvatamo ticket koji treba trenutno da se prikaze
        Ticket ticket = getItem(position);
        holder.bind(ticket);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final Context context;

        public ViewHolder(@NonNull View itemView, Context context,
                          Consumer<Integer> onItemClicked,
                          Consumer<Integer> onMoveTicket,
                          Consumer<Integer> onDeleteTicket) {
            super(itemView);
            this.context = context;

            itemView.setOnClickListener(v -> {
                if (getBindingAdapterPosition() != RecyclerView.NO_POSITION)
                    onItemClicked.accept(getBindingAdapterPosition());
            });

            itemView.findViewById(R.id.arrowRightIv).setOnClickListener(v -> {
                if (getBindingAdapterPosition() != RecyclerView.NO_POSITION)
                    onMoveTicket.accept(getBindingAdapterPosition());
            });

            itemView.findViewById(R.id.deletePictureIv).setOnClickListener(v -> {
                if (getBindingAdapterPosition() != RecyclerView.NO_POSITION)
                    onDeleteTicket.accept(getBindingAdapterPosition());
            });
        }

        public void bind(Ticket ticket){
            SharedPreferences preferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
            Boolean isAdmin = preferences.getBoolean("isAdmin", false);
//            Boolean isInProgres = preferences.getBoolean("isInProgress", false);
//            Timber.e("IsInprogress je:" + isInProgres);
            ((TextView)itemView.findViewById(R.id.titleTv)).setText(ticket.getTitle());
            ((TextView)itemView.findViewById(R.id.descriptionTv)).setText(ticket.getDescription());

            Drawable enc = ContextCompat.getDrawable(context, R.drawable.ic_enhancment);
            Drawable bug = ContextCompat.getDrawable(context, R.drawable.ic_bug);
            if(((TextView) itemView.findViewById(R.id.titleTv)).getText().toString().startsWith("En")){
                ticket.setImage(enc);
                ((ImageView)itemView.findViewById(R.id.rocketPictureIv)).setImageDrawable(enc);
            }
            else if(((TextView) itemView.findViewById(R.id.titleTv)).getText().toString().startsWith("Bu")){
                ticket.setImage(enc);
                ((ImageView)itemView.findViewById(R.id.rocketPictureIv)).setImageDrawable(bug);
            }
            if(!isAdmin) {
                ((ImageView) itemView.findViewById(R.id.deletePictureIv)).setVisibility(View.GONE);
            }
//            if(!isInProgres && !isAdmin){
//                ((ImageView) itemView.findViewById(R.id.deletePictureIv)).setVisibility(View.VISIBLE);
//                ((ImageView) itemView.findViewById(R.id.arrowLeftIv)).setVisibility(View.GONE);
//
//            }else {
//                ((ImageView) itemView.findViewById(R.id.deletePictureIv)).setVisibility(View.GONE);
//                ((ImageView) itemView.findViewById(R.id.arrowLeftIv)).setVisibility(View.VISIBLE);
//            }
        }

    }
}
