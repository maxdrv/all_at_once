package idea.examples.livetemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class SurroundTemplates {

    public static Callable<String> getCallableObj() {
        // select line of code and enter ctrl + alt + j
        //
        // List<String> seasons = Arrays.asList("Summer", "Winter", "Spring");

        Callable<String> callable = new Callable<String>() {
            public String call() throws Exception {
                List<String> seasons = Arrays.asList("Summer", "Winter", "Spring");
                return seasons.get(new Random().nextInt(3));
            }
        };
        return callable;
    }

    public static Callable<String> getCallableWithLambdas() {
        Callable<String> callable = () -> {
            List<String> seasons = Arrays.asList("Summer", "Winter", "Spring");
            return seasons.get(new Random().nextInt(3));
        };
        return callable;
    }

}
