package utils;

public class RandomNumber {
    public static int generateRandomNumber(int min, int max){
        double randomId= Math.random()*(max-min)+min;
        return (int)Math.round(randomId);
    }
}
