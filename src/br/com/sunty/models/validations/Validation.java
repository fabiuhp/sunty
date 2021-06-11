package br.com.sunty.models.validations;

public class Validation {

    //Os métodos static ou métodos da classe são funções que não dependem de nenhuma variável de instância
    public static void emptyFieldValidation(String text, String err) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException(err);
        }
    }

    public static void intervalValidation(Integer minimumTime, Integer maximumTime, Integer timeForFinish, String err) {
        if (timeForFinish > maximumTime || timeForFinish < minimumTime) {
            throw new IllegalArgumentException(err);
        }
    }

    public static void urlValidation(String urlCode, String err) {
        if (urlCode.matches("[-?a-z]+")) {
            throw new IllegalArgumentException(err);
        }
    }

    public static void classNonNullValidation(Object object, String err) {
        if (object == null) {
            throw new IllegalArgumentException(err);
        }
    }
}
