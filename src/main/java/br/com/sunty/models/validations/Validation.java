package br.com.sunty.models.validations;

public class Validation {

    public static void nonEmptyFieldValidation(String text, String err) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException(err + " não pode ser nulo(a) ou vazio(a).");
        }
    }

    public static void intervalValidation(int minimum, int maximum, int value, String err) {
        if (value > maximum || value < minimum) {
            throw new IllegalArgumentException(err);
        }
    }

    public static void urlValidation(String urlCode) {
        if (!urlCode.matches("[-a-z]+")) {
            throw new IllegalArgumentException("Url só deve conter letras minusculas e traços.");
        }
    }

    public static void classNonNullValidation(Object object, String err) {
        if (object == null) {
            throw new IllegalArgumentException("A classe " + err + " não pode ser nula.");
        }
    }
}
