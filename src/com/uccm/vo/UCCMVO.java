package com.uccm.vo;

public class UCCMVO {
	private Integer Id;
	private String Nome;
	private int Quantidade;
	private int Hora_hora;
	private int Hora_minuto;
	private int Intervalo_hora;
	private int Intervalo_minuto;
	
	public UCCMVO(){
		
	}
	
	public UCCMVO(Integer id, String n, int q, int hh, int hm, int ih, int im){
		Id = id;
		Nome = n;
		Quantidade = q;
		Hora_hora = hh;
		Hora_minuto = hm;
		Intervalo_hora = ih;
		Intervalo_minuto = im;
		
	}
	
	public Integer getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public int getQuantidade() {
		return Quantidade;
	}
	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}
	public int getHora_hora() {
		return Hora_hora;
	}
	public void setHora_hora(int hora_hora) {
		Hora_hora = hora_hora;
	}
	public int getHora_minuto() {
		return Hora_minuto;
	}
	public void setHora_minuto(int hora_minuto) {
		Hora_minuto = hora_minuto;
	}
	public int getIntervalo_hora() {
		return Intervalo_hora;
	}
	public void setIntervalo_hora(int intervalo_hora) {
		Intervalo_hora = intervalo_hora;
	}
	public int getIntervalo_minuto() {
		return Intervalo_minuto;
	}
	public void setIntervalo_minuto(int intervalo_minuto) {
		Intervalo_minuto = intervalo_minuto;
	}
	public int[] getHora(int hh, int hm, int ih, int im){
    	int[] hora = new int[2];
    	hora[0] = hh+ih;
    	hora[1] = hm+im;
    	if(hora[1]>59){
    		hora[1]= hora[1]-60;
    		hora[0]++;
    	}
    	if(hora[0]>23){
    		hora[0]=hora[0]-24;
    	}
    	return hora;
    }
	
	

}
