import java.util.ArrayList;
import java.util.Scanner;

public class CatLimpSettings {
    private final ArrayList<Cat> cats;

    public CatLimpSettings() {
        cats = new ArrayList<>();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hej velkommen til din katte-lem Settings");

        while (true) {
            System.out.println("Du har nu følgende muligheder");
            if (!cats.isEmpty()){
                System.out.println("1. Tilføj en kat");
            }else System.out.println("1. Tilføj katte");
            if (!cats.isEmpty())System.out.println("2. Fjern alle katte");
            if (!cats.isEmpty())System.out.println("3. Katte-lem  MODE");
            if (!cats.isEmpty())System.out.println("4. Test nuværene katte-lems MODE");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addCats();
                case 2 -> {
                    removeCats();
                    System.out.println("Alle katte er blevet fjernet.");
                }
                case 3 -> changeMode();
                case 4 -> testCurrentSettingsLimp();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Den mulighed findes ikke. Prøv igen.");
            }
        }
    }

    public void addCats() {
        Scanner scanner = new Scanner(System.in);

        if (cats.isEmpty()) {
            System.out.println("Hvor mange katte skal der tilføjes? ");
            int katAntal = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < katAntal; i++) {
                System.out.println("Hvad heder kat #" + (i + 1) + "?");
                String katNavn = scanner.nextLine();
                boolean isChipped = cats.size() < 5;

                cats.add(new Cat(katNavn, isChipped));
            }
        }else {
            System.out.println("Hvad heder kat #"+(cats.size()+1)+"?");
            String katNavn = scanner.nextLine();
            boolean isChipped = cats.size() < 5;

            cats.add(new Cat(katNavn,isChipped));
        }
    }
    public void removeCats() {
        cats.clear();
    }

    private CatLimpMode currentMode = CatLimpMode.IN_OUT;

    public void testCurrentSettingsLimp() {
        switch (currentMode) {
            case IN_OUT -> {
                System.out.println("Mode : IN / OUT");
                for (Cat cat : cats) {
                    if (cat.isChipped()) {
                        System.out.println(cat.getName() + " - Allowed IN / OUT");
                    } else System.out.println(cat.getName() + " - Allowed OUT / NOT IN");
                }
            }
            case ONLY_IN -> {
                System.out.println("Mode : IN ONLY");
                for (Cat cat : cats) {
                    if (cat.isChipped()) {
                        System.out.println(cat.getName() + " - Allowed IN / NOT OUT");
                    } else System.out.println(cat.getName() + " - NOT Allowed IN / OUT");
                }
            }
            case ONLY_OUT -> {
                System.out.println("Mode : OUT ONLY");
                for (Cat cat : cats) {
                    System.out.println(cat.getName() + " - Allowed OUT ONLY");
                }
            }
            case CLOSED -> {
                System.out.println("Mode : CLOSED");
                System.out.println("No cats allowed IN / OUT");
            }
        }
    }

    public void changeMode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vælg MODE:");
        System.out.println("1. IN/OUT");
        System.out.println("2. ONLY IN");
        System.out.println("3. ONLY OUT");
        System.out.println("4. CLOSED");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> currentMode = CatLimpMode.IN_OUT;
            case 2 -> currentMode = CatLimpMode.ONLY_IN;
            case 3 -> currentMode = CatLimpMode.ONLY_OUT;
            case 4 -> currentMode = CatLimpMode.CLOSED;
            default -> System.out.println("Den mulighed findes ikke. Mode uændret.");
        }
    }
}