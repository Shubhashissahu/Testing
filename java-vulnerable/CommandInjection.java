import java.io.*;

public class CommandInjection {


    public static void main(String[] args) {


        String filename = args[0];


        try {


            // Vulnerable command execution

            String command = "cat " + filename;


            Runtime runtime = Runtime.getRuntime();

            Process process =
                runtime.exec(command);



            BufferedReader reader =
                new BufferedReader(
                    new InputStreamReader(
                        process.getInputStream()
                    )
                );


            String line;


            while((line = reader.readLine()) != null){

                System.out.println(line);

            }


        }
        catch(Exception e){

            e.printStackTrace();

        }

    }
}