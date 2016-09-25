import java.util.*;

public class SistemaDeMusica {
	Vector<ElementoSistema> listas;
	Vector<ElementoSistema> temas;

	public SistemaDeMusica() {
		listas = new Vector<ElementoSistema>();
		temas = new Vector<ElementoSistema>();
	}

	public PlayList getPlayList(String titulo) {
		for (int i = 0; i < this.listas.size(); i++) {
			ElementoSistema pl = this.listas.elementAt(i);
			if (pl.getTitulo() == titulo) {
				return (PlayList) pl;
			}
		}
		return null;
	}

	public int duracionTotal(String nombrePlayList) {
		return this.getPlayList(nombrePlayList).duracionTotal();
	}

	public int duracionTotal() {
		int dt = 0;
		// for(int i=0;i<this.listas.size();i++){
		// dt+=listas.elementAt(i).duracionTotal();
		// }
		// return dt;
		for (int j = 0; j < this.temas.size(); j++) {
			dt += ((PistaDeAudio) temas.elementAt(j)).getDuracion();
		}
		return dt;
	}

	public int cantidadElementos(String nombrePlayList) {
		return this.getPlayList(nombrePlayList).cantidadElementos();
	}

	public int cantidadElementos() {
		// int ce=0;
		// for(int i=0;i<this.listas.size();i++){
		// ce+=listas.elementAt(i).cantidadElementos();
		// }
		// return ce;
		return temas.size();
	}

	public void imprimir(String nombrePlayList) {
		this.getPlayList(nombrePlayList).imprimir();
	}

	public void imprimir() {
		// for(int i=0;i<this.listas.size();i++){
		// listas.elementAt(i).imprimir();
		// }
		for (int j = 0; j < this.temas.size(); j++) {
			((PistaDeAudio) this.temas.elementAt(j)).imprimir();
		}
	}

	public static void main(String[] args) {
		SistemaDeMusica sm = new SistemaDeMusica();
		PistaDeAudio p1 = new PistaDeAudio(1,"El Tiempo No Para",311,"Bersuit Vergarabat","De La Cabeza",2002,"Rock Nacional");
		PistaDeAudio p2 = new PistaDeAudio(2,"Mi Caramelo",290,"Bersuit Vergarabat","De La Cabeza",2002,"Rock Nacional");
		PistaDeAudio p3 = new PistaDeAudio(3,"Party Rock Anthem",408,"LMFAO","Sorry For Party Rocking",2011,"Electro Pop");
		PistaDeAudio p4 = new PistaDeAudio(4,"Sorry For Party Rocking",421,"LMFAO","Sorry For Party Rocking",2011,"Electro Pop");
		PistaDeAudio p5 = new PistaDeAudio(5,"Fix You",255,"Coldplay","X&Y",2005,"Rock Alternativo");
		PistaDeAudio p6 = new PistaDeAudio(6,"Speed Of Sound",455,"Coldplay","X&Y",2005,"Rock Alternativo");
		PistaDeAudio p7 = new PistaDeAudio(7,"Viva La Vida",320,"Coldplay","Viva La Vida",2008,"Rock Alternativo");
		PistaDeAudio p8 = new PistaDeAudio(8,"With Or Whitout You",360,"U2","The Joshua Tree",1987,"Rock");
		PistaDeAudio p9 = new PistaDeAudio(9,"Vertigo",355,"U2","How To Dismantle An Atomic Bomb",2004,"Rock");
		PistaDeAudio p10 = new PistaDeAudio(10,"City Of Blindings Lights",284,"U2","How To Dismantle An Atomic Bomb",2004,"Rock");
		PistaDeAudio p11 = new PistaDeAudio(11,"A La Luz De La Luna",438,"El Indio Solari","Pajaritos, Bravos Muchachitos",2013,"Rock Nacional");
		PistaDeAudio p12 = new PistaDeAudio(12,"Yo Canibal",258,"Patricio Rey Y Sus Redonditos De Ricota","Lobo Suelto, Cordero Atado",1993,"Rock Nacional");
		PlayList pl1=new PlayList("Clasicos Del Rock");
		PlayList pl2=new PlayList("Lo Mejor");
		PlayList pl3=new PlayList("Coldplay");
		PlayList pl4=new PlayList("El Indio");
	}
}
