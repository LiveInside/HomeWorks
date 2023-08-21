package org.homeworks;

import org.homeworks.collections.HomeWorkGenerics;
import org.homeworks.collections.HomeWorkTests;
import org.homeworks.collections.HomeWorksStreams;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        String[] emails = {
                "info@gmail.com",
                "info@yandex.ru",
                "mk@host.com",
                "support@hexlet.io",
                "info@hotmail.com",
                "support.yandex.ru@host.com"
        };

        List<String> emailsList = Arrays.asList(emails);
        System.out.println(HomeWorksStreams.getCountOfFreeEmails(emailsList));
    }
}
