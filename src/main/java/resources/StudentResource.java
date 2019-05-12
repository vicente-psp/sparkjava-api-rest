package resources;

import com.google.gson.Gson;
import entities.Student;
import services.StudentService;
import utils.StandardResponse;
import utils.StatusResponse;

import static spark.Spark.*;

public class StudentResource {


    public static void main(String[] args) {

        StudentService studentService = new StudentService();
        final String CONTENT_TYPE = "application/json";

        post("/students", (request, response) -> {
            response.type(CONTENT_TYPE);

            Student student = new Gson().fromJson(request.body(), Student.class);
            student = studentService.save(student);

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(student)));
        });

        get("/students", (request, response) -> {
            response.type(CONTENT_TYPE);

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(studentService.listAll())));
        });

        get("/students/:id", (request, response) -> {
            response.type(CONTENT_TYPE);

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(studentService.findById(Integer.parseInt(request.params(":id"))))));
        });

        put("/students/:id", (request, response) -> {
            response.type(CONTENT_TYPE);

            Student student = new Gson().fromJson(request.body(), Student.class);
            Student editedStudent = studentService.update(student, Integer.parseInt(request.params(":id")));

            if (editedStudent != null) {
                return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(editedStudent)));
            } else {
                return new Gson().toJson(new StandardResponse(StatusResponse.ERROR, new Gson().toJson("Student não encontrado ou com erro na edição")));
            }
        });

        delete("/students/:id", (request, response) -> {
            response.type(CONTENT_TYPE);

            studentService.remove(Integer.parseInt(request.params(":id")));
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, "Estudante deletado"));
        });
        
    }

}
