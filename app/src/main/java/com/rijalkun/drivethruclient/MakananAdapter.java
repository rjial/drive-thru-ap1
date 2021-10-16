package com.rijalkun.drivethruclient;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rijalkun.drivethruclient.model.MakananModel;

import java.io.InputStream;
import java.util.List;

public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.ViewHolder> {
    private final List<MakananModel> listMakanan;

    public MakananAdapter(List<MakananModel> listMakanan) {
        this.listMakanan = listMakanan;
    }

    @NonNull
    @Override
    public MakananAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemmenu_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MakananAdapter.ViewHolder holder, int position) {
        holder.txtUtama.setText(listMakanan.get(position).getNama_makanan());
        holder.txtSub.setText("Rp. " + String.valueOf(listMakanan.get(position).getHarga()));
        final InputStream imgMenu = listMakanan.get(position).getGambarMenu();
        holder.imgMenu.setImageBitmap(BitmapFactory.decodeStream(imgMenu));
    }

    @Override
    public int getItemCount() {
        return listMakanan.size();
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
