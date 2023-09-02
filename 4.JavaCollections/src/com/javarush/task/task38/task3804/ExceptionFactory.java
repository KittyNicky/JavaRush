package com.javarush.task.task38.task3804;

public class ExceptionFactory {
    public static Throwable getException(Enum e) {
        if (e == null) return new IllegalArgumentException();
        String message = e.name().charAt(0) +
                e.name().replaceAll("_", " ").toLowerCase().substring(1);

        System.out.println(message);
        switch (e.getClass().getSimpleName()) {
            case ("ApplicationExceptionMessage"): {
                return new Exception(message);
            }
            case ("DatabaseExceptionMessage"): {
                return new RuntimeException(message);
            }
            case ("UserExceptionMessage"): {
                return new Error(message);
            }
            default: {
                return new IllegalArgumentException();
            }
        }

    }
}
