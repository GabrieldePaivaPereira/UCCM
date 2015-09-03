package com.uccm.adapters;
import java.util.List;
import com.uccm.R;
import com.uccm.vo.UCCMVO;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class UCCMAdapter extends BaseAdapter {

	private Context ctx;
	private List<UCCMVO> lista;
	
	public UCCMAdapter(Context ctx, List<UCCMVO> lista){
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
		UCCMVO vo = (UCCMVO)getItem(position);
		
		LayoutInflater layout = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = layout.inflate(R.layout.estoque, null);
		
		TextView txtNome = (TextView) v.findViewById(R.id.txtNome1);
		txtNome.setText(vo.getNome());
		
		TextView txtQTD = (TextView) v.findViewById(R.id.txtQTD);
		txtQTD.setText(vo.getQuantidade()+" unidade(s)");
		
		return v;
		
	}

}
