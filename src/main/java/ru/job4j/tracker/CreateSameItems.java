package ru.job4j.tracker;

public class CreateSameItems implements UserAction {
    private final Output out;

    public CreateSameItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create Items with the same name";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Create Items with the same name ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        for (int i = 0; i < 2000000000; i++) {
            memTracker.add(item);
        }
        return true;
    }
}
