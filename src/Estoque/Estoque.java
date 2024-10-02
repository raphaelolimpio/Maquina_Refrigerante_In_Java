package Estoque;

import Usuario.Usuario;

public class Estoque {
	
	public Usuario usuario = new Usuario();
	public String refrigerante;
	public int quantidade;
	public float Preco;
	
	
	
    public Estoque( String refrigerante, int quantidade, float preco) {
		super();

		this.refrigerante = refrigerante;
		this.quantidade = quantidade;
		Preco = preco;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getRefrigerante() {
		return refrigerante;
	}
	public void setRefrigerante(String refrigerante) {
		this.refrigerante = refrigerante;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public float getPreco() {
		return Preco;
	}
	public void setPreco(float preco) {
		Preco = preco;
	}

	
	
	

	

	
	//construtor definido

	

	
	
	
	
	
	

}
