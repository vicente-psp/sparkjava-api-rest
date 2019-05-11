package resources;

import static spark.Spark.*;

public class StudentResource {

    public static void main(String[] args) {
        get("/students", (req, res) -> "Hello World");
    }

}
