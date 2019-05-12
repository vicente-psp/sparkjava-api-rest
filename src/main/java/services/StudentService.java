package services;

import entities.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private int idMax = 0;

    private List<Student> students = new ArrayList<>();

    public Student save(Student student) {
        generateId();
        student.setId(idMax);
        students.add(student);
        return student;
    }
    
    public Student update(Student student, int id) {
        remove(id);
        students.add(student);
        return student;
    }
    
    public void remove(int id) {
        students.removeIf(item -> item.getId() == id);
    }

    public List<Student> listAll() {
        return students;
    }

    private void generateId() {
        students.forEach(item -> {
            if (item.getId() > idMax) {
                idMax = item.getId();
            }
        });
    }

}
