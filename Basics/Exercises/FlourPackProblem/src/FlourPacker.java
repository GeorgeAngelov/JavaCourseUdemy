public class FlourPacker {

    public static boolean canPack (int bigCount, int smallCount, int goal) {
        for (int i=0; i<= smallCount;i++){
            for (int j = 0; j<=bigCount;j++){
                if (j*5 + i==goal){
                    return true;
                }
            }
        }
        if (bigCount<0 || smallCount <0 || goal <0){
            return false;
        }
            return false;
    }
}
