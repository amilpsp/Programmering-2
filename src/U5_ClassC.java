class ClassC {
    private int count;
    public void init() {
        count = 1;
    }
    public void increment() {
        count = count + 1;
    }
    public int getCount() {
        return count;
    }

}

class MainClass {
    public static void main( String[] args) {

        ClassC theObject = new ClassC(); //An object is instanced.
        theObject.init(); //Its value is initialized, otherwise the default value of 0 would be used.
        theObject.increment(); // count += 1 -> count = 2
        theObject.increment(); // count += 1 -> count = 3

        System.out.println(theObject.getCount()); //We can't just use .count because the class variable is set to private. We have to use this public method to get the response into this method.
        //The console just prints out the number 3
    }

}