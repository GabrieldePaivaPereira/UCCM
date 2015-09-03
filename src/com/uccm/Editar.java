package com.uccm;

import com.uccm.R;
import com.uccm.dao.UCCMDAO;
import com.uccm.formulario.Nome;
import com.uccm.vo.UCCMVO;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Editar extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editar);
		
		Intent intent = getIntent();
		final int id = intent.getIntExtra("cod",0);

		Button btnEditar = (Button)findViewById(R.id.btnEditar);
		Button btnExcluir = (Button)findViewById(R.id.btnExcluir);
		
		btnEditar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				UCCMDAO dao = new UCCMDAO(getBaseContext());
				UCCMVO vo = dao.getById(id);
				int Cod[] = {vo.getId(),vo.getQuantidade(),vo.getHora_hora(),vo.getHora_minuto(),vo.getIntervalo_hora(),vo.getIntervalo_minuto(),1};
				startActivity(new Intent(getBaseContext(),Nome.class).putExtra("Cod", Cod).putExtra("Nome", vo.getNome()));				
			}
		});
		
		btnExcluir.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final UCCMDAO dao = new UCCMDAO(getBaseContext());
				final UCCMVO vo = dao.getById(id);
				android.app.AlertDialog.Builder msg = new android.app.AlertDialog.Builder(Editar.this);
				msg.setMessage("Deseja excluir o medicamento "+vo.getNome()+"?");
				msg.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						if(dao.delete(vo))
							Toast.makeText(getBaseContext(), "Medicamento excluido.", Toast.LENGTH_SHORT).show();
							finish();
					}
				});
				msg.setNegativeButton("Não", null);
				msg.show();
					
				
					}
				});
				
			
		
		
	}
}