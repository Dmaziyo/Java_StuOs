package data;



public class Student {
    private int id;
    private String name;
    private String gender;
    private String number;



    private String age;


    public Student(String name, String gender, String number, String age) {
        this.name = name;
        this.gender = gender;
        this.number = number;
        this.age = age;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }




    public Object[] getAllData(){
        Object[] ret=new Object[]{name,gender,number,age};
        return ret ;
    }
}
