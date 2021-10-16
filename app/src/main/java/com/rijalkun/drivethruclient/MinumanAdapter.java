package com.rijalkun.drivethruclient;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rijalkun.drivethruclient.model.MinumanModel;

import java.io.InputStream;
import java.util.List;

public class MinumanAdapter extends RecyclerView.Adapter<MinumanAdapter.ViewHolder> {
    private final List<MinumanModel> listMinuman;

    public MinumanAdapter(List<MinumanModel> listMinuman) {
        this.listMinuman = listMinuman;
    }

    @NonNull
    @Override
    public MinumanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemmenu_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MinumanAdapter.ViewHolder holder, int position) {
        holder.txtUtama.setText(listMinuman.get(position).getNama_minuman());
        holder.txtSub.setText("Rp. " + String.valueOf(listMinuman.get(position).getHarga()));
        final InputStream imgMenu = listMinuman.get(position).getGambarMenu();
        holder.imgMenu.setImageBitmap(BitmapFactory.decodeStream(imgMenu));
    }

    @Override
    public int getItemCount() {
        return listMinuman.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMenu;
        private TextView txtUtama, txtSub;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMenu = itemView.findViewById(R.id.imgMenu);
            txtUtama = itemView.findViewById(R.id.txtUtama);
            txtSub = itemView.findViewById(R.id.txtSub);
        }
    }
}
