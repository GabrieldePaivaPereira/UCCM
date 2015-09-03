package com.uccm.formulario;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;
import com.uccm.R;
import com.uccm.vo.UCCMVO;
import com.uccm.R.id;
import com.uccm.alarme.AgendarAlarme;
import com.uccm.dao.UCCMDAO;

public class Intervalo extends Activity {
	int Cod[];
	String Nome;	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intervalo);
        
        Intent intent = getIntent();
        final int Cod[] = intent.getIntArrayExtra("Cod");
        Nome = intent.getStringExtra("Nome");
        
        
        final NumberPicker npIntervaloHora = (NumberPicker)findViewById(id.numberPickerIh);
        final NumberPicker npIntervaloMinuto = (NumberPicker)findViewById(id.numberPickerIm);
        Button btnSalvar = (Button)findViewById(R.id.btnSalvarIntervalo);
        Button btnVoltarQuantidade = (Button)findViewById(R.id.btnVoltarIntervalo);
        
        npIntervaloHora.setMaxValue(72);
        
        npIntervaloMinuto.setMaxValue(59);
        
        
        	npIntervaloHora.setValue(Cod[4]);
        	npIntervaloMinuto.setValue(Cod[5]);
        
                
        btnSalvar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				UCCMDAO dao = new UCCMDAO(getBaseContext());
				UCCMVO vo = new UCCMVO();
				int[] h = {Cod[2],Cod[3]};

				h = vo.getHora(Cod[2], Cod[3], npIntervaloHora.getValue(), npIntervaloMinuto.getValue());

				vo.setNome(Nome);
				vo.setQuantidade(Cod[1]);
				vo.setHora_hora(h[0]);
				vo.setHora_minuto(h[1]);
				vo.setIntervalo_hora(npIntervaloHora.getValue());
				vo.setIntervalo_minuto(npIntervaloMinuto.getValue());
				if(Cod[6]==0){
					if(dao.insert(vo)){
						Toast.makeText(getBaseContext(), "Medicamento Cadastrado", Toast.LENGTH_SHORT).show();
						startActivity(new Intent(getBaseContext(), AgendarAlarme.class)
						.putExtra("Hh", Cod[2])
						.putExtra("Hm", Cod[3])
						.putExtra("Im", vo.getIntervalo_minuto())
						.putExtra("Ih", vo.getIntervalo_hora()));
					}
				}else{
					vo.setId(Cod[0]);
					if(dao.update(vo)){
						Toast.makeText(getBaseContext(), "Medicamento Atualizado", Toast.LENGTH_SHORT).show();
						startActivity(new Intent(getBaseContext(), AgendarAlarme.class)
						.putExtra("Hh", Cod[2])
						.putExtra("Hm", Cod[3])
						.putExtra("Im", vo.getIntervalo_minuto())
						.putExtra("Ih", vo.getIntervalo_hora()));
					}

				}			
				
				
			}
		});
        btnVoltarQuantidade.setOnClickListener(new View.OnClickListener() {
        	  
        	  @Override
        	  public void onClick(View v) {
        		finish();
    			
    		}
    	}); 
    }
    
}
