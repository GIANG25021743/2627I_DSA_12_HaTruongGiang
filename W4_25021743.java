import java.util.Arrays;


public class W4_25021743 {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int temp = citations.length;
        
        for (int i = 0; i < citations.length; ++i) {
            if (citations[i] < temp) {
                temp -= 1;
            }
        }
        
        return temp;
    }

    
}