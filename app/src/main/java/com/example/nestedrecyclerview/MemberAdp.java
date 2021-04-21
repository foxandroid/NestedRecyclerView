package com.example.nestedrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MemberAdp extends RecyclerView.Adapter<MemberAdp.ViewHolder> {

    ArrayList<ChildItem> childarrayList;

    public MemberAdp(ArrayList<ChildItem> childarrayList) {

        this.childarrayList = childarrayList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ChildItem childItem = childarrayList.get(position);

        holder.tvItemName.setText(childItem.itemName);
        holder.tvqtyChild.setText("Quantity: "+childItem.itemQty);
        holder.tvpriceChild.setText("Rs."+childItem.itemPrice);
        holder.ivChild.setImageResource(childItem.imageID);
    }

    @Override
    public int getItemCount() {

        return childarrayList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvItemName, tvqtyChild, tvpriceChild;
        CircleImageView ivChild;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvItemName = itemView.findViewById(R.id.tvItemName);
            tvqtyChild = itemView.findViewById(R.id.tvqtychild);
            tvpriceChild = itemView.findViewById(R.id.tvpricechild);
            ivChild = itemView.findViewById(R.id.ivChild);
        }
    }

}
