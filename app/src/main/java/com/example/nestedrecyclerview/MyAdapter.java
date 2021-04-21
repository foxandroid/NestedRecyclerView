package com.example.nestedrecyclerview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Activity activity;
    ArrayList<ParentItem> parentItemArrayList;
    ArrayList<ChildItem> childItemArrayList;

    public MyAdapter(Activity activity, ArrayList<ParentItem> parentItemArrayList, ArrayList<ChildItem> childItemArrayList) {
        this.activity = activity;
        this.parentItemArrayList = parentItemArrayList;
        this.childItemArrayList = childItemArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //holder.tvName.setText(arrayList.get(position));

        ParentItem parentItem = parentItemArrayList.get(position);

        holder.tvOrderId.setText(parentItem.orderId);
        holder.tvqty.setText("Quantity: " + parentItem.quantity);
        holder.tvprice.setText("Rs." + parentItem.price);
        holder.ivParent.setImageResource(parentItem.imageId);



        MemberAdp adapterMember = new MemberAdp(childItemArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        holder.nested_rv.setLayoutManager(linearLayoutManager);
        holder.nested_rv.setAdapter(adapterMember);

    }

    @Override
    public int getItemCount() {

        return parentItemArrayList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView tvOrderId, tvqty, tvprice;
        CircleImageView ivParent;
        RecyclerView nested_rv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvOrderId = itemView.findViewById(R.id.tvOrderId);
            tvqty = itemView.findViewById(R.id.tvqtyparent);
            tvprice = itemView.findViewById(R.id.tvpriceparent);
            ivParent = itemView.findViewById(R.id.ivparent);
            nested_rv = itemView.findViewById(R.id.nested_rv);

        }
    }

}
