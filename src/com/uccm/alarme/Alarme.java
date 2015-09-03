package com.uccm.alarme;

import com.uccm.adapters.AdapterAlarm;
import com.uccm.dao.UCCMDAO;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;


public class Alarme extends ListActivity{
	
	private int h = 0;
	private int m = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent i = getIntent();
		h = i.getIntExtra("Hora", 0);
		m = i.getIntExtra("Minuto", 1);
}
	
	
	@Override
	public void onResume(){
		super.onResume();		
		UCCMDAO dao = new UCCMDAO(getBaseContext());
		setListAdapter(new AdapterAlarm(getBaseContext(), dao.getByHora(h,m)));
	}
}
