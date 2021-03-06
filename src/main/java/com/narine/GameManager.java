package com.narine;
import com.narine.model.Game;
import java.util.List;

public interface GameManager {
    void add(Game game);
    void remove(Game game);
    List<Game> getGames();
    void updateQuantity(Game game);
}
