package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameLnAndPriorityAndName() {
        Comparator<Job> cmpNamePriority = new JobDescByNameLn().thenComparing(new JobDescByPriority()
                .thenComparing(new JobDescByName()));
        int rsl = cmpNamePriority.compare(
                new Job("First example", 0),
                new Job("New example", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByName() {
        Comparator<Job> cmpNamePriority = new JobSortByName();
        int rsl = cmpNamePriority.compare(
                new Job("Have to be second", 0),
                new Job("Be first", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByPriority() {
        Comparator<Job> cmpNamePriority = new JobSortByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Have to be second", 100),
                new Job("Be first", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByName();
        int rsl = cmpNamePriority.compare(
                new Job("Have to be second", 100),
                new Job("Be first", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByPriorityDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Have to be second", 100),
                new Job("Be first", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}
