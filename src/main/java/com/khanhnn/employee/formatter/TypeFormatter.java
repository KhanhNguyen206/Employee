package com.khanhnn.employee.formatter;

import com.khanhnn.employee.model.Type;
import com.khanhnn.employee.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class TypeFormatter implements Formatter <Type> {
    @Autowired
    private TypeService typeService;

    @Autowired
    public void TypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    @Override
    public Type parse(String text, Locale locale) throws ParseException {
        return typeService.findById(Integer.parseInt(text));
    }

    @Override
    public String print(Type object, Locale locale) {
        return "[" + object.getId() + ", " + object.getNameType() + "]";
    }
}
