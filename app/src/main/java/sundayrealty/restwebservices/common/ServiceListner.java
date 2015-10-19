package sundayrealty.restwebservices.common;

public interface ServiceListner<T> {

    void onResponse(T obj, ResponseTypeEnum status);

}
