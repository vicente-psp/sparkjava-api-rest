package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Student {

    private int id;
    private String name;
    private Date dateOfBirth;
    private Date creationDate;
    private String enrollment;
    private Date updateDate;

}
