package org.example.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperateJSON implements FileOperate{

    private String fileName;

    public FileOperateJSON(String fileName){
        this.fileName = fileName;
        try (FileWriter writer = new FileWriter(fileName, true)){
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String readText(){
        List<String> lines = new ArrayList<>();
        String result = "";
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            if (line != null){
                line = reader.readLine();
            }
            while (line != null) {
                line = reader.readLine();
                if (line != null) {
                    lines.add(line);
                }
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        result = String.join("\n", lines);

        return result;
    }

    @Override
    public void saveText(String text) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
