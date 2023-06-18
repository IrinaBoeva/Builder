public class PersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String city;


    public String getName() {
        return name;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public int getAge() {
        return age;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 130) {
            throw new IllegalArgumentException(
                    "Недопустимый возраст. Возраст должен быть от 0 до 130, а у вас: " + age);
        } else this.age = age;
        return this;
    }

    public String getAddress() {
        return city;
    }

    public PersonBuilder setAddress(String city) {
        this.city = city;
        return this;
    }

    public Person build() {
        if (name == null) {
            throw new IllegalStateException(
                    "Не хватает обязательных полей. Имя является обязательным полем, а вы его не заполнили");
        }
        if (surname == null) {
            throw new IllegalStateException(
                    "Не хватает обязательных полей. Фамилия является обязательным полем, а вы его не заполнили");
        }
        Person person;
        if (age == -1) {
            person = new Person(name, surname);
        } else {
            person = new Person(name, surname, age);
        }
        //if (city != null) {
        person.setAddress(city);
        //}
        return person;
    }

    //public PersonBuilder newChildBuilder() {
    //  return new PersonBuilder().setSurname(surname).setAddress(city);
    //}
}
