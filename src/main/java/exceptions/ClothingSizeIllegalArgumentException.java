package exceptions;

public class ClothingSizeIllegalArgumentException extends IllegalArgumentException{
    public static final String MESSAGE_CONSTRUCTOR = "clothing sizes have illegal arguments";
    public static final String MESSAGE_BUST = "bust in clothing sizes have illegal arguments";
    public static final String MESSAGE_HIPS = "hips in clothing sizes have illegal arguments";
    public static final String MESSAGE_WAIST = "waist in clothing sizes have illegal arguments";

    public ClothingSizeIllegalArgumentException(){}

    public ClothingSizeIllegalArgumentException(String message) {
        super(message);
    }

    public ClothingSizeIllegalArgumentException(String message, Throwable cause){
        super(message, cause);
    }

    public ClothingSizeIllegalArgumentException(Throwable cause) {
        super(cause);
    }
}
