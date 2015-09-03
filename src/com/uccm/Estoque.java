package com.uccm;

import com.uccm.adapters.UCCMAdapter;
import com.uccm.dao.UCCMDAO;
import com.uccm.vo.UCCMVO;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;


public class Estoque extends ListActivity{	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
}
	@Override
	 protected void onListItemClick(ListView l, View v, int position, long id){
		UCCMVO vo = (UCCMVO)l.getAdapter().getItem(position);
		startActivity(new Intent(getBaseContext(), Editar.class).putExtra("cod", vo.getId()));
	}
	@Override
	public void onResume(){
		super.onResume();
		UCCMDAO dao = new UCCMDAO(getBaseContext());		
		setListAdapter(new UCCMAdapter(getBaseContext(), dao.getAll()));
	}
}
