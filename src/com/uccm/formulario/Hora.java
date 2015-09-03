package com.uccm.formulario;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TimePicker;
import com.uccm.R;
import com.uccm.R.id;

public class Hora extends Activity {
	int Cod[] = { 0, 0, 0, 0, 0, 0, 0 };
	String Nome;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hora);

		Intent intent = getIntent();
		final int Cod[] = intent.getIntArrayExtra("Cod");
		Nome = intent.getStringExtra("Nome");

		final TimePicker tpHora = (TimePicker) findViewById(id.timePickerHora);
		Button btnPhora = (Button) findViewById(R.id.btnProHora);
		Button btnVoltarQuantidade = (Button) findViewById(R.id.btnVoltarHora);

		tpHora.setCurrentHour(Cod[2]);
		tpHora.setCurrentMinute(Cod[3]);

		btnPhora.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Cod[2] = tpHora.getCurrentHour();
				Cod[3] = tpHora.getCurrentMinute();
				startActivity(new Intent(getBaseContext(), Intervalo.class)
						.putExtra("Cod", Cod).putExtra("Nome", Nome));

			}
		});
		btnVoltarQuantidade.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(getBaseContext(), Quantidade.class)
						.putExtra("Cod", Cod).putExtra("Nome", Nome));
				finish();

			}
		});
	}

	public void onResume() {
		super.onResume();
	}
}
