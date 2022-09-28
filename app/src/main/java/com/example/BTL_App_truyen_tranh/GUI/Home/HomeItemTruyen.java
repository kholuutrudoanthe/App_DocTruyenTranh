package com.example.BTL_App_truyen_tranh.GUI.Home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.BTL_App_truyen_tranh.R;

import java.util.List;

public class HomeItemTruyen extends RecyclerView.Adapter<HomeItemTruyen.HomeItemTruyenHolder> {
    private List<String> listTruyen;

    public HomeItemTruyen(List<String> listTruyen) {
        this.listTruyen = listTruyen;
    }

    @NonNull
    @Override
    public HomeItemTruyenHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_truyen, parent, false);
        return new HomeItemTruyenHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeItemTruyenHolder holder, int position) {
        String name = listTruyen.get(position);
        holder.textName.setText(name);
    }

    @Override
    public int getItemCount() {
        if (listTruyen != null) {
            return listTruyen.size();
        }
        return 0;
    }

    public class HomeItemTruyenHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewAnh;
        private TextView textName;
        private TextView textChap;

        public HomeItemTruyenHolder(@NonNull View itemView) {
            super(itemView);
            imageViewAnh = itemView.findViewById(R.id.imageViewAnh);
            textName = itemView.findViewById(R.id.textName);
            textChap = itemView.findViewById(R.id.textChap);
        }
    }
}
