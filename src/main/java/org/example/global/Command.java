package org.example.global;

import java.util.HashMap;
import java.util.Map;

public class Command {
    // 쪼개기 작업

    String actionName;
//    String paramKey;
    // <id,"1">
    Map<String, String> paramMap;
//    String paramValue;
    public Command(String cmd){
        paramMap=new HashMap<>();
        String[] cmdBits=cmd.split("\\?");
        actionName=cmdBits[0];

        if(cmdBits.length<2){
            return;
        }

        //목록?key1=val1&key2=val2
        String queryString=cmdBits[1];
        String[] params=queryString.split("&");
        // key1=val1 , key2=val2

        for(String param:params){
            String[] paramBits=param.split("=",2);
//            paramKey=paramBits[0];

            if(paramBits.length<2){
                continue;
            }

            paramMap.put(paramBits[0],paramBits[1]);
//            paramValue=paramBits[1];
        }


    }

    public String getActionName() {
        return actionName;
    }


    public String getParam(String key) {
        //삭제?id=1
        return paramMap.get(key);
    }

    public int getParamAsInt(String key) {

        try{
            String param=paramMap.get(key);
            return Integer.parseInt(param);
        }catch (NullPointerException e){
            return 0;
        }
    }

}
