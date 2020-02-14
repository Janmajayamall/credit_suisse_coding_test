package cstest;

import java.util.Scanner;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        
        CmdProcessor cmd_processor = new CmdProcessor();

        try (Scanner scanner = new Scanner(System.in)){
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                String[] commands = line.split("\\s+");
                try {
                    cmd_processor.input_process(commands);
                    Commands command = cmd_processor.getCanvas();
                    if (command != null) {
                        command.render();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }catch (Exception e) {
			e.printStackTrace();
		}
    }
}
