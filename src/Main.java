import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    private static final Scanner in = new Scanner(System.in);
    private static final ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args)
    {
        boolean quit = false;

        while (!quit)
        {
            displayListAndMenu();

            String choice = SafeInput.getRegExString(
                    in,
                    "Enter your choice",
                    "[AaDdIiPpQq]"
            ).toUpperCase();

            switch (choice)
            {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm(in, "Are you sure you want to quit?"))
                    {
                        quit = true;
                    }
                    break;
            }
        }

        System.out.println("Goodbye!");
        in.close();
    }

    private static void displayListAndMenu()
    {
        System.out.println("\n========== LIST MAKER ==========");
        displayNumberedList();
        System.out.println("\nMenu:");
        System.out.println("A - Add an item");
        System.out.println("D - Delete an item");
        System.out.println("I - Insert an item");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit");
        System.out.println("================================");
    }

    private static void displayNumberedList()
    {
        System.out.println("\nCurrent List:");

        if (list.isEmpty())
        {
            System.out.println("(The list is empty.)");
        }
        else
        {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }

    private static void addItem()
    {
        System.out.print("Enter the item to add: ");
        String item = in.nextLine().trim();

        while (item.isEmpty())
        {
            System.out.print("The item cannot be blank. Enter the item: ");
            item = in.nextLine().trim();
        }

        list.add(item);
        System.out.println("\"" + item + "\" was added to the list.");
    }

    private static void deleteItem()
    {
        if (list.isEmpty())
        {
            System.out.println("There are no items to delete.");
            return;
        }

        displayNumberedList();
        int itemNumber = SafeInput.getRangedInt(
                in,
                "Enter the item number to delete",
                1,
                list.size()
        );

        String removedItem = list.remove(itemNumber - 1);
        System.out.println("\"" + removedItem + "\" was deleted.");
    }

    private static void insertItem()
    {
        System.out.print("Enter the item to insert: ");
        String item = in.nextLine().trim();

        while (item.isEmpty())
        {
            System.out.print("The item cannot be blank. Enter the item: ");
            item = in.nextLine().trim();
        }

        int location = SafeInput.getRangedInt(
                in,
                "Enter the position where the item should be inserted",
                1,
                list.size() + 1
        );

        list.add(location - 1, item);
        System.out.println("\"" + item + "\" was inserted at position " + location + ".");
    }

    private static void printList()
    {
        displayNumberedList();
    }
}
