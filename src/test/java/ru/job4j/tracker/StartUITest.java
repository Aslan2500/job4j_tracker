package ru.job4j.tracker;

import org.junit.Test;

import java.time.format.DateTimeFormatter;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUITest {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    private LocalDateTime created = LocalDateTime.now();

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        UserAction[] actions = new UserAction[]{
                new ReplaceAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Replace Item" + ln
                        + "1. Exit" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Replace Item" + ln
                        + "1. Exit" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindAllItemTestOutputIsNotSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new ShowAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Show all Items" + ln
                        + "1. Exit" + ln
                        + "=== Show all items ===" + ln
                        + "Хранилище еще не содержит заявок" + ln
                        + "Menu:" + ln
                        + "0. Show all Items" + ln
                        + "1. Exit" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindAllItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new ShowAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Show all Items" + ln
                        + "1. Exit" + ln
                        + "=== Show all items ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Show all Items" + ln
                        + "1. Exit" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindByIdItemTestOutputIsNotSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find Item by it's id" + ln
                        + "1. Exit" + ln
                        + "=== Find item by id ===" + ln
                        + "Заявка с введенным id: 1 не найдена." + ln
                        + "Menu:" + ln
                        + "0. Find Item by it's id" + ln
                        + "1. Exit" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindByIdItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find Item by it's id" + ln
                        + "1. Exit" + ln
                        + "=== Find item by id ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find Item by it's id" + ln
                        + "1. Exit" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindByNameItemTestOutputIsNotSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0", "test1", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByNameAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find Item by it's name" + ln
                        + "1. Exit" + ln
                        + "=== Find items by name ===" + ln
                        + "Заявки с именем: test1 не найдены." + ln
                        + "Menu:" + ln
                        + "0. Find Item by it's name" + ln
                        + "1. Exit" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindByNameItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", "test1", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByNameAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find Item by it's name" + ln
                        + "1. Exit" + ln
                        + "=== Find items by name ===" + ln
                        + "Item{id = 1, name = 'test1' created = " + created.format(FORMATTER) + "}" + ln
                        + "Menu:" + ln
                        + "0. Find Item by it's name" + ln
                        + "1. Exit" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"20", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu:" + ln
                                + "0. Exit" + ln
                                + "Wrong input, you can select: 0 .. 0" + ln
                                + "Menu:" + ln
                                + "0. Exit" + ln
                                + "=== Exit Program ===" + ln
                )
        );
    }
}

