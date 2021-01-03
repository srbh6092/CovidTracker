package com.saurabh.covidcount;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CardAdapter extends RecyclerView.Adapter<CardHolder> {

    private List<CardObject> cardList;
    private Context context;

    public CardAdapter(List<CardObject> cardList, Context context) {
        this.cardList = cardList;
        this.context = context;
    }


    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, null, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutView.setLayoutParams(lp);
        CardHolder rcv = new CardHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position) {
        holder.mLocation.setText(cardList.get(position).getLocation());//putting location on the item holder
        holder.mTotal.setText(Integer.toString(cardList.get(position).getTotal()));//putting total on the item holder
        holder.mIndian.setText(Integer.toString(cardList.get(position).getIndian()));//putting Indian cases on the item holder
        holder.mForeign.setText(Integer.toString(cardList.get(position).getForeign()));//putting Foreign cases on the item holder
        holder.mRecovered.setText(Integer.toString(cardList.get(position).getRecovered()));//putting recovered cases on the item holder
        holder.mDeath.setText(Integer.toString(cardList.get(position).getDeaths()));//putting death cases on the item holder
        holder.mActive.setText(Integer.toString(cardList.get(position).getActive()));//putting active cases on the item holder
    }

    @Override
    public int getItemCount() {
        return cardList.size();//returning the size of adapter
    }
}
