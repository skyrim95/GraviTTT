package com.github.RiccardoRossiMori.GraviTTT.Controller;

import com.github.RiccardoRossiMori.GraviTTT.Exceptions.IllegalPawnPlacementException;
import com.github.RiccardoRossiMori.GraviTTT.Model.CheckerboardVariables;
import com.github.RiccardoRossiMori.GraviTTT.Model.MatrixCheckerboard;
import com.github.RiccardoRossiMori.GraviTTT.Model.Player;
import com.github.RiccardoRossiMori.GraviTTT.View.GraviTTTView;

import java.io.IOException;
import java.util.function.Consumer;


/**
 * <b>Responsabilità: </b>Gestisce la partita di due giocatori, dunque:
 * -inserire pedine
 * -cambio turni
 * -conclude il gioco in caso di vincita di un giocatore.
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public class GameManager implements GameManagerInterface {
    private GraviTTTView vista;
    private Player giocatore1, giocatore2;
    /*
     * TODO verifica di rispettare i principi "L" ed "I" dei principi SOLID
     * TODO implementa il codice in RandomPlayerFactory e InteractivePlayerFactory se necessario (controlla)
     * TODO refactoring del codice, sposta il main e tutto ciò che non è compito del GameManager
     * TODO lanciare e gestire le eccezioni dove necessario
     * TODO refactoring variabili e metodi in modo che sia tutto in una lingua unica (inglese o italiano)
     * TODO Creare Test per le diverse parti di codice
     * TODO gestire IllegalInputException (voglio int, mi danno char o String)
     * TODO implementa partite continue
     * TODO possibile implementazione del design pattern "strategy" per le strategie dei player... per ora rimane ipotesi
     */
    private StartGameInterface startGameInterface ;// private CheckerboardVariables dimensioni //  private MatrixCheckerboard checkerboard;

   public CheckerboardManager getCheckerboardManager() {
        return checkerboardManager;
    }

    private CheckerboardManager checkerboardManager ;
    private boolean winner , turno;

    public GameManager(MatrixCheckerboard matrixCheckerboard) {
        this.startGameInterface = new StartGameDefault();
        //this.dimensioni = CheckerboardVariables.DEFAULT_SIZE;//TODO controlla se puoi eliminare le due righe commentate
        //this.setCheckerboard(matrixCheckerboard);
        this.checkerboardManager = new CheckerboardManager(matrixCheckerboard);
        this.winner = false;
        this.turno = true;
    }


    /**
     * Gestisce il cambio turno durante una partita.
     */
    @Override
    public void cambioTurno() {
        this.turno = !turno;
    }


    /**
     *
     * Restituisce, a seconda del turno, il giocatore uno oppure il giocatore 2.
     *
     * @return giocatore1|giocatore2
     */

    private Player getGiocatore() {
        return turno ? giocatore1 : giocatore2;
    }

    //TODO refactoring in modo da ridurre le linee di codice e lasciare a questo metodo una sola responsabilità.
        //boolean x=true;
    @Override
    public void play() throws IOException, IllegalPawnPlacementException {
        startGameInterface.init(this);
        this.giocatore1 = startGameInterface.scegliGiocatori("Primo");
        this.giocatore2 = startGameInterface.scegliGiocatori("Secondo");
    }
        while (!winner) {
            vista.printCheckerboard(checkerboardManager.printCheckerboard());
            System.out.println( "Ora è il turno del " + (this.turno?"giocatore uno ":"giocatore due" )+"\n");
            winner = checkerboardManager.action(getGiocatore().strategy(this.checkerboardManager), turno);//TODO trova soluzione più semplice ed efficace (?)
            if(!winner)
                cambioTurno();
        }
        vista.printCheckerboard(checkerboardManager.printCheckerboard());//TODO refactoring codice, ho fatto copia incolla
        if (getGiocatore() == giocatore1) {
            System.out.println("Ha vinto il primo giocatore");
        } else {
            System.out.println("Ha vinto il secondo giocatore");
        }
        //TODO chiedi se si vuole giocare un'altra partita.
        //return x;
    }

    /*
     * @return the checkerboard
     */
 /*   @Override
    public MatrixCheckerboard getCheckerboard() {
        return checkerboard;
    }//TODO sposta in com.github.RiccardoRossiMori.GraviTTT.Model.MatrixCheckerboard*/

    /*
     * @param checkerboard the checkerboard to set
     */
   /* private void setCheckerboard(MatrixCheckerboard checkerboard) {
        this.checkerboard = checkerboard;
    }*/


    public void setVista(GraviTTTView vista) {
        this.vista = vista;
    }

    public GraviTTTView getVista() {
        return this.vista;
    }
}
