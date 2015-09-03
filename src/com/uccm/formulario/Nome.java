package com.uccm.formulario;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.uccm.Principal;
import com.uccm.R;
import com.uccm.R.id;

public class Nome extends Activity {

	int Cod[];
	String Nome;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nome);
		final EditText txtNome = (EditText) findViewById(id.txtNome);
		Button btnProNome = (Button) findViewById(R.id.btnProNome);
		Button btnCancel = (Button) findViewById(R.id.btnCancelNome);

		Intent intent = getIntent();
		final int Cod[] = intent.getIntArrayExtra("Cod");
		Nome = intent.getStringExtra("Nome");

		txtNome.setText(Nome);

		btnProNome.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Nome = txtNome.getText().toString();
				onPause();
				startActivity(new Intent(getBaseContext(), Quantidade.class)
						.putExtra("Cod", Cod).putExtra("Nome", Nome));

			}
		});

		btnCancel.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(getBaseContext(),Principal.class));
				finish();
			}
		});
	}

	protected void onDestroy() {
		super.onDestroy();
	}

}
