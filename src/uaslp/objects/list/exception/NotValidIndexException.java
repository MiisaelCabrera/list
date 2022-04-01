package uaslp.objects.list.exception;

public class NotValidIndexException extends Exception{

    public NotValidIndexException(int wrongIndex){
        super("Index " + wrongIndex + " is out of bounds");
    }
}