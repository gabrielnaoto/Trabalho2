package com.example.tonied.futmanddm.modelo.dao.sqlite;

import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import com.example.tonied.futmanddm.modelo.dao.core.PatrocinadorDAO;
import com.example.tonied.futmanddm.modelo.entidade.Patrocinador;

public class SQLPatrocinadorDAO implements PatrocinadorDAO {

    private SQLiteDatabase db;

    public SQLPatrocinadorDAO(SQLiteDatabase db) {
        this.db = db;
    }

    @Override
    public void inserir(Patrocinador o) {
        Object[] valores = new Object[3];
        valores[0] = o.getNome();
        valores[1] = o.getEstrelas();
        valores[2] = o.getValor();
        db.execSQL("insert into patrocinador(nome, estrelas, valor) values(?,?,?)", valores);
    }

    @Override
    public void editar(Patrocinador o) {
        Object[] valores = new Object[3];
        valores[0] = o.getNome();
        valores[1] = o.getEstrelas();
        valores[2] = o.getValor();
        db.execSQL(" update patrocinador set nome = ?, estrelas = ?, valor = ?, where patrocinadorid = ?", valores);
    }

    @Override
    public Patrocinador pesquisar(int o) throws CursorIndexOutOfBoundsException{
        String[] id = {Integer.toString(o)};
        Cursor cursor = db.rawQuery("select * from patrocinador where patrocinadorid = ?", id);
        int index_patrocinadorid = cursor.getColumnIndex("patrocinadorid");
        int index_nome = cursor.getColumnIndex("nome");
        int index_estrelas = cursor.getColumnIndex("estrelas");
        int index_valor = cursor.getColumnIndex("valor");
        cursor.moveToFirst();
        Patrocinador p = new Patrocinador();
        p.setPatrocinadorid(cursor.getInt(index_patrocinadorid));
        p.setNome(cursor.getString(index_nome));
        p.setEstrelas(cursor.getInt(index_estrelas));
        p.setValor(cursor.getDouble(index_valor));
        return p;
    }

    @Override
    public List<Patrocinador> listar() {
        Cursor cursor = db.rawQuery("select * from patrocinador", null);
        int index_patrocinadorid = cursor.getColumnIndex("patrocinadorid");
        int index_nome = cursor.getColumnIndex("nome");
        int index_estrelas = cursor.getColumnIndex("estrelas");
        int index_valor = cursor.getColumnIndex("valor");
        cursor.moveToFirst();
        List<Patrocinador> patrocinadores = new ArrayList<>();
        while(!cursor.isAfterLast()){
            Patrocinador p = new Patrocinador();
            p.setPatrocinadorid(cursor.getInt(index_patrocinadorid));
            p.setNome(cursor.getString(index_nome));
            p.setEstrelas(cursor.getInt(index_estrelas));
            p.setValor(cursor.getDouble(index_valor));
            patrocinadores.add(p);
        }
        return patrocinadores;
    }

    @Override
    public void remover(int id) {
        Object[] valores = {id};
        db.execSQL("delete from patrocinador where patrocinadorid = ?", valores);
    }
}
