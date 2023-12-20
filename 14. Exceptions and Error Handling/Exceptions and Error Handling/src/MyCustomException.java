public class MyCustomException extends RuntimeException{

    public MyCustomException(String message) {
        super(message);
    }

    public MyCustomException (String  message, Exception cause){
        super(message, cause);
    }
}
