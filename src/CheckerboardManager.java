/**
 * 
 * <b> Responsabilit�: </b> Gestire la scacchiera (posizionare una pedina, )
 * 
 */

/**
 * @author Riccardo Rossi Mori
 *
 */

public class CheckerboardManager {
	private GameManager gameManager;
	private MatrixCheckerboard scacchiera;

	

/*	private MatrixCheckerboard checkerboard;
	private CheckerboardVariables dimensioni= CheckerboardVariables.DEFAULT_SIZE;
	
	/**
	 * 
	 * Costruttore di default che permette di instanziare una <code>MatrixCheckerboard</code> con 6 righe e 7 colonne
	 * con il valore di <code>limitation</code> settato a true, ovvero la scacchiera ha i bordi esterni e non �
	 * possibile vincere sfruttando l'adiacenza tra bordo sinistro e bordo destro. 
	 * 
	 *
	public CheckerboardManager() {
		this.checkerboard = new MatrixCheckerboard(dimensioni);
	}
*/	

	/**
	 * 
	 * Costruttore che permette di instanziare una <code>MatrixCheckerboard</code> con <code>i</code> righe e <code>j</code> colonne
	 * con il valore di <code>limitation</code> settato a <code>flag</code>, dove con true si intende che la scacchiera ha dei bordi
	 * e con false si intende che la scacchiera non abbia i suddetti limiti esterni, per cui si pu� (o meno) vincere sfruttando
	 * l'adiacenza del bordo destro e bordo sinistro.
	 * 
	 * @param i
	 * @param j
	 * @param flag
	 */
	
	public CheckerboardManager(int i, int j, boolean flag) {
	//	this.checkerboard = new MatrixCheckerboard(new CheckerboardVariables(i, j, flag));
	}



	public MatrixCheckerboard getScacchiera() {
		return scacchiera;
	}

	public CheckerboardManager(MatrixCheckerboard scacchiera ){
		this.scacchiera=scacchiera;
	}
	
	/**
	 * 
	 * <code>action</code> consente di posizionare un <code>Pawn</code> (pedina/disco) nella colonna <code>p</code> della scacchiera
	 * <code>checkerboard</code>.
	 *
	 * @param p
	 * @param turno
	 * @return
	 */
	public boolean action(int p, boolean turno) throws IllegalPawnPlacement {
		//ODO implementare il metodo
		//GameManagerInterface.getCheckerboard().putPawn(p,Pawn.Red);
		//Pawn disco= Pawn.Green;
	//	checkerboard.putPawn(p, disco);
		return 	turno?scacchiera.putPawn(p,Pawn.Red):scacchiera.putPawn(p,Pawn.Green);
	}

}
