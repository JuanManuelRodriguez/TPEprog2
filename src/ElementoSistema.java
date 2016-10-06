import java.util.*;
public abstract class ElementoSistema {
	String titulo;
	public ElementoSistema(String titulo){
		this.titulo=titulo;
	}
	public abstract int cantidadElementos();
	public abstract int duracionTotal();
	public abstract void imprimir();
	public abstract Vector buscar(Condicion c);
	public String getTitulo(){
		return this.titulo;
	}
}
