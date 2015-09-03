package com.uccm.alarme;

import java.util.Calendar;
import java.util.Date;

import com.uccm.Principal;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

public class AgendarAlarme extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		int Hh = 0;
		int Hm = 0;
		int Im = 0;
		int Ih = 0;
		
		Intent intent1 = getIntent();
		Hh = intent1.getIntExtra("Hh", 0);
		Hm = intent1.getIntExtra("Hm", 1);
		Im = intent1.getIntExtra("Im", 2);
		Ih = intent1.getIntExtra("Ih", 3);
		
		Intent intent = new Intent("Executar_Alarme");
		PendingIntent pi = PendingIntent.getBroadcast(AgendarAlarme.this, 0, intent, 0);
		
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		date.setHours(Hh);
		date.setMinutes(Hm);
		cal.setTime(date);
		cal.add(Calendar.MINUTE, Im);
		cal.add(Calendar.HOUR, Ih);
	
		AlarmManager alarme = (AlarmManager)getSystemService(ALARM_SERVICE);
		long time = cal.getTimeInMillis();
		alarme.setRepeating(AlarmManager.RTC_WAKEUP, time, ((Ih*60)+Im)*60000, pi);
		startActivity(new Intent(getBaseContext(), Principal.class));
	
}
}