package software.ulpgc.moneycalc.Commands;

import java.io.IOException;

public interface Command {
    void execute() throws IOException;
}
