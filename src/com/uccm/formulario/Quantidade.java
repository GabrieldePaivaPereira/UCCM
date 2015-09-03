package com.uccm.formulario;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import com.uccm.R;
import com.uccm.R.id;

public class Quantidade extends Activity {
	String Nome;
	int Cod[];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quantidade);

		Intent intent = getIntent();
		final int Cod[] = intent.getIntArrayExtra("Cod");
		Nome = intent.getStringExtra("Nome");

		final NumberPicker npQuantidade = (NumberPicker) findViewById(id.numberPickerQTD);
		Button btnPromq = (Button) findViewById(R.id.btnPromq);
		Button btnVoltarQuantidade = (Button) findViewById(R.id.btnVoltarQuantidade);

		npQuantidade.setMaxValue(200);
		npQuantidade.setValue(Cod[1]);
		

		btnPromq.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Cod[1] = npQuantidade.getValue();
				startActivity(new Intent(getBaseContext(), Hora.class)
						.putExtra("Cod", Cod).putExtra("Nome", Nome));

			}
		});
		btnVoltarQuantidade.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(getBaseContext(), Nome.class)
						.putExtra("Cod", Cod).putExtra("Nome", Nome));
				finish();

			}
		});

	}
}
