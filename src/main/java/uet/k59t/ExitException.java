package uet.k59t;

import org.springframework.boot.ExitCodeGenerator;

/**
 * Created by Long on 11/20/2016.
 */
public class ExitException extends RuntimeException implements ExitCodeGenerator {

    @Override
    public int getExitCode() {
        return 10;
    }

}