package Seminar3;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadFileFromURL {
    public static void DownloadFile(URL fileUrl, String fileName) {
        try (InputStream input = fileUrl.openStream();
             BufferedInputStream bufferedInputStream = new BufferedInputStream(input);
             FileOutputStream fileOutputStream = new FileOutputStream(fileName)){

            byte[] array = new byte[4096];
            int i;
            while ((i = bufferedInputStream.read(array, 0, 4096)) != -1){
                fileOutputStream.write(array, 0, i);
            }
            System.out.println("File downloaded successfully!");
        }
        catch (IOException e) {
            System.out.println("Error downloading file: " + e.getMessage());
        }
    }
    public static void main(String[] args) throws MalformedURLException {
        String url = "https://cpu.land/editions/printable.pdf";
        String fileName = "printable.pdf";

        URL fileUrl = new URL(url);
        DownloadFile(fileUrl, fileName);
    }
}
