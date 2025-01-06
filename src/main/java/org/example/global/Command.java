package org.example.global;

public class Command {
    // 쪼개기 작업

    String actionName;
    String paramKey;
    String paramValue;
    public Command(String cmd){
        String[] cmdBits=cmd.split("\\?");
        actionName=cmdBits[0];

        if(cmdBits.length<2){
            paramValue="";
            return;
        }

        String param=cmdBits[1];
        String[] paramBits=param.split("=");
        if(paramBits.length<2){
            paramValue=null;
            return;
        }
        paramKey=paramBits[0];
        paramValue=paramBits[1];

    }

    public String getActionName() {
        return actionName;
    }


    public String getParam() {
        //삭제?id=1

        return paramValue;
    }
}
