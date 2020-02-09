/**
 * 
 * <b>ResponsabilitÓ: </b>Gestisce la partita di due giocatori.
 * 
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public class GameManager implements GameManagerInterface {
	/*
	 * TODO definisci un flusso di computazione (scrivi i metodi senza elaborarli troppo)
	 * TODO gestione turni 
	 * TODO sistemare la faccenda delle dimensioni (essenzialmente come fare a prendere il valore del numero di righe e colonne)... serve? 
	 * TODO ("getRigaBassa") implementa <code>gravity</code> per sapere dove mettere la pedina nella colonna x 
	 * TODO posizionamento di una pedina in una colonna 
	 * TODO implementa i factory method per i <code>PlayerFactory</code> 
	 * TODO implementare i player in modo da poter immettere una pedina secondo le varie strategie 
	 * TODO gestione eccezioni (creale attraverso i test)
	 */
	private CheckerboardVariables dimensioni = CheckerboardVariables.DEFAULT_SIZE;
	private MatrixCheckerboard checkerboard;
	private boolean winner,flag;
	private Player giocatore1;
	private Player giocatore2;

	/**
	 * Gestisce il cambio turno durante una partita.
	 */
	@Override
	public void cambioTurno() {
	}

	/**
	 * 
	 * Inizializza le variabili di gioco
	 * 
	 */
	private void init() {
		giocatore1= new InteractivePlayer();
		giocatore2=new InteractivePlayer();
		this.setCheckerboard(new MatrixCheckerboard(dimensioni));
		winner=false;
		flag=false;
	}
	
	private Player azione() {
		return flag?giocatore1:giocatore2;
	}
	
	public void provaMain() {
		this.init();
		while(!winner) {
			flag=!flag;//????????????????????????????? oppure no?????????????????????????????????????
			winner=azione().strategy();
		}
		azione().toString();//sarebbe essenzialmente la stampa del giocatore vincitore
		
		
	}

	/**
	 * @return the checkerboard
	 */
	public MatrixCheckerboard getCheckerboard() {
		return checkerboard;
	}

	/**
	 * @param checkerboard the checkerboard to set
	 */
	private void setCheckerboard(MatrixCheckerboard checkerboard) {
		this.checkerboard = checkerboard;
	}

}
