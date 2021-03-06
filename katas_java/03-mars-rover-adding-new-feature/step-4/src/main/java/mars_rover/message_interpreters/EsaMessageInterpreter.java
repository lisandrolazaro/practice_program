package mars_rover.message_interpreters;

import mars_rover.Command;
import mars_rover.message_interpreters.command_types.*;

import java.util.ArrayList;
import java.util.List;

public class EsaMessageInterpreter implements mars_rover.MessageInterpreter {

    private static final int MOVEMENT_DELTA = 1;

    @Override
    public List<Command> createCommands(String message) {
        List<Command> commands = new ArrayList<>();
        for (String commandRepresentation : parseMessage(message)) {
            commands.add(createCommand(commandRepresentation));
        }
        return commands;
    }

    private String[] parseMessage(String message) {
        return message.split("");
    }

    private Command createCommand(String commandRepresentation) {

        if (commandRepresentation.equals("l")) {
            return new TurningRight();
        } else if (commandRepresentation.equals("f")) {
            return new TurningLeft();
        } else if (commandRepresentation.equals("b")) {
            return new MovingForward(MOVEMENT_DELTA);
        } else if (commandRepresentation.equals("x")) {
            return new MovingBackwards(MOVEMENT_DELTA);
        } else {
            return new UnknownCommand();
        }
    }
}
