public class Dummy {
    private static String name;
/*  'name' here is a class variable. Because of this keyword, that means that the variable
* exists only in one edition, common to all of the objects in the class. Normally this would
* Be used to declare a constant.
*
* That's why, when the name of a new object is assigned, the name of all of the objects in
* the class are immediately updated.
*
* If one would want to get different values for that variable in different objects, one
* would have to remove the 'static' keyword*/
    public Dummy( String name ) {
        this.name = name;
    } // konstruktor

    public void skriv() {
        System.out.println( "The name is: " + name );
    }

    public String toString() {
        return name;
    }

} // Dummy

    /*Vad blir utskriften när klassen utskrift nedan exekveras?
     **Förklara och motivera ditt svar.**
     */
    class Utskrift {

        public static void main( String[] a) {
            Dummy kk1 = new Dummy( "Ettan" );
            kk1.skriv();
            Dummy kk2 = new Dummy( "Tvåan" );
            kk2.skriv();
            System.out.println( kk1 + " " + kk2 );
        }
    } // Utskrift
