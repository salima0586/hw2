package com.example.homework_2;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    ArrayList<Model> list = new ArrayList<>();

    public void setList(ArrayList<Model> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public void addAdapter(Model model){
        this.list.add(model);
        notifyDataSetChanged();
    }
    public void updateItem(Model model, int position){
        this.list.set(position,model);
        notifyDataSetChanged();
//        notifyItemChanged(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context,FormActivity.class);
                intent.putExtra("title", holder.textView.getText());
                intent.putExtra("pos", holder.getAdapterPosition());
                context.startActivity(intent);
            }
        });


//        Зебра
        if (position%2 == 0){
            holder.itemView.setBackgroundColor(Color.parseColor("#FF000000"));
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        }

//        Удаление на долгом нажатии
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                list.remove(position);
                notifyDataSetChanged();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txt_item);
        }

        public void bind(Model model) {
            textView.setText(model.getTitle());
        }
    }
}

