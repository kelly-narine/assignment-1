package com.narine.validator;

import com.narine.GameManagementService;
import com.narine.model.Game;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FacesValidator("nameValidator") //annotation to register the validator
public class NameValidator implements Validator<String> {
    private static final List<Game> games_inventory = GameManagementService.games;
    List<String> game_names = new ArrayList<>();
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, String s) throws ValidatorException {
        for (Game game: games_inventory) {
            game_names.add(game.getName());
        }
        if (!game_names.contains(s)) {
            throw new ValidatorException(new FacesMessage("Name should be one of the following: " + Arrays.toString(game_names.toArray())));
        }
    }

}
