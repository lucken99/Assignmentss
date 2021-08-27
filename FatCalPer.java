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

    public static fatCalPercent()
    public static void main(String[] args) {
        FatCalPer ft = new FatCalPer();

        ft.inputPrompt("Enter the name of a food item: ");
        String name = ft.takeInput();

        ft.inputPrompt("Enter the grams of fat: ");
        try {
            double gramsFat = Double.parseDouble(ft.takeInput());
        }
        catch (Exception e){
            System.out.println("Enter Valid Input")
        }

        ft.inputPrompt("Enter the number of calories: ");
        int cal = Integer.parseInt(ft.takeInput());



    }
}