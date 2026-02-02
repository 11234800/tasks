package task9;

public class Main9 {
    public static void main(String[] args) {
        try{
            callThrowException();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void callThrowException() throws Exception {
        throwException();
    }
    public static void throwException() throws Exception {
        throw new Exception("propagated exception");
    }
}
