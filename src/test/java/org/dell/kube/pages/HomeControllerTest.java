package org.dell.kube.pages;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HomeControllerTest {
    @Test
    public void itSaysYellowPagesHello() throws Exception {
        HomeController controller = new HomeController("YellowPages");

        assertThat(controller.getPage()).contains("YellowPages");
    }

}
