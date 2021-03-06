package com.example.android.vilniusguide;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Greta Grigutė on 2018-04-14.
 */

public class ObjectAdapter extends RecyclerView.Adapter<ObjectAdapter.MyViewHolder> {
    private List<Object> mObjectList;

    public ObjectAdapter(List<Object> objectList) {
        this.mObjectList = objectList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Object object = mObjectList.get(position);
        holder.name.setText(object.getName());
        holder.place.setText(object.getPlace());
        holder.picture.setImageResource(object.getPictureList());

        if (object.getFavorite() == Utils.FAVORITE_STATE_FALSE) {
            holder.favorite.setImageResource(R.drawable.ic_favorite_border_black_48dp);
        } else holder.favorite.setImageResource(R.drawable.ic_favorite_black_48dp);
    }

    @Override
    public int getItemCount() {
        return mObjectList.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView place;
        public ImageView picture;
        public ImageView favorite;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.list_item_name);
            place = view.findViewById(R.id.list_item_place);
            picture = view.findViewById(R.id.list_picture);
            favorite = view.findViewById(R.id.favourites);
        }
    }
}
