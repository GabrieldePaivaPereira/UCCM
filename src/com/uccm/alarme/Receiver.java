package com.uccm.alarme;

import java.util.Date;

import com.uccm.R;
import com.uccm.dao.UCCMDAO;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;

public class Receiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Date date = new Date();
		date.setTime(System.currentTimeMillis());
		UCCMDAO dao = new UCCMDAO(context);
		if(dao.contaByHora(date.getHours(), date.getMinutes())> 0){
			Intent i = new Intent(context, AlarmeNotifica.class)
			.putExtra("Hora", date.getHours())
			.putExtra("Minutos", date.getMinutes())
			.putExtra("Som", 1);
			i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        context.startActivity(i);
		}
		
	}

}
