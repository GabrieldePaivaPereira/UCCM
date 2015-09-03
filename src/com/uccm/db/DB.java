package com.uccm.db;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DB extends SQLiteOpenHelper {
	private static String dbName = "Medicamentos.db";
	private static String sql = "CREATE TABLE [medicamentos] (" +
			" [id] INTEGER PRIMARY KEY AUTOINCREMENT," +
			" [nome] [VARCHAR(20)] NOT NULL," +
			" [quantidade] INTEGER NOT NULL," +
			" [Intervalo_Hora] INTEGER NOT NULL," +
			" [Intervalo_Minuto] INTEGER NOT NULL," +
			" [Hora_Hora] INTEGER NOT NULL," +
			" [Hora_Minuto] INTEGER NOT NULL);";
	
	private static int version = 1;	
	public DB(Context ctx){
		super(ctx, dbName, null, version);		 
	}	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(sql);		
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {	
	}
}