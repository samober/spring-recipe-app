package com.ober.recipe.converters;

import com.ober.recipe.commands.CategoryCommand;
import com.ober.recipe.domain.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

    @Synchronized
    @Nullable
    @Override
    public CategoryCommand convert(Category source) {
        if (source != null) {
            final CategoryCommand categoryCommand = new CategoryCommand();
            categoryCommand.setId(source.getId());
            categoryCommand.setDescription(source.getDescription());
            return categoryCommand;
        }
        return null;
    }
}
