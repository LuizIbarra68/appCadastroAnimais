package com.ibarra.applistacadastroanimaisluizibarra.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ibarra.applistacadastroanimaisluizibarra.model.Categoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    public static void inserir(Context contexto, Categoria categoria){
        Conexao conn = new Conexao(contexto);
        SQLiteDatabase banco = conn.getWritableDatabase();

        banco.execSQL("INSERT INTO categorias (nome) VALUES " +
                " ( '" + categoria.getNome() + "' )  ");
}
    public static List<Categoria> getCategorias(Context contexto){
        List<Categoria> listaDeCategorias = new ArrayList<>();
        Conexao conn = new Conexao(contexto);
        SQLiteDatabase banco = conn.getReadableDatabase();

        Cursor tabela = banco.rawQuery
                ("SELECT * FROM categorias", null);
        if ( tabela.getCount() > 0){

            tabela.moveToFirst();

            do {
                Categoria cat = new Categoria();
                cat.setId( tabela.getInt(0) );
                cat.setNome( tabela.getString(1) );

                listaDeCategorias.add(cat);

            }while (tabela.moveToNext());
        }

        return listaDeCategorias;
    }




}

