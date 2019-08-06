package demo._01_bean;


public class Person {
    private final Integer age;
    private String name;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public Integer getAge() {
        return age;
    }
}

