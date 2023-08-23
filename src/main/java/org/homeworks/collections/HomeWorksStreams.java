package org.homeworks.collections;

import java.util.List;

public class HomeWorksStreams {
    public static long getCountOfFreeEmails(final List<String> emailsList) {
        List<String> freeDomains = List.of("gmail.com", "yandex.ru", "hotmail.com");

        return emailsList.stream()
                .filter(email -> freeDomains.stream()
                        .anyMatch(domain -> email.endsWith(domain)))
                .count();
    }
}
