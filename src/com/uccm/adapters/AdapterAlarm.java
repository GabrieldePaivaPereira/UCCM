package com.uccm.adapters;
import java.sql.Date;
import java.util.List;

import com.uccm.Principal;
import com.uccm.R;
import com.uccm.R.id;
import com.uccm.alarme.AlarmeNotifica;
import com.uccm.dao.UCCMDAO;
import com.uccm.vo.UCCMVO;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class AdapterAlarm extends BaseAdapter {

	private int i = 0;
	private Context ctx;
	private List<UCCMVO> lista;
	
	public AdapterAlarm(Context ctx, List<UCCMVO> lista){
		this.ctx = ctx;
		this.lista = lista;
	}
	
	@Override
	public int getCount() {		
		return lista.size();
	}

	@Override
	public Object getItem(int position) {
		return lista.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		final UCCMVO vo = (UCCMVO)getItem(position);
		
		LayoutInflater layout = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = layout.inflate(R.layout.alarme, null);
		
		TextView txtNome = (TextView) v.findViewById(R.id.txtNome1);
		txtNome.setText(vo.getNome());
		
		TextView txtQTD = (TextView) v.findViewById(R.id.txtQTD);
		txtQTD.setText("Resta(m) "+vo.getQuantidade()+" unidade(s)");
		
		final Button cbTomei = (Button)v.findViewById(id.cbTomei);
		
		cbTomei.setOnClickListener(new OnClickListener() {
			
		
			public void onClick(View v) {				
				vo.setQuantidade(vo.getQuantidade()-1);
//				int hr = d.getHours(), mn = d.getMinutes();
//				int h[] = vo.getHora(hr,mn, vo.getIntervalo_hora(), vo.getIntervalo_minuto());
				int h[] = vo.getHora(vo.getHora_hora(),vo.getHora_minuto(), vo.getIntervalo_hora(), vo.getIntervalo_minuto());
				vo.setHora_hora(h[0]);
				vo.setHora_minuto(h[1]);
				UCCMDAO dao = new UCCMDAO(ctx);
				if(vo.getQuantidade()>0){
				dao.update(vo);
				}else{
					dao.delete(vo);
				}
				cbTomei.setBackgroundColor(Color.GREEN);
				
			}
		});
		
		
		return v;
		
	}

}