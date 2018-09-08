package com.example.caragh.project1electrictime;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private ArrayList<Transport> list;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView method, time;

        public MyViewHolder (View view){
            super(view);
            method = view.findViewById(R.id.method);
            time = view.findViewById(R.id.time);
        }
    }
    public Adapter(ArrayList<Transport> transportList){
        this.list = transportList;
    }

    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View txt = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.transport_card, parent, false);
        return new MyViewHolder(txt);
    }

    public void onBindViewHolder(MyViewHolder holder, int position) {
        Transport transport = list.get(position);
        holder.method.setText(transport.getName());
        holder.time.setText(transport.getTime());

        holder.method.setText(list.get(position).getName());
        if (position == 0){
            holder.method.setBackgroundColor(Color.rgb(188, 255, 241));
            holder.method.setHeight(150);
        } else {
            holder.method.setBackgroundColor(Color.WHITE);
        }
    }

    public int getItemCount(){
        return list.size();
    }
}
