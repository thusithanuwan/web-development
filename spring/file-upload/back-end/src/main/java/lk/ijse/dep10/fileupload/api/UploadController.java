package lk.ijse.dep10.fileupload.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/uploads")
public class UploadController {

    //http://localhost:8080/gallery/uploads

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void saveImage(@RequestPart("image") Part imageFile) throws IOException {
        File newDir= new File("/home/thusitha/Desktop/upload");
        if(!newDir.exists()) newDir.mkdir(); /* ! Difference between mkdir() and mkdirs() ? */
//        File desktopDir = new File(System.getProperty("user.home"), "Desktop");
        File imagePath = new File(newDir, imageFile.getSubmittedFileName());
        imageFile.write(imagePath.getAbsolutePath());


    }
}
