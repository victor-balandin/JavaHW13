package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test

    public void testIfFirstPlayerMoreStrength() {
        Game game = new Game();
        Player player1 = new Player(1, "Vitya", 100);
        Player player2 = new Player(2, "Vasya", 90);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Vitya", "Vasya");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void testIfSecondPlayerMoreStrength() {
        Game game = new Game();
        Player player1 = new Player(1, "Vitya", 90);
        Player player2 = new Player(2, "Vasya", 100);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Vitya", "Vasya");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void testIfDraw() {
        Game game = new Game();
        Player player1 = new Player(1, "Vitya", 100);
        Player player2 = new Player(2, "Vasya", 100);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Vitya", "Vasya");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void testIfSecondPlayerNull() {
        Game game = new Game();
        Player player1 = new Player(1, "Vitya", 90);
        Player player2 = new Player(2, "Vasya", 100);
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Vitya", "Sergei")
        );
    }

    @Test

    public void testIfFirstPlayerNull() {
        Game game = new Game();
        Player player1 = new Player(1, "Vitya", 90);
        Player player2 = new Player(2, "Vasya", 100);
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Sergei", "Vasya")
        );
    }

    @Test

    public void testIfAllPlayerNull() {
        Game game = new Game();
        Player player1 = new Player(1, "Vitya", 90);
        Player player2 = new Player(2, "Vasya", 100);
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Sergei", "Fedor")
        );
    }

    @Test

    public void testRegister() {
        Game game = new Game();
        Player player1 = new Player(1, "Vitya", 90);

        String expected = "Vitya";
        String actual = player1.getName();
        Assertions.assertEquals(expected, actual);

    }


}