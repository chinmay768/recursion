public class CountZeroes {

    static int countZeroes(int num, int count){

//        Uncomment this for zerores at beginning
//        if(num == 0){
//            return 1;
//        }
//
//        if(num <10){
//            return 0;
//        }

//        Comment this block
        if(num == 0){
            return count;
        }

        int rem = num % 10;
        if(rem == 0){
            count++;
        }

        return  countZeroes(num/10, count);
    }

    public static void main(String[] args) {
        System.out.println(countZeroes(210010, 0));
    }
}
