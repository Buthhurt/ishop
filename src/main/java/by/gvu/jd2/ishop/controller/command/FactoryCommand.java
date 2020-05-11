package by.gvu.jd2.ishop.controller.command;

import by.gvu.jd2.ishop.bean.define.Define;

import java.util.HashMap;
import java.util.Map;

public class FactoryCommand {
    private static final FactoryCommand instance = new FactoryCommand();

    private Map<String, Command> listCommands = null;

    private FactoryCommand() {
        this.listCommands = new HashMap<String, Command>();
        this.listCommands.put(Define.COMMAND_REGISTRATION, new RegistrationCommand());
        this.listCommands.put(Define.COMMAND_LOGIN, new LoginCommand());
    }

    public static FactoryCommand getInstance(){
        return instance;
    }

    public Command getCommandByName(String commandName){
        return listCommands.get(commandName);
    }
}