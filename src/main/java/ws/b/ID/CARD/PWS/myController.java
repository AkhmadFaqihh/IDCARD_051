/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.b.ID.CARD.PWS;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author mwllf
 */
@Controller
public class myController {

    @RequestMapping("/sendData")
    @ResponseBody
    public String getData(@RequestParam("text") String getText,
            @RequestParam("image") MultipartFile image,
            @RequestParam("date") Date getDate) throws IOException {

        String blob = Base64.encodeBase64String(image.getBytes());

        SimpleDateFormat tanggal = new SimpleDateFormat("EE-dd-MMMM-yyyy");

        String newTanggal = tanggal.format(getDate);
        
        

        return "<div class='squarebox'>\n" +
"            <br><center>Kartu Tanda Penduduk" + "<br>" 
                + "Provinsi Jawa Tengah </center>\n" +
"        <hr/>\n" + 
"        <p> "  + "Nama : " + getText + "</p>" +
"        <p> "  + "Tanggal Lahir : " + newTanggal + "</p>" +
"        <img src= 'data:image/jpeg;Base64," + blob + "' alt=\"Photo confirmation\" id=\"display-image\" ></img>\n" 
          + "<style>.squarebox {"
                + "position: absolute;"
                + "left: 50%;"
                + "top: 50%;"
                + "background: pink;"
                + "overflow: hidden;"
                + "height: 400px;" 
                + "width: 600px;" 
                + "transform: translate(-50%, -50%);"
                + "border-radius: 50px;"
                + "box-shadow: 0 0 20px 8px #pink;"
                + " background-size: cover;" 
                + "background-repeat: no-repeat;}"
                + "hr {"
                + "border: 1px solid white;}"
                + "p {"
                + "text-align: left;"
                + "width: 100%;" 
                + "direction: rtl;" 
                + "padding-left: 30px ;}"
                + "center {" 
                + "font-weight: 900;" 
                + "text-align: center;}"
                + "img {"
                + "padding-right: 30px;"
                + "padding-bottom: 30px;"
                + "width: 200;"
                + "height: 200;"
                + "display: block;"
                + "margin-left: auto;"
                + "}"              
                + "</style>"
                
          ;
        
    }
}
