package uaslp.objects.list.exception;

public class NotNullValuesAllowedException extends Exception{

    public NotNullValuesAllowedException(){
        super("Null values are not allowed");
    }
}