package sundayrealty.restwebservices.common;

/**
 * Created by admin121 on 12/10/15.
 */

public enum MethodsEnum {
    AgentContactCount("AgentContactCount");
    private String methodName;

    MethodsEnum(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }


}
