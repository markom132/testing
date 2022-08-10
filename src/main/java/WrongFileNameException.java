public class WrongFileNameException extends Exception{
    public WrongFileNameException(String error, Throwable throwable){
        super(error , throwable);
    }

    public WrongFileNameException(String message) {
        super(message);
    }
}
