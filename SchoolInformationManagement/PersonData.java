package SchoolInformationManagement;

import java.io.Serializable;

@SuppressWarnings("ALL")
public class PersonData implements Serializable {
    private static final long serialVersionUID = -843543327360974269L;
    private String modifiedDate;
    private String name;
    private String gender;
    private int age;
    private long id;

    public PersonData(String modifiedDate, String name, String gender, int age, long id) {
        this.modifiedDate = modifiedDate;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.id = id;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    static class Teacher extends PersonData implements Serializable {
        private static final long serialVersionUID = 180198508616430297L;
        private String type;

        public Teacher(String dateCreated, String name, String gender, int age, long id, String type) {
            super(dateCreated, name, gender, age, id);
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    static class Student extends PersonData implements Serializable {
        private static final long serialVersionUID = -4172426580781334308L;
        private String job;

        public Student(String dateCreated, String name, String gender, int age, long id, String job) {
            super(dateCreated, name, gender, age, id);
            this.job = job;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }
    }
}