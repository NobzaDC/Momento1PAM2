package com.example.momento1pam2.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.momento1pam2.DataBase.SQLiteHelper;
import com.example.momento1pam2.Model.ModelDataBase;

import java.util.ArrayList;


public class NotaAdapter {

    private final String NOMBRE_DB = "agenda.db";
    private final int VERSION = 1;
    public static final String NOMBRE_TABLA = "notas";

    public static final String SCRIPT_NUEVA_TABLA = "CREATE TABLE " + NOMBRE_TABLA +
            "(" +
            "id integer primary key autoincrement, " +
            "titulo text, " +
            "descripcion text" +
            ");";

    private static SQLiteDatabase database;
    private static SQLiteHelper helper;
    private final Context context;
    private ModelDataBase model;
    private ArrayList<ModelDataBase> list;


    public NotaAdapter(Context context) {
        this.context = context;
        helper = new SQLiteHelper(context, NOMBRE_DB, null, VERSION);
    }

    public NotaAdapter(Context context, ArrayList<ModelDataBase> list) {
        this.context = context;
        this.list = list;
    }

    public void openRead() {
        database = helper.getReadableDatabase();
    }

    public void openWrite() {
        database = helper.getWritableDatabase();
    }

    public void close() {
        database.close();
    }

    public long insert(ModelDataBase model) {
        ContentValues values = new ContentValues();
        values.put("titulo", model.get_titulo());
        values.put("descripcion", model.get_descripcion());

        return database.insert(NOMBRE_TABLA, null, values);
    }

    public ArrayList<ModelDataBase> selectNotasById() {

        Cursor cursor = database.query(NOMBRE_TABLA, null, null, null, null, null, null);
        if (cursor.getCount() < 1) {
            return null;
        } else {
            list = new ArrayList<>();
            cursor.moveToFirst();
            do {
                model = new ModelDataBase();

                model.set_titulo(cursor.getString(cursor.getColumnIndex("titulo")));
                model.set_descripcion(cursor.getString(cursor.getColumnIndex("descripcion")));

                list.add(model);
            } while (cursor.moveToNext());
            return list;
        }
    }
}
