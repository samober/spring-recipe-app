package com.ober.recipe.converters;

import com.ober.recipe.commands.IngredientCommand;
import com.ober.recipe.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        if (source != null) {
            final IngredientCommand ingredientCommand = new IngredientCommand();
            ingredientCommand.setId(source.getId());
            ingredientCommand.setDescription(source.getDescription());
            ingredientCommand.setAmount(source.getAmount());
            ingredientCommand.setUom(uomConverter.convert(source.getUom()));
            if (source.getRecipe() != null) ingredientCommand.setRecipeId(source.getRecipe().getId());
            return ingredientCommand;
        }
        return null;
    }
}
