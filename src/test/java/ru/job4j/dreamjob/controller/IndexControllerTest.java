package ru.job4j.dreamjob.controller;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class IndexControllerTest {
    @Test
    void whenGetIndexThenGetIndexPage() {
        var controller = new IndexController();
        var view = controller.getIndex();
        assertThat(view).isEqualTo("index");
    }
}