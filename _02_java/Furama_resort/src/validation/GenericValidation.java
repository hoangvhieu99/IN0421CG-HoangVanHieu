package validation;

public interface GenericValidation<T> {
    public T validate(T t) throws Exception;

    public boolean nameValidate(String name);

    public boolean idValidate(String id);

    public boolean areaValidate(int area);

    public  boolean costValidate(int cost);

    public boolean maxPersonValidate(int maxPerson);

    public boolean typeValidate(String type);

    public boolean roomStandartValidate(String roomStandart);

    public boolean accompaniedService(String accompaniedService);


    public boolean numberOfFloorsValidate(int numberOfFloors);

}
