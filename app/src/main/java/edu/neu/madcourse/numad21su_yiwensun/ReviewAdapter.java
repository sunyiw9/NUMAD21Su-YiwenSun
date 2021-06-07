package edu.neu.madcourse.numad21su_yiwensun;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.Holder> {

    List<String> listItem;

    public ReviewAdapter(ArrayList<String> list){
        this.listItem = list;
    }

    @NonNull
    @Override
    public ReviewAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new Holder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ReviewAdapter.Holder holder, int position) {
        holder.textView.setText(listItem.get(position));

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(holder.textView.getText().toString()));
                //startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        TextView textView;

        public Holder(View view) {
            super(view);
            textView = view.findViewById(R.id.textNameID);
        }
    }

}
