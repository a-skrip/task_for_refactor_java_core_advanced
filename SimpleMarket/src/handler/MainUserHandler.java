package handler;

import service.ItemsService;

import java.util.Scanner;

public class MainUserHandler {
    private static final String LOAD_COMMAND = "/load";
    private static final String REMOVE_COMMAND = "/remove";
    private static final String GET_ALL_COMMAND = "/getAll";
    private static final String CHANGE_COMMAND = "/change";
    private static final String EXIT_COMMAND = "/exit";
    private static final String COMMAND_NOT_FOUND = "Такой команды не существует";

    private final ItemsService itemsService = new ItemsService();

    public void startHandleInput() {
        boolean isExit = false;

        while (!isExit) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();

            switch (input) {
                case LOAD_COMMAND: {
                    itemsService.loadItem();
                    break;
                }
                case REMOVE_COMMAND: {
                    itemsService.remove();
                    break;
                }
                case GET_ALL_COMMAND: {
                    itemsService.getAll();
                    break;
                }
                case CHANGE_COMMAND: {
                    itemsService.change();
                    break;
                }
                case EXIT_COMMAND: {
                    isExit = true;
                    break;
                }
                default: {
                    System.out.println(COMMAND_NOT_FOUND);
                    break;
                }
            }
        }
    }
}
