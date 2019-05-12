package resources;

import services.StudentService;

import static spark.Spark.*;

public class StudentResource {


    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        get("/students", (req, res) -> {
            return studentService.listAll();
        });
    }

}
