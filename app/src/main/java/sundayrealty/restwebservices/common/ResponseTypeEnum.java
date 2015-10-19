package sundayrealty.restwebservices.common;

/**
 * Created by admin121 on 12/10/15.
 */

public enum ResponseTypeEnum {
    SUCCESS(1, "success"), ERROR(2, "error");
    private int id;
    private String name;

    ResponseTypeEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
