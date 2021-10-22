package com.rijalkun.drivethruclient;

import android.annotation.SuppressLint;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.rijalkun.drivethruclient.model.MenuModel;
import com.rijalkun.drivethruclient.model.MinumanModel;

import java.io.InputStream;
import java.util.List;

public class MinumanAdapter extends RecyclerView.Adapter<MinumanAdapter.ViewHolder> {
    private final List<MenuModel> listMinuman;

    public MinumanAdapter(List<MenuModel> listMinuman) {
        this.listMinuman = listMinuman;
    }

    @NonNull
    @Override
    public MinumanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemmenu_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MinumanAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.txtUtama.setText(listMinuman.get(position).getNama_menu());
        holder.txtSub.setText("Rp. " + String.valueOf(listMinuman.get(position).getHarga()));
        final InputStream imgMenu = listMinuman.get(position).getGambarMenu();
        holder.imgMenu.setImageBitmap(BitmapFactory.decodeStream(imgMenu));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if (listMinuman.get(position).getSelected()) {
                    holder.cardUtama.setStrokeColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.border_menu_clicked));
                    holder.cardUtama.setStrokeWidth(4);
                    holder.cardUtama.setCardElevation(20f);

                } else {
                    holder.cardUtama.setStrokeColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.border_menu));
                    holder.cardUtama.setStrokeWidth(2);
                    holder.cardUtama.setCardElevation(0f);
                }
                listMinuman.get(position).setSelected(!listMinuman.get(position).getSelected());
//                Toast.makeText(view.getContext(), String.valueOf(listMakanan.get(position).getSelected()), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMinuman.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMenu;
        private TextView txtUtama, txtSub;
        private MaterialCardView cardUtama;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMenu = itemView.findViewById(R.id.imgMenu);
            txtUtama = itemView.findViewById(R.id.txtUtama);
            txtSub = itemView.findViewById(R.id.txtSub);
            cardUtama = itemView.findViewById(R.id.cardItem);
        }
    }
}
