public class U3_Extra_11_9 {
    public static void main (String[]args){
        int lowerBound =0;
        int higherBound = 15;
        int valueToAssign = 42;
        var array =new int[100];
        array = fyll(array,lowerBound,higherBound,valueToAssign);

        for (int i =0; i< array.length-1; i++){
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[array.length-1] + ".");
    }
    public static int[] fyll(int [] array, int lowerBound, int higherBound, int valueToAssign){
        for (int i = lowerBound; i < higherBound + 1; i++){
            array[i]=valueToAssign;
        }
    return array;
    }
}
