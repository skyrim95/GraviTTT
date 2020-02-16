package com.github.RiccardoRossiMori.GraviTTT.Controller;

import com.github.RiccardoRossiMori.GraviTTT.Model.*;
import com.github.RiccardoRossiMori.GraviTTT.View.GraviTTTConsoleView;

import java.io.IOException;

/**
 * <b>Responsabilit�: </b>Inizializzare una partita tra due <code>com.github.RiccardoRossiMori.GraviTTT.Model.Player</code> ed una <code>com.github.RiccardoRossiMori.GraviTTT.Model.Checkerboard</code>
 * con variabili standard, ossia una scacchiera con 6 righe e 7 colonne limitata esteriormente.
 *
 *
 * @author Riccardo Rossi Mori
 *
 */

public class StartGameDefault implements StartGameInterface {

    private CheckerboardVariables dimensioni = CheckerboardVariables.DEFAULT_SIZE;
    private GameManager gameManager;

    /**
     *
     * getPlayerFactory, presa una stringa, instanzia un giocatore del tipo richiesto.
     *
     * @param string
     * @return
     */

    private static Player getPlayerFactory(String string) {
        if (string.equals("bot")) {
            return new RandomPlayer();
        }
        return new InteractivePlayer();
    }

    @Override
    public CheckerboardManager getCheckerboardManager() {
        return this.gameManager.getCheckerboardManager();
    }

    /**
     *
     * Inizializza le variabili di gioco
     * @throws IOException
     *
     */
    @Override
    public void init(GameManager gameManager) {// TODO Sistema variabili in modo decente
        this.gameManager= gameManager;
        //gameManager = new GameManager(new MatrixCheckerboard(dimensioni));
        gameManager.setVista(new GraviTTTConsoleView());
    }

    /**
     *
     * Instanzia un particolare com.github.RiccardoRossiMori.GraviTTT.Model.Player a seconda della stringa inserita.
     * Se si scrive 'bot' verr� instanziato un com.github.RiccardoRossiMori.GraviTTT.Model.Player di tipo com.github.RiccardoRossiMori.GraviTTT.Model.RandomPlayer, che eseguir� ogni
     * mossa casualmente, mentre se si scriver� una qualunque altra cosa verr� instanziato un
     * com.github.RiccardoRossiMori.GraviTTT.Model.Player di tipo com.github.RiccardoRossiMori.GraviTTT.Model.InteractivePlayer, ossia un giocatore Interattivo.
     * Potrebbe essere lanciata una IOException poich� richiede degli input esterni.
     *
     * @param giocatorenumerox
     * @return Player
     * @throws IOException
     */
    @Override
    public Player scegliGiocatori1(String giocatorenumerox) throws IOException {
        //List<com.github.RiccardoRossiMori.GraviTTT.Model.Player> giocatori=null;
        String tipodigiocatorescelto; //x= vista.getStringPlayer("Primo giocatore, inserisci 'bot' per il primo giocatore random, premi un qualunque altro tasto per il giocatore interattivo.");
        tipodigiocatorescelto = gameManager.getVista().getStringPlayer(giocatorenumerox + " giocatore, inserisci 'bot' per il giocatore random, premi un qualunque altro tasto per il giocatore interattivo.");
        //getPlayerFactory(x.toLowerCase());
        return getPlayerFactory(tipodigiocatorescelto.toLowerCase());
        //giocatori.add(getPlayerFactory(x)); //giocatori.add(y.toLowerCase()); //return giocatori;
    }

}
