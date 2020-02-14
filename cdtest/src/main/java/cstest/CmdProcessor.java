package cstest;

public class CmdProcessor{

    private Commands command;

    public void input_process(String[] input) {
        
       
        
        switch (input[0].toUpperCase()) {
            case "C":
                if (input.length != 3) {
                    throw new IllegalArgumentException("More parameters expected. For example: C 20 4");
                }
                create_canvas(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                break;
            case "L":
                if (command == null ){
                    throw new IllegalArgumentException("Before execution of any other command, please create a canvas");
                }
                if (input.length != 5) {
                    throw new IllegalArgumentException("More parameters expected. For example: L 1 2 6 2");
                }
                draw_line(Integer.parseInt(input[1]),Integer.parseInt(input[2]),Integer.parseInt(input[3]),Integer.parseInt(input[4]));
                break;
            case "R":
                if (command == null ){
                    throw new IllegalArgumentException("Before execution of any other command, please create a canvas");
                }
                if (input.length != 5) {
                    throw new IllegalArgumentException("More parameters expected. For example: R 14 1 18 3");
                }
                draw_rect(Integer.parseInt(input[1]),Integer.parseInt(input[2]),Integer.parseInt(input[3]),Integer.parseInt(input[4]));
                break;
            case "B":
                if (command == null ){
                    throw new IllegalArgumentException("Before execution of any other command, please create a canvas");
                }
                if (input.length != 4) {
                    throw new IllegalArgumentException("More parameters expected. For example: B 10 3 o");
                }
                draw_fill(Integer.parseInt(input[1]),Integer.parseInt(input[2]), input[3].charAt(0));
                break;
            case "Q":
                System.exit(0);

        }
    }

    

    private void draw_fill(int x, int y, char color) {
        char ref = command.coordVal(x, y);
        command.fillColor(x, y, ref, color);
    }

    private void draw_rect(int x1, int y1, int x2, int y2) {
        command.drawRect(x1, y1, x2, y2);
    }

    private void draw_line(int x1, int y1, int x2, int y2) {
        command.drawLine(x1, y1, x2, y2);
    }

    private void create_canvas(int width, int height) {
        
        command = new Commands(width, height);
    }
    
    public Commands getCanvas() {
        return command;
    }

}