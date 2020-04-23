package concepts.idioms.demo._01_bean;


public class Person {
    private final String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer currentAge) {
        this.age = currentAge;
    }
}

