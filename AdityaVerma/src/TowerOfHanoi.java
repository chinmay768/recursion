public class TowerOfHanoi {

    public static void towerOfHanoi(int n, int source, int helper, int desination){
        if(n == 1){
            System.out.println("Move 1st disk from " + source + " to " + desination);
            return;
        }

        // Assume all the n - 1 disks are sent to helper tower using destination
        towerOfHanoi(n - 1, source, desination, helper);


        System.out.println("Move " + n + "th disk form " + source + " to " + desination);

        // Assume all the n - 1 disks are sent to destination using source as helper
        towerOfHanoi(n - 1, helper, source, desination);
    }

    public static void main(String[] args) {
        towerOfHanoi(5, 1, 2, 3);
    }
}
