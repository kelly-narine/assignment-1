package com.narine;
import com.narine.interceptor.Logged;
import com.narine.model.Game;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model //meta annotation that contain @RequestScoped and @Named
public class GameBean {
    private String name;
    private double price;
    private int quantity;
    private String company;

    private int quantity_change;
    private String nameUpdate;

    private Game.Company defaultCompany = Game.Company.BUNGIE;

    @Inject //instantiate the object properly
    @AddEvent
    private Event<Game> gameAddEvent;

    @Inject
    @RemoveEvent
    private Event<Game> gameRemoveEvent;

    @Inject
    @QuantityEvent
    private Event<Game> gameQuantityUpdateEvent;

    @Inject
    private GameManager gameManagementService;

    public List<Game> getGames() {
        return gameManagementService.getGames();
    }
    @Logged
    public void addGame() {
        if (company.equals("BETHESDA")) {
            defaultCompany = Game.Company.BETHESDA;
        }
        if (company.equals("UBISOFT")) {
            defaultCompany = Game.Company.UBISOFT;
        }
        Game game = new Game(name, price, quantity, defaultCompany);
        gameAddEvent.fire(game);
    }
//NOTE: Logged annotation is used to track when the method is being called
    @Logged
    public void removeGame(Game game) {
        gameRemoveEvent.fire(game);
    }

    @Logged
    public void updateQuantity() {
        Game game = new Game(nameUpdate, price, quantity_change, defaultCompany);
        gameQuantityUpdateEvent.fire(game);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getQuantity_change() {
        return quantity_change;
    }

    public void setQuantity_change(int quantity_change) {
        this.quantity_change = quantity_change;
    }

    public String getNameUpdate() {
        return nameUpdate;
    }

    public void setNameUpdate(String nameUpdate) {
        this.nameUpdate = nameUpdate;
    }

    public Game.Company getDefaultCompany() {
        return defaultCompany;
    }

    public void setDefaultCompany(Game.Company defaultCompany) {
        this.defaultCompany = defaultCompany;
    }

}
