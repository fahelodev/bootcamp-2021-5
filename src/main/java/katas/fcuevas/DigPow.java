package katas.fcuevas;

public class DigPow {
        public static long digPow(int n, int p) {
            String nString = String.valueOf(n);
            long suma = 0;
            for (int i = 0; i < nString.length(); i++) {
                suma += (long)Math.pow((int)(nString.charAt(i) -'0'), p+i);
            }
            if (suma % n == 0)
                return suma / n;
            else
                return -1;
        }
}
