package ru.job4j.tracker;

/*
 * Выход из программы.
 * @author Dmitrii K
 */
public class Exit implements UserAction {
    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
