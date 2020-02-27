package com.github.RiccardoRossiMori.GraviTTT.Tests;

import com.github.RiccardoRossiMori.GraviTTT.Controller.CheckerboardManager;
import com.github.RiccardoRossiMori.GraviTTT.Controller.GameManager;
import com.github.RiccardoRossiMori.GraviTTT.Controller.StartGameDefault;
import com.github.RiccardoRossiMori.GraviTTT.Controller.StartGameInterface;
import com.github.RiccardoRossiMori.GraviTTT.Model.CheckerboardVariables;
import com.github.RiccardoRossiMori.GraviTTT.Model.MatrixCheckerboard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameManagerTest {

    CheckerboardVariables dimensioni = CheckerboardVariables.DEFAULT_SIZE;
    GameManager game;
    StartGameInterface startGameInterface;

    @BeforeEach
    void setUp() {
        game = new GameManager(new MatrixCheckerboard(this.dimensioni));
        startGameInterface = new StartGameDefault();
    }

    @Test
    void getCheckerboardManager() {
        Assertions.assertEquals(CheckerboardManager.class, this.game.getCheckerboardManager().getClass(), "tutto ok");
    }

    @Test
    void cambioTurno() {
        if (this.game.isTurno()) {
            this.game.cambioTurno();
            Assertions.assertFalse(this.game.isTurno());
        } else {
            this.game.cambioTurno();
            Assertions.assertTrue(this.game.isTurno());
        }
    }
}