package EduInfoManageSystem;

import java.io.Serial;
import java.util.Objects;
import java.io.Serializable;

public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 363810234157450687L;
    private long id;
    private String editDate;
    private String name;
    private String gender;
    private int age;

    public Person() {
    }

    public Person(long id, String editDate, String name, String gender, int age) {
        this.id = id;
        this.editDate = editDate;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEditDate() {
        return editDate;
    }

    public void setEditDate(String editDate) {
        this.editDate = editDate;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && age == person.age && Objects.equals(editDate, person.editDate) && Objects.equals(name, person.name) && Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public static class StudentData extends Person {
        @Serial
        private static final long serialVersionUID = -716755648051257192L;
        private String job;

        public StudentData() {
        }

        public StudentData(long id, String editDate, String name, String gender, int age, String job) {
            super(id, editDate, name, gender, age);
            this.job = job;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            StudentData student = (StudentData) o;
            return Objects.equals(job, student.job);
        }

        @Override
        public String toString() {
            return "Student{" + "id=" + super.id + ", editDate='" + super.editDate + '\'' + ", name='" + super.name + '\'' + ", gender='" + super.gender + '\'' + ", age=" + super.age + ", job='" + this.job + "'}";
        }
    }

    public static class TeacherData extends Person {
        @Serial
        private static final long serialVersionUID = 5696540458805120006L;
        private String type;
        private String job;

        public TeacherData() {
        }

        public TeacherData(String type, String job) {
            this.type = type;
            this.job = job;
        }

        public TeacherData(long id, String editDate, String name, String gender, int age, String type, String job) {
            super(id, editDate, name, gender, age);
            this.type = type;
            this.job = job;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            TeacherData that = (TeacherData) o;
            return Objects.equals(type, that.type) && Objects.equals(job, that.job);
        }

        @Override
        public String toString() {
            return "TeacherData{" + "id=" + super.id + ", editDate='" + super.editDate + '\'' + ", name='" + super.name + '\'' + ", gender='" + super.gender + '\'' + ", age=" + super.age + ", type='" + type + '\'' + ", job='" + job + '\'' + "'}";
        }
    }
}
