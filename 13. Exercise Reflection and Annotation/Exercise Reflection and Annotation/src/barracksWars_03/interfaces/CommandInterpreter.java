package barracksWars_03.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
