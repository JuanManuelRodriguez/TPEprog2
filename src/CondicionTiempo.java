
public class CondicionTiempo extends Condicion{
	int tiempo;
	public CondicionTiempo(int tiempo){
		this.tiempo=tiempo;
	}
	@Override
	public boolean cumple(ElementoSistema es) {
		return ((PistaDeAudio)es).duracionTotal()==tiempo;
	}

}
