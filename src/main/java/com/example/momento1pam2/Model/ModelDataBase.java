package com.example.momento1pam2.Model;

public class ModelDataBase {
    private int _id;
    private String _titulo;
    private String _descripcion;

    public ModelDataBase() {
    }

    public ModelDataBase(String _titulo, String _descripcion) {
        this._titulo = _titulo;
        this._descripcion = _descripcion;
    }

    public ModelDataBase(int _id, String _titulo, String _descripcion) {
        this._id = _id;
        this._titulo = _titulo;
        this._descripcion = _descripcion;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_titulo() {
        return _titulo;
    }

    public void set_titulo(String _titulo) {
        this._titulo = _titulo;
    }

    public String get_descripcion() {
        return _descripcion;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

}
