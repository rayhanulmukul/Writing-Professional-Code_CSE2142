//File Name StudentList.java

import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void showGuideLine() {
        System.out.println(constant.printa);
        System.out.println("r = print random studnt list");
        System.out.println("+x = add studnent with name x in the list");
    }

    public static String getString() {
        String line = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("students.txt")));
            line = bufferedReader.readLine();
            bufferedReader.close();
        } catch (Exception e) {
        }
        return line;
    }

    public static void main(String[] args) {
//		Check arguments
        if (args.length == 0) {
            showGuideLine();
        } else if (args[0].equals("a")) {
            System.out.println("Loading data ...");
                String studntList = getString();
                String stringName[] = studntList.split(", ");
                for (String name : stringName) {
                    System.out.println(name);
                }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("r")) {
            System.out.println("Loading data ...");
                String r = getString();// System.out.println(r);
                String i[] = r.split(", ");
                Random x = new Random();
                int y = x.nextInt(i.length);
                System.out.println(i[y]);
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter s = new BufferedWriter(
                        new FileWriter("students.txt", true));
                String t = args[0].substring(1);
                Date d = new Date();
                String df = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(df);
                String fd = dateFormat.format(d);
                s.write(", " + t + "\nList last updated on " + fd);
                s.close();
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader s = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String r = s.readLine();
                String i[] = r.split(", ");
                String t = args[0].substring(1);
                for (int idx = 0; idx < i.length; idx++) {
                    if (i[idx].equals(t)) {
                        System.out.println("We found it!");
                        break;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
                String line = getString();
                int count = 1;
                for (char c : line.toCharArray()) {
                    if (c == ' ') {
                        count++;
                    }
                }
                System.out.println(count + " word(s) found " + line.length());
            System.out.println("Data Loaded.");
        } else {
            showGuideLine();
        }
    }
}
