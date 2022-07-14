public class U5_ClassD {

    private int x, y, z;

    public U5_ClassD(int x, int y, int z) {
//In main the object constructed uses de values 1, 2 and 3.
        this.x = x;     //1
        this.y = y;     //2
        this.z = z;     //3
    }

    public void modify(int x,int y) {    //In main: ( 10 , 10 )
//"this" distinguishes between class attributes and parameters with the same name
        z = x + y;      // z = 10 + 10              -> z = 20
        this.x = z;     // The object's x = z       -> x = 20   (Not to be confused with the method's 'x')
        this.y = z + x; // The object's y = z + x   -> y = 20 + 10  -> y = 30
    }

    public void printout() {
        System.out.println("x = " + x); //20
        System.out.println("y = " + y); //30
        System.out.println("z = " + z); //20
    }
}

/*
Vad blir utskriften när klassen MainClass nedan exekveras?
**Förklara och motivera ditt svar.**
*/

