package services;

import entities.Student;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class StudentService {

    private int id = 0;

    private HashMap<String, Student> studentHashMap = new HashMap<>();;

    public Student save(Student student) {
        student.setId(getNextId());
        student.setCreationDate(new Date());
        studentHashMap.put(String.valueOf(student.getId()), student);
        return student;
    }
    
    public Student update(Student student, int id) {
        Student studentToUpdate = findById(id);

        studentToUpdate.setName(student.getName());
        studentToUpdate.setEnrollment(student.getEnrollment());
        studentToUpdate.setUpdateDate(new Date());

//        studentHashMap.put(String.valueOf(student.getId()), studentToUpdate);
        return studentToUpdate;
    }
    
    public void remove(int id) {
        studentHashMap.remove(String.valueOf(id));
    }

    public Student findById(int id) {
        return studentHashMap.get(String.valueOf(id));
    }

    public Collection<Student> listAll() {
        return studentHashMap.values();
    }


    private int getNextId() {
        return ++this.id;
    }

}
