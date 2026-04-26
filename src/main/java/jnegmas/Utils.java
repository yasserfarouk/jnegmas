package jnegmas;

import java.util.Random;

public class Utils {

    public static String randomString(int n){
        String chars = "abcdefghijklmnopqrstuvwxyz-0123456789+=/";
        StringBuilder builder = new StringBuilder();
        Random rnd = new Random();
        for (int i=0;i< n; i++){
            int indx = (int)(rnd.nextFloat() * chars.length());
            builder.append(chars.charAt(indx));
        }
        return builder.toString();
    }
}
