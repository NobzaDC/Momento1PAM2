package com.example.momento1pam2.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.momento1pam2.Adapter.ListViewAdapter;
import com.example.momento1pam2.Adapter.NotaAdapter;
import com.example.momento1pam2.Model.ModelDataBase;
import com.example.momento1pam2.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    ListView ListViewNotas;
    ListViewAdapter adapter;
    private List<ModelDataBase> list = new ArrayList<>();
    private NotaAdapter bdadapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        ListViewNotas = root.findViewById(R.id.ListViewNotas);

        bdadapter = new NotaAdapter(getContext());

        bdadapter.openWrite();

        list = bdadapter.selectNotasById();

        bdadapter.close();

        adapter = new ListViewAdapter(getContext(), R.layout.list_view_model, list);

        ListViewNotas.setAdapter(adapter);

        return root;
    }
}