package com.example.momento1pam2.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.momento1pam2.Adapter.NotaAdapter;
import com.example.momento1pam2.Model.ModelDataBase;
import com.example.momento1pam2.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    TextView editTextTextMultiLine, txt_set_titulo;
    Button btn_guardar;

    private ModelDataBase model;
    private NotaAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        editTextTextMultiLine = (TextView) root.findViewById(R.id.editTextTextMultiLine);
        txt_set_titulo = (TextView) root.findViewById(R.id.txt_set_titulo);
        btn_guardar = (Button) root.findViewById(R.id.btn_guardar);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new NotaAdapter(getContext());
        model = new ModelDataBase();

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean validar = fnc_validar();
                if (validar) {
                    //codigo de agregar
                    String txt_titulo = txt_set_titulo.getText().toString();
                    String txt_descripcion = editTextTextMultiLine.getText().toString();

                    model = new ModelDataBase(txt_titulo, txt_descripcion);
                    adapter.openWrite();
                    long valorinsert = adapter.insert(model);
                    adapter.close();

                    if (valorinsert > 0) {
                        Toast.makeText(getContext(), "NOTA AGREGADA", Toast.LENGTH_LONG).show();
                        txt_set_titulo.setText("");
                        editTextTextMultiLine.setText("");

                    } else {
                        Toast.makeText(getContext(), "NO SE PUDO AGREGAR LA NOTA", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private boolean fnc_validar() {
        boolean validar = true;
        if (editTextTextMultiLine.getText().equals("")) {
            editTextTextMultiLine.setError("Debe llenar este campo para guardar la nota");
            validar = false;
        }
        if (txt_set_titulo.getText().equals("")) {
            txt_set_titulo.setError("Debe llenar este campo para guardar la nota");
            validar = false;
        }
        return validar;
    }
}