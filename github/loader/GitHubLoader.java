/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package github.loader;


import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author orangsan
 */
public class GitHubLoader {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        String url2 = "https://github.com/";
        //заменить на свой
        String projectPath = "/home/orangsan/GitHubLoader/";
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите пользователя(или команду): ");
        
        //team or user
        if(sc.hasNextLine()) { 
           String repo = sc.nextLine();
           url2 += repo;
        } else {
          System.out.println("Ошибка ввода");
        }
        System.out.print("Введите название проекта: ");
        if(sc.hasNextLine()) { 
           String project = sc.nextLine();
           url2 += "/" + project;
           projectPath += project + ".zip";
        } else {
          System.out.println("Ошибка ввода");
        }        
        
        url2 += "/archive/master.zip";
        
        System.err.println(projectPath);
        try {
            // качаем файл с помощью Stream
            downloadUsingStream(url2, projectPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    // качаем файл с помощью Stream
    private static void downloadUsingStream(String urlStr, String file) throws IOException{
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }
 
   
   
    
}
