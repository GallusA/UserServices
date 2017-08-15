package com.userservices;

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

    @Override

    public void onBindViewHolder(ViewHolder holder, int position) {


        Log.d(TAG, "onBindViewHolder: ");
        final int p = position;
        final RandomNum randomNum = ramdomList.get(position);
        holder.randomN.setText(randomNum.getRandomNum());


        holder.itemView.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                ArrayList<Integer> z = new ArrayList<>();

                Random random = new Random();


                for (int x = 0; x < 5; x++) {
                z.add(random.nextInt(100) + 1);

                }
                Intent intent = new Intent();
                intent.setClass(v.getContext(), MainActivity.class);
                intent.putExtra("Data1", z);
                v.getContext().startActivity(intent);

            }
    });
    }

    public int getItemCount() {
        return ramdomList.size();
    }


}
