
public class Debuger {

    public static void main(String[] args) {
        String firstLine = "FirstString";
        String secondLine = "SecondLine";
        String result;
        result = contactsString(firstLine, secondLine);


        for(int i = 0; i>10; i++){
            System.out.println(i);

        }
    }

        public static String contactsString(String s1, String s2){
            System.out.println("ContactsString");
            System.out.println("----------------------------");
        return s1+s2;
    }

}
