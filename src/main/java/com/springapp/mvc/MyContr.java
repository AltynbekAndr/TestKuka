package com.springapp.mvc;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;


@Controller
@RequestMapping
public class MyContr {
    @RequestMapping(value="myjsp",method = RequestMethod.GET)
    public String printWelcome() {

        return "myjsp";
    }

    @ResponseBody
    @RequestMapping(value = "video", method = RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] ourproductsphoto2() throws IOException {
        InputStream in = null;

        String rootPath = "C:\\uploadFile";
        File dir = new File(rootPath + File.separator + "tmpFiles");
        File f = new File(dir.getAbsolutePath() + File.separator + "2.mp4");
        in = new FileInputStream(f);

        return IOUtils.toByteArray(in);
    }


    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody
    String uploadFileHandler(@RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String rootPath = "C:\\uploadFile";  //try also "C:\path\"

                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + file.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                return "You successfully uploaded file=" + file.getName();
            } catch (Exception e) {
                return "You failed to upload " + file.getName() + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + file.getName()
                    + " because the file was empty.";
        }
    }

}
