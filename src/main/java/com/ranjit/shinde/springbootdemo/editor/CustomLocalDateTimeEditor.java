package com.ranjit.shinde.springbootdemo.editor;

import lombok.extern.slf4j.Slf4j;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Slf4j
public class CustomLocalDateTimeEditor extends PropertyEditorSupport {

    public CustomLocalDateTimeEditor() {
    }

    private LocalDate parseText(String text) {
        try {
            return  LocalDate.parse(text);
        } catch(Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(parseText(text));
    }

    @Override
    public String getAsText() {
        LocalDate value = parseText(String.valueOf(getValue()));
        return (value != null ? value.toString() : "");
    }

}
