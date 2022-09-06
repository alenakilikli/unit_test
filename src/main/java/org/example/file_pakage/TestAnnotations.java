package org.example.file_pakage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.annotations.FileResource;
import org.example.annotations.JsonResource;
import org.example.annotations.XmlResource;


public class TestAnnotations {
    @FileResource(value = "", nullIfError = true)
    private String data;
    @JsonResource(value = "path/to/file", nullIfError = true)
    private Employee employee;
    @XmlResource(value = "path/to/file", nullIfError = true)
    private Employee employee2;
}

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

class Employee {
    private String name;
    private String surname;
    private double salary;
    private String position;
}
