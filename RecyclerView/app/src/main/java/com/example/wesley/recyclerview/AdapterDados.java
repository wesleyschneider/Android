package com.example.wesley.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterDados extends RecyclerView.Adapter<AdapterDados.ViewHolderDados> {

    ArrayList<String> listDados;

    public AdapterDados(ArrayList<String> listDados){
        this.listDados = listDados;
    }

    @Override
    public AdapterDados.ViewHolderDados onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);
        return new ViewHolderDados(view);
    }

    @Override
    public void onBindViewHolder(AdapterDados.ViewHolderDados holder, int position) {
        holder.asignarDados(listDados.get(position));
    }

    @Override
    public int getItemCount() {
        return listDados.size();
    }

    public class ViewHolderDados extends RecyclerView.ViewHolder{

        TextView dado;

        public ViewHolderDados(View itemView) {
            super(itemView);
            dado = itemView.findViewById(R.id.idDado);
        }

        public void asignarDados(String dados) {
            dado.setText(dados);
        }
    }

}
