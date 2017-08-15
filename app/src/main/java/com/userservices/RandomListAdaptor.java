package com.userservices;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.R.attr.x;
import static android.content.ContentValues.TAG;

/**
 * Created by gallusawa on 8/14/17.
 */

public class RandomListAdaptor extends RecyclerView.Adapter<RandomListAdaptor.ViewHolder> {

   Context context;
    List<RandomNum> ramdomList = new ArrayList<>();

    public RandomListAdaptor(List<RandomNum> ramdomList) {
        this.ramdomList = ramdomList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView randomN;

        public ViewHolder(View itemView) {
            super(itemView);

            randomN = (TextView) itemView.findViewById(R.id.textView2);

        }


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.random_list_item, parent, false);
        return new ViewHolder(view);
    }
    private int lastPosition = -1;
    @Override

    public void onBindViewHolder(ViewHolder holder, int position) {


        Log.d(TAG, "onBindViewHolder: ");
        if(position > lastPosition){
            //Animation animation = AnimationUtils
        }

        Log.d(TAG, "onBindViewHolder: ");
        final RandomNum randoms = ramdomList.get(position);
        holder.randomN.setText(""+randoms.getRandom());

    }

    public int getItemCount() {
        return ramdomList.size();
    }


}
