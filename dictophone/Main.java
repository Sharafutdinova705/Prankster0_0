import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        DictaphoneManager dictaphoneManager = new DictaphoneManager("./Records");
        Scanner command = new Scanner(System.in);

        System.out.println(dictaphoneManager.commands());
        System.out.println("Введите команду:");


        while(true){
            System.out.println();
            switch(command.nextLine()){

                case "1":
                    System.out.println("Введите название:");
                    dictaphoneManager.startRecord(command.nextLine());
                    break;

                case "2":
                    dictaphoneManager.stopRecord();
                    break;

                case "3":
                    dictaphoneManager.showList();
                    break;

                case "4":
                    System.out.println("Введите название:");
                    dictaphoneManager.startPlay(command.nextLine());
                    break;

                case "5":
                    dictaphoneManager.stopPlay();

                    break;

                case "6":
                    System.out.println("Введите название:");
                    dictaphoneManager.deleteRecord(command.nextLine());
                    break;

                case "0":
                    System.out.println("Приложение закрыто");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Некорректная команда");
                    System.out.println(dictaphoneManager.commands());
                    break;
            }
        }


    }
}
