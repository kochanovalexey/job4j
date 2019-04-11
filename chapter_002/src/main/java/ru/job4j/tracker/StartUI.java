package ru.job4j.tracker;

/**
 * Class Класс StartUI
 *
 * @author akochanov
 * @version 1
 * @since 10.04.2019
 */
public class StartUI {

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа меню для показа всех заявок.
     */
    private static final String SHOW = "1";

    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";

    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";

    /**
     * Константа меню для поиска заявки по индексу.
     */
    private static final String FINDBYID = "4";

    /**
     * Константа меню для поиска заявки по имени.
     */
    private static final String FINDBYNAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showAllItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDBYID.equals(answer)) {
                this.findItemByID();
            } else if (FINDBYNAME.equals(answer)) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        this.tracker.add(item);
<<<<<<< HEAD
        String text = String.format("------------ Новая заявка с getId : %s -----------", item.getId());
        System.out.println(text);
=======
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
>>>>>>> origin/master
    }

    /**
     * Метод показывает все заявки в хранилище.
     */
    private void showAllItems() {
        Item[] items = this.tracker.findAll();
        System.out.println("------------ Список всех заявок ------------");
        for (Item item : items) {
<<<<<<< HEAD
            String idText = String.format("ID: %s", item.getId());
            String nameText = String.format("Name: %s", item.getName());
            String descText = String.format("Description: %s", item.getDecs());
            System.out.println(idText);
            System.out.println(nameText);
            System.out.println(descText);
=======
            System.out.println("ID: " + item.getId());
            System.out.println("Name: " + item.getName());
            System.out.println("Description: " + item.getDecs());
>>>>>>> origin/master
            System.out.println();
        }
    }

    /**
     * Мтоед реализует редактирование существующей заявки в хранилище.
     */
    private void editItem() {
        System.out.println("------------ Редактирование заяки ------------");
        String id = this.input.ask("Введите id заявки для редактирования");
        String name = this.input.ask("Введите название заявки");
        String desc = this.input.ask("Введите описание заявки");
        Item item = new Item(name, desc, System.currentTimeMillis());
        boolean result = this.tracker.replace(id, item);
        if (result) {
<<<<<<< HEAD
            String text = String.format("------------ Заявка с id : %s отредактирована ------------", id);
            System.out.println(text);
        } else {
            String text = String.format("------------ Заявка с id: %s не найдена ------------", id);
            System.out.println(text);
=======
            System.out.println("------------ Заявка с id " + id + " отредактирована ------------");
        } else {
            System.out.println("------------ Заявка с id " + id + " не найдена ------------");
>>>>>>> origin/master
        }
    }

    /**
     * Метод реализует удаление существующей заявки в хранилище.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки для удаления");
        boolean result = this.tracker.delete(id);
        if (result) {
<<<<<<< HEAD
            String text = String.format("------------ Заявка с id: %s удалена ------------", id);
            System.out.println(text);
        } else {
            String text = String.format("------------ Заявка с id: %s не найдена ------------", id);
            System.out.println(text);
=======
            System.out.println("------------ Заявка с id " + id + " удалена ------------");
        } else {
            System.out.println("------------ Заявка с id " + id + " не найдена ------------");
>>>>>>> origin/master
        }
    }

    /**
     * Метод реализует поиск заявки по id в хранилище.
     */
    private void findItemByID() {
        System.out.println("------------ Поиск заявки по id --------------");
        String id = this.input.ask("Введите id заявки для поиска");
        Item item = this.tracker.findById(id);
        if (item != null) {
<<<<<<< HEAD
            String nameText = String.format("Name: %s", item.getName());
            String descText = String.format("Description: %s", item.getDecs());
            System.out.println(nameText);
            System.out.println(descText);
        } else {
            String text = String.format("------------ Заявка с id: %s не найдена ------------", id);
            System.out.println(text);
=======
            System.out.println("Name: " + item.getName());
            System.out.println("Description: " + item.getDecs());
        } else {
            System.out.println("------------ Заявка с id " + id + " не найдена ------------");
>>>>>>> origin/master
        }
    }

    /**
     * Метод реализует поиск заявок по имени в хранилище.
     */
    private void findItemByName() {
        System.out.println("------------ Поиск заявок по имени --------------");
        String name = this.input.ask("Введите имя заявок для поиска");
        Item[] items = this.tracker.findByName(name);
        if (items.length != 0) {
            for (Item item : items) {
<<<<<<< HEAD
                String idText = String.format("ID: %s", item.getId());
                String nameText = String.format("Name: %s", item.getName());
                String descText = String.format("Description: %s", item.getDecs());
                System.out.println(idText);
                System.out.println(nameText);
                System.out.println(descText);
                System.out.println();
            }
        } else {
            String text = String.format("------------ Заявки с именем %s не найдены ------------", name);
            System.out.println(text);
=======
                System.out.println("ID: " + item.getId());
                System.out.println("Name: " + item.getName());
                System.out.println("Description: " + item.getDecs());
                System.out.println();
            }
        } else {
            System.out.println("------------ Заявки с именем " + name + " не найдены ------------");
>>>>>>> origin/master
        }
    }

    /**
     * Метод выводит меню.
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Добавить новую заявку");
        System.out.println("1. Показать все заявки");
        System.out.println("2. Редактировать заявку");
        System.out.println("3. Удалить заявку");
        System.out.println("4. Найти заявку по ID");
        System.out.println("5. Найти заявку по имени");
        System.out.println("6. Выйти из программы");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
