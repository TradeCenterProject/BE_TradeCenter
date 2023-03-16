package group1.unnamed.exception;

public class ExceptionConstants {

    public enum ExceptionClass {
        USER("User"), STOCK("Stock"), TASK("Task"), COMPANY("Company");

        private String exceptionClass;

        ExceptionClass(String exceptionClass) { this.exceptionClass = exceptionClass; }

        public String getExceptionClass() { return exceptionClass; }

        @Override
        public String toString() { return getExceptionClass() + " Exception. ";}
    }
}