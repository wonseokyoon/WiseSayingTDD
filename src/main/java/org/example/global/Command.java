package org.example.global;

public class Command {
    // 쪼개기 작업

    String actionName;
    public Command(String cmd){
        String[] cmdBits=cmd.split("\\?");
        actionName=cmdBits[0];

    }

    public String getActionName() {
        return actionName;
    }
}
