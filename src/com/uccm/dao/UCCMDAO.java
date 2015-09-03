package com.uccm.dao;
import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.uccm.db.DB;
import com.uccm.vo.UCCMVO;

public class UCCMDAO {
	private static String table_name = "medicamentos";
	private Context ctx;

	private static String[] columns = {"id","nome","quantidade","Intervalo_Hora","Intervalo_Minuto","Hora_Hora","Hora_Minuto"};	
	public UCCMDAO(Context ctx){
		this.ctx = ctx;
	}
	public boolean insert(UCCMVO vo){
		SQLiteDatabase db = new DB(ctx).getWritableDatabase();
		ContentValues ctv = new ContentValues();
		ctv.put("nome", vo.getNome());
		ctv.put("quantidade", vo.getQuantidade());
		ctv.put("Intervalo_Hora", vo.getIntervalo_hora());
		ctv.put("Intervalo_Minuto", vo.getIntervalo_minuto());
		ctv.put("Hora_Hora", vo.getHora_hora());
		ctv.put("Hora_Minuto", vo.getHora_minuto());		
		return (db.insert(table_name, null, ctv) > 0);	
	}	
	
	public boolean delete(UCCMVO vo){
		SQLiteDatabase db = new DB(ctx).getWritableDatabase();
		return (db.delete(table_name, "id=?", new String[]{vo.getId().toString()}) > 0);		
	}
	
	public boolean update(UCCMVO vo){
		SQLiteDatabase db = new DB(ctx).getWritableDatabase();
		ContentValues ctv = new ContentValues();
		ctv.put("nome", vo.getNome());
		ctv.put("quantidade", vo.getQuantidade());
		ctv.put("Intervalo_Hora", vo.getIntervalo_hora());
		ctv.put("Intervalo_Minuto", vo.getIntervalo_minuto());
		ctv.put("Hora_Hora", vo.getHora_hora());
		ctv.put("Hora_Minuto", vo.getHora_minuto());		
		return (db.update(table_name, ctv,"id=?", new String[]{vo.getId().toString()}) > 0);
	}	
	public UCCMVO getById(Integer ID){
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();
		Cursor rs = db.query(table_name, columns, "id=?", new String[]{ID.toString()}, null, null, null);		
		UCCMVO vo = null;		
		if(rs.moveToFirst()){
			vo = new UCCMVO();
			vo.setId(rs.getInt(rs.getColumnIndex("id")));
			vo.setNome(rs.getString(rs.getColumnIndex("nome")));
			vo.setQuantidade(rs.getInt(rs.getColumnIndex("quantidade")));
			vo.setIntervalo_hora(rs.getInt(rs.getColumnIndex("Intervalo_Hora")));
			vo.setIntervalo_minuto(rs.getInt(rs.getColumnIndex("Intervalo_Minuto")));
			vo.setHora_hora(rs.getInt(rs.getColumnIndex("Hora_Hora")));
			vo.setHora_minuto(rs.getInt(rs.getColumnIndex("Hora_Minuto")));
		}		
		return vo;		
	}	
	public List<UCCMVO> getAll(){		
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();		
		Cursor rs = db.rawQuery("SELECT * FROM medicamentos", null);	
		List<UCCMVO> lista = new ArrayList<UCCMVO>();		
		while(rs.moveToNext()){
			UCCMVO vo = new UCCMVO();
			vo.setId(rs.getInt(rs.getColumnIndex("id")));
			vo.setNome(rs.getString(rs.getColumnIndex("nome")));
			vo.setQuantidade(rs.getInt(rs.getColumnIndex("quantidade")));
			vo.setIntervalo_hora(rs.getInt(rs.getColumnIndex("Intervalo_Hora")));
			vo.setIntervalo_minuto(rs.getInt(rs.getColumnIndex("Intervalo_Minuto")));
			vo.setHora_hora(rs.getInt(rs.getColumnIndex("Hora_Hora")));
			vo.setHora_minuto(rs.getInt(rs.getColumnIndex("Hora_Minuto")));
			lista.add(vo);
		}	
		return lista;		
	}
	
	public List<UCCMVO> getByHora(Integer h,Integer m){		
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();		
		Cursor rs = db.query(table_name, columns, "Hora_Hora=? and Hora_Minuto=?", new String[]{h.toString(),m.toString()}, null, null, null);	
		List<UCCMVO> lista = new ArrayList<UCCMVO>();		
		while(rs.moveToNext()){
			UCCMVO vo = new UCCMVO();
			vo.setId(rs.getInt(rs.getColumnIndex("id")));
			vo.setNome(rs.getString(rs.getColumnIndex("nome")));
			vo.setQuantidade(rs.getInt(rs.getColumnIndex("quantidade")));
			vo.setIntervalo_hora(rs.getInt(rs.getColumnIndex("Intervalo_Hora")));
			vo.setIntervalo_minuto(rs.getInt(rs.getColumnIndex("Intervalo_Minuto")));
			vo.setHora_hora(rs.getInt(rs.getColumnIndex("Hora_Hora")));
			vo.setHora_minuto(rs.getInt(rs.getColumnIndex("Hora_Minuto")));
			lista.add(vo);
		}	
		return lista;		
	}
	public int contaByHora(Integer h,Integer m){		
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();
		Cursor rs = db.query(table_name, columns, "Hora_Hora=? and Hora_Minuto=?", new String[]{h.toString(),m.toString()}, null, null, null);	
		int i = 0;	
		
		while(rs.moveToNext()){
			i++;
		}	
		return i;		
	}
}
