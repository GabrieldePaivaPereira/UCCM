package com.uccm;

import com.uccm.formulario.Nome;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Principal extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.principal);
		
		
		Button btnCadastro = (Button) findViewById(R.id.btnCadastrar);
		Button btnEstoque = (Button) findViewById(R.id.btnEstoque);
		Button btnSobre = (Button) findViewById(R.id.btnSobre);
		Button btnSair = (Button) findViewById(R.id.btnSair);

		btnCadastro.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				
				int Cod[] = {0,30,12,0,4,0,0};
				startActivity(new Intent(getBaseContext(), Nome.class).putExtra("Cod", Cod).putExtra("Nome", ""));

			}
		});
		
		btnEstoque.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(getBaseContext(), Estoque.class));
			}
		});
		btnSobre.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(getBaseContext(), Sobre.class));
				
			}
		});
		btnSair.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.principal, menu);
		return true;
	}

}
