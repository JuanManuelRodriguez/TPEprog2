import java.util.*;
public class PlayList extends ElementoSistema{
	Vector<ElementoSistema> lista;
	public PlayList(String titulo){
		super(titulo);
		lista=new Vector<ElementoSistema>();
	}
	public void setTitulo(String titulo){
		this.titulo=titulo;
	}
	public void add(ElementoSistema es){
		lista.add(es);
	}
	@Override
	public int cantidadElementos() {
		int ce=0;
		for(int i=0;i<this.lista.size();i++){
			ce+=lista.elementAt(i).cantidadElementos();
		}
		return ce;
	}
	@Override
	public int duracionTotal() {
		int duracion=0;
		for(int i=0;i<this.lista.size();i++){
			duracion+=lista.elementAt(i).duracionTotal();
		}
		return duracion;
	}
	@Override
	public void imprimir() {
		for(int i=0;i<lista.size();i++){
			lista.elementAt(i).imprimir();
		}
	}
}
