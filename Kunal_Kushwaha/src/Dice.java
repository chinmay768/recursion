public class Dice {

    static void dice(String p, int target){
        if(target == 0){
            System.out.println(p);
            return;
        }

        for(int i = 1; i <= 6 && i <= target; i++){
            dice(p + i, target - i);
        }
    }

    // Variable num of faces
    static void diceFace(String p, int target, int faces){
        if(target == 0){
            System.out.println(p);
            return;
        }

        for(int i = 1; i <= faces && i <= target; i++){
            diceFace(p + i, target - i, faces);
        }
    }

    public static void main(String[] args) {
//        dice("", 4);
        diceFace("", 14, 7);
    }
}
