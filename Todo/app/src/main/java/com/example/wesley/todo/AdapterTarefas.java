package com.example.wesley.todo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterTarefas extends RecyclerView.Adapter<AdapterTarefas.ViewHolderTarefas> {

    private ArrayList<String> tarefa;

    public AdapterTarefas(ArrayList<String> tarefas) {
        this.tarefa = tarefas;
    }

    @Override
    public AdapterTarefas.ViewHolderTarefas onCreateViewHolder(ViewGroup parent, int viewType) {

        //Cria um layout inflado
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        //Cria uma view com o layout que criamos "item_list"
        View view = layoutInflater.inflate(R.layout.item_list, null, false);

        //Manda a view para a classe ViewHolderTarefas

        return new ViewHolderTarefas(view);


    }

    @Override
    public void onBindViewHolder(AdapterTarefas.ViewHolderTarefas holder, int position) {
        holder.inserirTarefa(tarefa.get(position));
    }

    @Override
    public int getItemCount() {
        return tarefa.size();
    }

    public class ViewHolderTarefas extends RecyclerView.ViewHolder{

        TextView txtTarefa;

        public ViewHolderTarefas(View itemView) {
            super(itemView);
            txtTarefa = itemView.findViewById(R.id.txtTarefa);
        }

        public void inserirTarefa(String txt) {
            txtTarefa.setText(txt);
        }

    }
}
