package com.narine;
import com.narine.model.Game;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class GameManagementService implements GameManager {
    public static List<Game> games = new ArrayList<>();

    @Override
    public void add(@Observes @AddEvent Game game) {
        int quantity = 0;
        for(Game gameItem: games) {
            if(gameItem.getName().equals(game.getName())) {
                quantity = gameItem.getQuantity();
            }
        }
        games.removeIf(next -> next.getName().equals(game.getName()));
        Game updated_game = new Game(game.getName(),game.getPrice(), quantity + 1, game.getCompany());
        games.add(updated_game);
    }

    @Override
    public void remove(@Observes @RemoveEvent Game game) {
        games.remove(game);
    }

    @Override
    public List<Game> getGames() {
        return games;
    }

    @Override
    public void updateQuantity(@Observes @QuantityEvent Game game) {
        int quantity = 0;
        double price = 0;
        Game.Company company = null;
        for(Game gameItem: games) {
            if(gameItem.getName().equals(game.getName())) {
                price = gameItem.getPrice();
                quantity = gameItem.getQuantity();
                company = gameItem.getCompany();
            }
        }
        int updated_quantity = quantity + game.getQuantity();
        games.removeIf(next -> next.getName().equals(game.getName()));
        Game updated_game = new Game(game.getName(),price, updated_quantity, company);
        games.add(updated_game);
    }
}
