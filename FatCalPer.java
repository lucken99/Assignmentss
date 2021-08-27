import java.util.Scanner;

public class FatCalPer {

    public static String takeInput(){
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        return inp;
    }

    public static void inputPrompt(String s){
        System.out.println(s);
    }

    public static double fatCalPercent(double gramsFat, int cal){

        return (gramsFat * 9 * 100) / cal;
    }
    public static void main(String[] args) {
        FatCalPer ft = new FatCalPer();

        ft.inputPrompt("Enter the name of a food item: ");
        String name = ft.takeInput();

        ft.inputPrompt("Enter the grams of fat: ");
        double gramsFat=0;
        try {
            gramsFat = Double.parseDouble(ft.takeInput());
        }
        catch (Exception e){
            System.out.println("Enter Valid Input");
            System.exit(1);
        }

        ft.inputPrompt("Enter the number of calories: ");
        int cal=0;
        try {
            cal = Integer.parseInt(ft.takeInput());
        }
        catch (Exception e){
            System.out.println("Enter Valid input of number of calories.");
            System.exit(1);
        }

        double perCal = ft.fatCalPercent(gramsFat, cal);
        System.out.printf("%s: %.2f\n",name, perCal);
        if(perCal > 30){
            System.out.println("This item is NOT Heart Healthy!");
        }
        else {
            System.out.println("This item is Heart Healthy!");
        }

    }
}