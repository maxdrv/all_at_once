package idea.examples.livetemplate;

import org.junit.jupiter.api.Test;

class BuildInTempleatesDemo {

    public static final int TIME_OUT = 100;

    @Test
    void soutv() {
        String var = "test";

        // enter soutv to generate
        System.out.println("var = " + var);
    }

    public void soutp(String param, String secondParam) {
        // enter soutp to create out.println with parameters from method
        System.out.println("param = [" + param + "], secondParam = [" + secondParam + "]");
    }

    @Test
    void soutm() {
        System.out.println("BuildInTempleatesDemo.soutm");
    }


}
