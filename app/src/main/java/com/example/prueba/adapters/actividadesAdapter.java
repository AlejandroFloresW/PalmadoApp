package com.example.prueba.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.example.prueba.adapters.viewholders.RecycleViewHolder;
import  com.example.prueba.R;
import com.example.prueba.helpers.events.ItemTapListener;
import com.example.prueba.models.actividadesModel;

import com.squareup.picasso.*;


public class actividadesAdapter extends RecyclerView.Adapter<RecycleViewHolder>{

    @NonNull
    private List<actividadesModel> mModelList;
    @Nullable
    private final ItemTapListener mTapListener;

    public actividadesAdapter(@NonNull List<actividadesModel> modelList, @Nullable ItemTapListener tapListener) {
        mModelList = modelList;
        mTapListener = tapListener;
    }

    public void updateList(List<actividadesModel> newList) {
        mModelList = newList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.list_elements, parent, false);
        RecycleViewHolder viewHolder = new RecycleViewHolder(itemView, mTapListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder holder, int position) {
        actividadesModel currentModel = mModelList.get(position);
        holder.recycle_title.setText(currentModel.getNombre());
        holder.recycle_desc.setText(currentModel.getDescripcion());
        holder.recycle_pres.setText(currentModel.getPresupuesto());
        Picasso.get().load(currentModel.getImgUrl()).into(holder.recycle_img);
    }

    @Override
    public int getItemCount() {
        return mModelList.size();
    }
}
