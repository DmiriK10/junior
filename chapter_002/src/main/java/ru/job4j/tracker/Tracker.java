package ru.job4j.tracker;

import java.util.Arrays;

//8. Что такое валидация? [#246864]
public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    //  добавление нового item
    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    //  получение списка всех item
    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    //  поиск item по id
    public Item findById(int id) {
        //* Находим индекс *//*
        int index = indexOf(id);
        //* Если индекс найден возвращаем item, иначе null *//*
        return index != -1 ? items[index] : null;
    }

    //  метод  возвращает index по id.
    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод реализует замену заявку. по id.
     * @param id номер заявки;
     * @param item новая заявка;
     * @return result результат выполнения операции.
     */
    public boolean replace(int id, Item item) {
        if (id <= 0) {
            System.out.println("Некорректный параметр id " + id + "!");
            return false;
        }
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);         // устанавливаем добавляемой заявке id, чтобы мы потом смогли ее найти
            items[index] = item;    // делаем вставку0
        } else {
            rsl = false;
        }

        return rsl;
    }

    //  получение списка по имени
    public Item[] findByName(String name) {
        Item[] itemsWithoutNull = new Item[this.items.length];
        int count = 0;
        for (int i = 0; i < size; i++) {
            Item item = this.items[i];
            if (item.getName().equals(name)) {
                itemsWithoutNull[count] = this.items[i];
                System.out.println(itemsWithoutNull[count].getName());
                count++;
            }
        }
        return Arrays.copyOf(itemsWithoutNull, count);
    }



    /**
     * Метод реализует удаления заявки по id.
     * @param 'id' номер заявки;
     * @return result результат выполнения операции.
     */
    public boolean detele(String name) {
        Item[] itemsFound = findByName(name);
        /* Находим item */
        for (int i = 0; i < size; i++) {
            for (int y = 0; y < itemsFound.length; y++) {
                if (this.items[i].getName().equals(itemsFound[y].getName())) {
                    this.items[i] = null;
                }
            }
        }
        return true;
    }
}





