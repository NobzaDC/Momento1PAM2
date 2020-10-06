package com.example.momento1pam2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.momento1pam2.Model.ModelDataBase;
import com.example.momento1pam2.R;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<ModelDataBase> {

    private List<ModelDataBase> lst;
    private Context context;
    private int resource;

    public ListViewAdapter(@NonNull Context context, int resource, @NonNull List<ModelDataBase> objects) {
        super(context, resource, objects);

        this.lst = objects;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.list_view_model, null);

        ModelDataBase model = lst.get(position);

        TextView titulo = view.findViewById(R.id.txt_titulo_list_view);
        titulo.setText(model.get_titulo());

        TextView descripcion = view.findViewById(R.id.txt_descripcion_list_view);
        descripcion.setText(model.get_descripcion());

        return view;
    }
}
