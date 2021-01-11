package com.saurabh.covidcount;

import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CardHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView mLocation;
    public TextView mTotal;
    public TextView mIndian;
    public TextView mForeign;
    public TextView mRecovered;
    public TextView mDeath;
    public TextView mActive;
    public PieChart mPieChart;

    public CardHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener( this);

        mLocation = itemView.findViewById(R.id.location);
        mTotal = itemView.findViewById(R.id.total);
        mIndian = itemView.findViewById(R.id.indian);
        mForeign = itemView.findViewById(R.id.foreign);
        mRecovered = itemView.findViewById(R.id.recovered);
        mDeath = itemView.findViewById(R.id.death);
        mActive = itemView.findViewById(R.id.active);
        mPieChart = itemView.findViewById(R.id.pieChart);

    }

    @Override
    public void onClick(View v) {
    }
}
