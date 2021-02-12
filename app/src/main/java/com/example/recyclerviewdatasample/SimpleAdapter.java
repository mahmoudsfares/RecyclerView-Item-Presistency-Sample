package com.example.recyclerviewdatasample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder> {

    private final Context mContext;
    // list of fetched things
    private List<String> things;

    private boolean[] checkStatus;

    private final ItemClickListener mItemClickListener;

    public SimpleAdapter(Context context, ItemClickListener itemClickListener) {
        mContext = context;
        mItemClickListener = itemClickListener;
    }

    public void setAdapterData(List<String> things) {
        this.things = things;
        checkStatus = new boolean[things.size()];
        notifyDataSetChanged();
    }

    // create list item by inflating its layout
    @NonNull
    @Override
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        return new SimpleViewHolder(view);
    }

    // bind list item views to the correct resources
    @Override
    public void onBindViewHolder(@NonNull SimpleViewHolder holder, int position) {
        if (things != null) {
            if (things.size() > 0) {
                String currentThing = things.get(position);
                holder.thing.setText(currentThing);
            }
        }
        holder.thing.setOnCheckedChangeListener((buttonView, isChecked) -> checkStatus[position] = isChecked);
        holder.thing.setChecked(checkStatus[position]);
    }

    @Override
    public int getItemCount() {
        if (things == null) return 0;
        return things.size();
    }

    // implemented by the activity to handle onItemClicks
    public interface ItemClickListener {
        void onItemClickListener(int clickedPosition);
    }


    // define list item views and sets its onClick behaviour
    public class SimpleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Switch thing;

        public SimpleViewHolder(@NonNull View itemView) {
            super(itemView);
            thing = itemView.findViewById(R.id.switchkey);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mItemClickListener.onItemClickListener(getAdapterPosition());
        }
    }
}

