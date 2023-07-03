import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.print.attribute.standard.MediaName;

public class GameTest {
    @Test
    public void testWhenFirstPlayerWin() {
        Player dima = new Player(1, "Dima", 100);
        Player diana = new Player(2, "Diana", 120);
        Game game = new Game();

        game.registered(dima);
        game.registered(diana);

        int actual = game.round("Diana", "Dima");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenTwoPlayerWin() {
        Player dima = new Player(1, "Dima", 100);
        Player diana = new Player(2, "Diana", 120);
        Game game = new Game();

        game.registered(dima);
        game.registered(diana);

        int actual = game.round("Dima", "Diana");
        int expected = 2;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testWhenPlayerDraw() {
        Player dima = new Player(1, "Dima", 100);
        Player diana = new Player(2, "Diana", 100);
        Game game = new Game();

        game.registered(dima);
        game.registered(diana);

        int actual = game.round("Dima", "Diana");
        int expected = 0;

        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void testWhenFirstPlayerNotExist() {
        Player dima = new Player(1, "Dima", 100);
        Player diana = new Player(2, "Diana", 120);
        Game game = new Game();

        game.registered(dima);
        game.registered(diana);

        Assertions.assertThrows(NotRegisteredException.class,() -> game.round("Natasha","Diana"));
    }
    @Test
    public void testWhenTwoPlayerNotExist() {
        Player dima = new Player(1, "Dima", 100);
        Player diana = new Player(2, "Diana", 120);
        Game game = new Game();

        game.registered(dima);
        game.registered(diana);

        Assertions.assertThrows(NotRegisteredException.class,() -> game.round("Dima","Natasha"));
    }
    @Test
    public void testWhenNoPlayerNotExist() {
        Player dima = new Player(1, "Dima", 100);
        Player diana = new Player(2, "Diana", 120);
        Game game = new Game();

        game.registered(dima);
        game.registered(diana);

        Assertions.assertThrows(NotRegisteredException.class,() -> game.round("Lena","Natasha"));
    }
}