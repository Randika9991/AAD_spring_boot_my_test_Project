package lk.ijse.demo.controller;
import lk.ijse.demo.entity.Student;
import lk.ijse.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    StudentRepository repository;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        Student addedStudent = repository.save(student);
        return addedStudent;
    }

    @GetMapping
    public List<Student> getStudents() {
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable Integer id) {
        repository.deleteById(id);
        return "Student with ID " + id + " has been deleted successfully";
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student updatedStudent) {

        Student existingStudent = repository.findById(id).orElse(null);

        if (existingStudent != null) {
            existingStudent.setCustName(updatedStudent.getCustName());
            existingStudent.setCustAddress(updatedStudent.getCustAddress());
            existingStudent.setCustSalary(updatedStudent.getCustSalary());
            repository.save(existingStudent);

            return existingStudent;
        } else {
            // If the student with the given ID doesn't exist, return null or handle the error as needed
            return null;
        }
    }

    private final String folderPath = "C:\\Users\\Dulaksha\\Videos\\2nd SEMESTER 1st leson arcitecchur\\AAD\\Spring boot\\UplodedFile";


    @PostMapping("/{addImage}")
    public boolean addImage(@RequestParam("id") Integer id, @RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return false;
            }

            Path filePath = Paths.get(folderPath + File.separator + id + "_" + file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("ID: " + id);

            Student student = repository.findById(id).orElse(null);
            if (student != null) {
                student.setImagePath(filePath.toString());
                repository.save(student);
            }

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private final String folderPath2 = "C:\\Users\\Dulaksha\\Videos\\2nd SEMESTER 1st leson arcitecchur\\AAD\\Spring boot\\UplodedFile\\";


    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable String id) throws IOException {
        try {
            // Read image bytes from file
            byte[] imageBytes = Files.readAllBytes(new File(folderPath2 + id).toPath());

            // Set response headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG); // Set content type as PNG, adjust if needed

            // Return ResponseEntity with image bytes and headers
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(imageBytes);
        } catch (IOException e) {
            // Handle file reading errors
            e.printStackTrace(); // Or log the error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
   }

}