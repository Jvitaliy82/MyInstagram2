package ru.jdeveloperapps.myinstagram2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustRVAdapter extends RecyclerView.Adapter<CustRVAdapter.CardViewHolder> {

    private List<CustModelCard> mListCard;
    private OnLongClickListener onLongClickListener;

    public CustRVAdapter(List<CustModelCard> mListCard) {
        this.mListCard = mListCard;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, null);
        CardViewHolder cardViewHolder = new CardViewHolder(v);
        return cardViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CustModelCard currentModel = mListCard.get(position);
        holder.mTitle.setText(currentModel.getTitle());
        holder.mDescription.setText(currentModel.getDescr());
        holder.imgView.setImageResource(currentModel.getImgId());
    }

    @Override
    public int getItemCount() {
        return mListCard.size();
    }

    public void SetOnLongClickListener(OnLongClickListener itemClickListener) {
        this.onLongClickListener = itemClickListener;
    }

    public interface OnLongClickListener {
        void onLongClick(View view, int position);
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public ImageView imgView;
        public TextView mTitle;
        public TextView mDescription;


        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            cardView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (onLongClickListener != null) {
                        onLongClickListener.onLongClick(v, getAdapterPosition());
                    }
                    return true;
                }
            });
            imgView = itemView.findViewById(R.id.main_image);
            mTitle = itemView.findViewById(R.id.titleProduct);
            mDescription = itemView.findViewById(R.id.descriptionProduct);
        }
    }

}
