public class ArrayLengthCantBeNegative extends RuntimeException{
    public ArrayLengthCantBeNegative(String strMsg, Throwable th){
        super(strMsg, th);
    }
}
