public class U5_AnropaKlassMetod {
    static class Person{
        String name;
        String lastName;
        int birthYear;
        boolean single;
        boolean alive;

        //Here are the instance methods
        public boolean marry(){  //Here you can see some custom methods of things that can happen to people
            return single=false;
        }
        public boolean divorce(){ //These are ways to represent the changes that can happen to the object
            return single=true;
        }
        public boolean diedOfHeartBreak(){
            return alive=false;
        }
    }

    public static void main(String[]args) {
        var p1 = new Person();
        p1.name = "Amanda";
        p1.lastName = "Ruiz";
        p1.birthYear = 1997;
        p1.single= true;

        var p2 = new Person();
        p2.name = "Ben";
        p2.lastName= "Afleck";
        p2.birthYear= 1985;
        p2.single = false;

        System.out.println("In 2022");
        System.out.println("Amanda is single: " + (p1.single)
                + ". Ben is single: " + (p2.single));
        System.out.println("Some years later...");
        p1.marry();
        p2.divorce();
        System.out.println("Amanda is single: " + (p1.single)
                + ". Ben is single: " + (p2.single));
        System.out.println("Amanda regretted getting married. Such poor timing.");
    }

}
