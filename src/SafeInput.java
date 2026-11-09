import java.util.Scanner;

public class SafeInput
{
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String value;

        do
        {
            System.out.print(prompt + ": ");
            value = pipe.nextLine().trim();

            if (!value.matches(regEx))
            {
                System.out.println("Invalid entry. Please try again.");
            }
        }
        while (!value.matches(regEx));

        return value;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int value;
        boolean valid;

        do
        {
            System.out.print(prompt + " [" + low + "-" + high + "]: ");
            String input = pipe.nextLine().trim();

            try
            {
                value = Integer.parseInt(input);
                valid = value >= low && value <= high;

                if (!valid)
                {
                    System.out.println("Please enter a number from " + low + " to " + high + ".");
                }
            }
            catch (NumberFormatException e)
            {
                value = low;
                valid = false;
                System.out.println("Please enter a whole number.");
            }
        }
        while (!valid);

        return value;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String answer = getRegExString(pipe, prompt + " (Y/N)", "[YyNn]");
        return answer.equalsIgnoreCase("Y");
    }
}
