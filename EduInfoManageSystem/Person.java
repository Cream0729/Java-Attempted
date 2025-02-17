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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static class StudentData extends Person implements Comparable<StudentData> {
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
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            StudentData student = (StudentData) o;
            return this.getId() == student.getId();
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.getId());
        }

        @Override
        public int compareTo(StudentData o) {
            return Long.compare(this.getId(), o.getId());
        }

        @Override
        public String toString() {
            return ("studentData -> {id=" + super.getId() + ", editDate=" + super.getEditDate() + ", name=" + super.getName() + ", gender=" + super.getGender() + ", age=" + super.getAge() + ", job=" + this.job + "}");
        }
    }

    public static class TeacherData extends Person implements Comparable<TeacherData> {
        @Serial
        private static final long serialVersionUID = 5696540458805120006L;
        private String type;
        private String job;

        public TeacherData() {
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
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TeacherData teacher = (TeacherData) o;
            return this.getId() == teacher.getId();
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.getId());
        }

        @Override
        public int compareTo(TeacherData o) {
            return Long.compare(this.getId(), o.getId());
        }

        @Override
        public String toString() {
            return ("teacherData -> {id=" + super.getId() + ", editDate=" + super.getEditDate() + ", name=" + super.getName() + ", gender=" + super.getGender() + ", age=" + super.getAge() + ", type=" + this.type + ", job=" + this.job + "}");
        }
    }
}