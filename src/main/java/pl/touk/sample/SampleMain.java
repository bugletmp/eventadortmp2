package pl.touk.sample;

import io.vavr.control.Try;
import pl.touk.nussknacker.engine.process.runner.FlinkProcessMain;

import java.util.Arrays;
import java.util.Base64;

public class SampleMain {
    public static void main(String[] args) {
        FlinkProcessMain.main(
                Arrays.stream(args)
                        .map(it -> Try.of(() -> new String(Base64.getDecoder().decode(it))).getOrElse(it))
                        .toArray(String[]::new)
        );
    }
}
