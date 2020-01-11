package com.example.fmcominterface_rv_multiview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    Context context;
    ArrayList<MyChidModel> listData;
    MyListener listener;

    public MyAdapter(Context context, ArrayList<MyChidModel> listData, MyListener listener) {
        this.context = context;
        this.listData = listData;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item, parent, false);
                return new VH1(view);

            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item2, parent, false);
                return new VH2(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final int pos = position%2;
        switch (pos){
            case 0:
                ((VH1)holder).tv_country1.setText(listData.get(position).getCountryNames());
                ((VH1)holder).tv_rate1.setText(""+listData.get(position).getRates());
                ((VH1)holder).imageFlag1.setImageResource(listData.get(position).getImageFlags());

                break;

            case 1:
                ((VH2)holder).tv_country2.setText(listData.get(position).getCountryNames());
                ((VH2)holder).tv_rate2.setText(""+listData.get(position).getRates());
                ((VH2)holder).imageFlag2.setImageResource(listData.get(position).getImageFlags());

                break;
        }
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class VH1 extends RecyclerView.ViewHolder{
        TextView tv_rate1,tv_country1;
        ImageView imageFlag1 ;
        CardView card_viewid1;

        public VH1(@NonNull View itemView) {
            super(itemView);

            tv_rate1 = itemView.findViewById(R.id.tv_rate1);
            tv_country1 = itemView.findViewById(R.id.tv_country1);
            imageFlag1 = itemView.findViewById(R.id.imageFlag1);
            card_viewid1 = itemView.findViewById(R.id.card_view1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int clickItem = (int) view.getTag();
                    //Toast.makeText(view.getContext(),"item is "+clickItem,Toast.LENGTH_SHORT).show();
                    listener.myCallback(listData.get(clickItem));
                    Log.d("check", listData.get(clickItem).getCountryNames());
                }
            });
        }
    }

    public class VH2 extends RecyclerView.ViewHolder{
        TextView tv_rate2,tv_country2;
        ImageView imageFlag2 ;
        CardView card_viewid2;

        public VH2(@NonNull View itemView) {
            super(itemView);

            tv_rate2 = itemView.findViewById(R.id.tv_rate2);
            tv_country2 = itemView.findViewById(R.id.tv_country2);
            imageFlag2 = itemView.findViewById(R.id.imageFlag2);
            card_viewid2 = itemView.findViewById(R.id.card_view2);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int clickItem = (int) view.getTag();
                    //Toast.makeText(view.getContext(),"item is "+clickItem,Toast.LENGTH_SHORT).show();
                    listener.myCallback(listData.get(clickItem));
                    Log.d("check", listData.get(clickItem).getCountryNames());
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position%2;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if(context instanceof MyListener){
            listener = (MyListener) context;
        }
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        listener = null;
    }
}


