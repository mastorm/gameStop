package lc.storm;

import lc.storm.store.*;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        File[] roots = File.listRoots();

        try {
            pickFile(roots);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    public static void pickFile(File[] files) throws IOException {
        System.out.println("");
        for(int i = 0; i < files.length; i++) {
            System.out.println((i + 1) + ": "+files[i].getPath());
        }
        System.out.println("");
        int choice = getChoiceFromStdin();
        File chosenFile = files[choice - 1];
        if(chosenFile.isFile()) {
            // read file contents if txt
            System.out.println("File contents:");
            printFileContents(chosenFile);
        }
        else {
            pickFile(Objects.requireNonNull(chosenFile.listFiles()));
        }
    }

    private static void printFileContents(File f) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(f));
        for(String line = fileReader.readLine(); line != null; line = fileReader.readLine()) {
            System.out.println(line);
        }
    }

    public static int getChoiceFromStdin() throws IOException {
        System.out.print("Bitte wählen Sie einen Ordner oder eine Datei: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = Integer.parseInt(br.readLine());
        return result;
    }

}
