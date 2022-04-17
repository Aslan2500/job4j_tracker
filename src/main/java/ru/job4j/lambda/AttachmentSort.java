package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> compareSize = (o1, o2) -> {
            Attachment left = (Attachment) o1;
            Attachment right = (Attachment) o2;
            return Integer.compare(left.getSize(), right.getSize());
        };

        Comparator<Attachment> compareNames = (o1, o2) -> {
            Attachment l = (Attachment) o1;
            Attachment r = (Attachment) o2;
            return l.getName().compareTo(r.getName());
        };

        attachments.sort(compareSize);
        System.out.println(attachments);

        Comparator<Attachment> comparatorSecond =  new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return left.getName().compareTo(right.getName());
            }
        };
    }
}
