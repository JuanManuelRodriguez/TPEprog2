import java.util.*;

public class SistemaDeMusica {
	Vector<ElementoSistema> listas;
	Vector<ElementoSistema> temas;//temas fuera de listas(sueltos)

	public SistemaDeMusica() {
		listas = new Vector<ElementoSistema>();
		temas = new Vector<ElementoSistema>();
	}

	public PlayList getPlayList(String titulo) {
		for (int i = 0; i < this.listas.size(); i++) {
			ElementoSistema pl = this.listas.elementAt(i);
			if (pl.getTitulo().equals(titulo)) {
				return (PlayList) pl;
			}
		}
		return null;
	}
	public void addPlayList(ElementoSistema es){
		listas.addElement(es);
	}
	public void addTema(ElementoSistema es){
		temas.addElement(es);
	}
	public int duracionTotal(String nombrePlayList) {//duracion total en segs de pistas de audio de una playlist
		return this.getPlayList(nombrePlayList).duracionTotal();
	}

	public int duracionTotal() {//duracion total en segs de pistas de audio del sistema
		int dt = 0;
		for(int i=0;i<this.listas.size();i++){
		dt+=listas.elementAt(i).duracionTotal();
		}
		for(int i=0;i<this.temas.size();i++){
		dt+=temas.elementAt(i).duracionTotal();
		}
		return dt;
	}

	public int cantidadElementos(String nombrePlayList) {//cantidad de pistas de audio de una playlist
		return this.getPlayList(nombrePlayList).cantidadElementos();
	}

	public int cantidadElementos() {//cantidad de pistas de audio del sistema

		int ce=temas.size();
		for(int i=0;i<this.listas.size();i++){
			ce+=this.listas.elementAt(i).cantidadElementos();
		}
		return ce;
	}

	public Vector<ElementoSistema> intercambiarTemas(String nombrePlaylist,int origen,int destino){
		return this.getPlayList(nombrePlaylist).intercambiarTema(origen-1, destino-1);//le restamos 1 porque el vector empieza de la posicion 0...si el usuario quiere cambiar tema 1 con tema 2, e el vector estan en la posicion 0 y 1 respectivamente
	}
	
	public void imprimir(String nombrePlayList) {//imprimir pistas de audio de una playlist
		this.getPlayList(nombrePlayList).imprimir();
	}

	public void imprimir() { //imprimir pistas de audio del sistema
		for (int j = 0; j < this.temas.size(); j++) {
			((PistaDeAudio) this.temas.elementAt(j)).imprimir();
		}
		for(int j=0;j<this.listas.size();j++){
			this.listas.elementAt(j).imprimir();
		}
		
	}
	
	public void imprimirDuracionDePlaylist(String nombrePlaylist){
		int duracion=this.duracionTotal(nombrePlaylist);
		if(duracion>0){
			System.out.println("La duracion total de la playlist "+nombrePlaylist+" es: "+duracion);
		}
		else{
			System.out.println("La playlist esta vacia o no existe");
		}
		
	}

	public void imprimirBusqueda(Vector<ElementoSistema> resultadoBusqueda){
		for(int k=0;k<resultadoBusqueda.size();k++){
			((PistaDeAudio)(resultadoBusqueda.elementAt(k))).imprimir();
		}
	}
	
	public Vector<ElementoSistema> buscar(Condicion c){
		Vector<ElementoSistema> resultado= new Vector<ElementoSistema>();
		for (int i = 0; i < this.temas.size(); i++) {
			resultado.addAll(this.temas.elementAt(i).buscar(c));
		}
		for(int j=0;j<this.listas.size();j++){
			resultado.addAll(this.listas.elementAt(j).buscar(c));
		}
		return resultado;
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
		PistaDeAudio p13 = new PistaDeAudio(13,"Paradise",365,"Coldplay","Mylo Xyloto",2011,"Rock Alternativo");
		PlayList pl1=new PlayList("Clasicos Del Rock");
		PlayList pl2=new PlayList("Lo Mejor");
		PlayList pl3=new PlayList("Coldplay");
		PlayList pl4=new PlayList("El Indio");
		pl1.add(p1);
		pl1.add(p2);
		pl1.add(p8);
		pl1.add(p9);
		pl1.add(p10);
		pl1.add(p12);
		
		pl2.add(p3);
		pl2.add(p4);
		pl2.add(p7);
		pl2.add(p12);
		//int cantidad= sm.cantidadElementos("Clasicos Del Rock");
		//System.out.println("la cantidad de temas de la playlist es: "+cantidad);
		//sm.imprimir("Clasicos Del Rock");
		//int duraciontotal= sm.duracionTotal("Clasicos Del Rock");
		//System.out.println("La duracion total de la playlist es: "+duraciontotal);
		pl3.add(p5);
		pl3.add(p6);
		pl3.add(p7);
		
		pl4.add(p12);
		pl4.add(p11);
		//agrega las playlist y el tema 13 al sistema de musica
		sm.addPlayList(pl1);
		sm.addPlayList(pl2);
		sm.addPlayList(pl3);
		sm.addPlayList(pl4);
		sm.addTema(p13);
		//duracion de playlists
		sm.imprimirDuracionDePlaylist(pl1.getTitulo());
		sm.imprimirDuracionDePlaylist(pl2.getTitulo());
		sm.imprimirDuracionDePlaylist(pl3.getTitulo());
		sm.imprimirDuracionDePlaylist(pl4.getTitulo());
		//probando busquedas
		CondicionArtistaInterprete c1=new CondicionArtistaInterprete("colDplay");
		//sm.imprimirBusqueda(sm.buscar(c1));
		CondicionTiempoMayorA c2 = new CondicionTiempoMayorA(300);
		CondicionAND c3=new CondicionAND(c1,c2);
		//sm.imprimirBusqueda(sm.buscar(c3));
		CondicionGenero c4=new CondicionGenero("rock");
		//sm.imprimirBusqueda(sm.buscar(c4));
		CondicionNombre c5=new CondicionNombre("rock");
		CondicionArtistaInterprete c6=new CondicionArtistaInterprete("LMFAO");
		CondicionNOT c7=new CondicionNOT(c6);
		CondicionAND c8=new CondicionAND(c5,c7);
		//sm.imprimirBusqueda(sm.buscar(c8));
		CondicionAnioMayorA c9=new CondicionAnioMayorA(2006);
		CondicionAND c10=new CondicionAND(c4,c9);
		CondicionAND c11=new CondicionAND(c4,c1);
		CondicionOR c12=new CondicionOR(c10,c11);
		sm.imprimirBusqueda(sm.buscar(c12));
	}
}
