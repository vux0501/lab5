package com.example.donut_listview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class DonutAdapter extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<Donut> donutList;
    private int posSelect = -1;

    public DonutAdapter(Context context, int idLayout, List<Donut> donutList) {
        this.context = context;
        this.idLayout = idLayout;
        this.donutList = donutList;
    }

    @Override
    public int getCount() {
        if (donutList.size() != 0 && !donutList.isEmpty())
            return donutList.size();
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null)
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(idLayout, viewGroup, false);

        ImageView donutImg = view.findViewById(R.id.donutImg);
        TextView donutName = view.findViewById(R.id.donutName);
        TextView donutDesc = view.findViewById(R.id.donutDesc);
        TextView donutPrice = view.findViewById(R.id.donutPrice);
        ImageButton plusBtn = view.findViewById(R.id.plusBtn);

        Donut donut = donutList.get(i);

        if (donut != null && !donutList.isEmpty()){
            donutImg.setImageResource(donut.getDonutImgId());
            donutName.setText(donut.getDonutName());
            donutDesc.setText(donut.getDonutDesc());
            donutPrice.setText("$ " + donut.getDonutPrice());
        }

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        context,
                        DonutDetail.class
                );

                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("selectedDonut", donut);

                context.startActivity(intent);
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        context,
                        DonutDetail.class
                );

                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("selectedDonut", donut);

                context.startActivity(intent);
            }
        });

        return view;
    }
}
