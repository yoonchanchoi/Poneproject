package com.example.poneproject.DataModel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poneproject.R;

import java.util.ArrayList;

public class Numberlist_Adapter extends RecyclerView.Adapter<Numberlist_Adapter.CustomViewHolder> {

    private ArrayList<Numberlist_Data> arrayList;

    public Numberlist_Adapter(ArrayList<Numberlist_Data> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Numberlist_Adapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Numberlist_Adapter.CustomViewHolder holder, int position) {
        holder.iv_profile.setImageResource(arrayList.get(position).getIv_profile());
        holder.numberlist_name.setText(arrayList.get(position).getNumberlist_name());

        holder.itemView.setTag(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cuName = holder.numberlist_name.getText().toString();
                Toast.makeText(view.getContext(), "cuName", Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                remove(holder.getAdapterPosition());
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0)

    }
    public void remove(int position){
        try{
            arrayList.remove(position);
            notifyItemRemoved(position);
        }catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder{
        protected ImageView iv_profile;
        protected TextView numberlist_name;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile = (ImageView) itemView.findViewById(R.id.iv_profile);
            this.numberlist_name = (TextView) itemView.findViewById(R.id.numberlist_name);
        }
    }
}
