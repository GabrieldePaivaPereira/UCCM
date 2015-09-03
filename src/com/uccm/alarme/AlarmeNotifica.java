package com.uccm.alarme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.uccm.R;
import com.uccm.R.id;

public class AlarmeNotifica extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		final MediaPlayer MediaPlayer = android.media.MediaPlayer.create(
				getBaseContext(), R.drawable.somalarm);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alarmenotifica);
		int Som = 0;

		Intent i = getIntent();
		final int h = i.getIntExtra("Hora", 0);
		final int m = i.getIntExtra("Minutos", 1);
		Som = i.getIntExtra("Som", 2);

		AudioManager AM = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		int volume = AM.getStreamVolume(AudioManager.STREAM_SYSTEM);
		
		if(volume!=0)MediaPlayer.start();
		final Vibrator rr = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long milliseconds = 16000; 
        rr.vibrate(milliseconds);
        

		Button btnTomar = (Button) findViewById(id.btnTomar);

		btnTomar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Parar(MediaPlayer);
				startActivity(new Intent(getBaseContext(), Alarme.class)
						.putExtra("Hora", h).putExtra("Minuto", m));
				rr.cancel();
				finish();

			}
		});
	}

	@Override
	protected void onDestroy() {
		final MediaPlayer MediaPlayer = android.media.MediaPlayer.create(
				getBaseContext(), R.drawable.somalarm);
		super.onDestroy();
		Parar(MediaPlayer);

	}

	public void Parar(MediaPlayer m) {
		m.stop();
	}
}
