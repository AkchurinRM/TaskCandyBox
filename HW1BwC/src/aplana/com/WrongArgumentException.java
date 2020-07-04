package aplana.com;

public class WrongArgumentException extends Exception{

    public WrongArgumentException(){
        super("Unexpected Exception");
    }

    public WrongArgumentException(String message){
        super(message);
    }
}
