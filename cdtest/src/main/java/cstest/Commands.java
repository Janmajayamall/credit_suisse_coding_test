package cstest;

public class Commands {

    protected char[][] canvas_shape;
    protected int width;
    protected int height;

    private static final char HORIZONTAL_EDGE = '-';
    private static final char VERTICAL_EDGE = '|';
    private static final char LINE = 'x';

    public Commands(char[][] shape){
        this.width = shape[0].length;
        this.height = shape.length;
        this.canvas_shape = shape;
    }

    public Commands(int width, int height){
        // checking whether both values are positive
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("ERROR: Width and Height paramteres should be POSITIVE INTEGER");
        }       

        this.width = width+2;
        this.height = height+2;
        this.canvas_shape = new char[this.height][this.width];
        startDrawing();
    }
    public char coordVal(int x, int y){
        return canvas_shape[y][x];
    }

    private void startDrawing(){
        // populating canvas shape with empty values 
        for (int row = 0; row < canvas_shape.length; row++) {
            for (int col = 0; col < canvas_shape[row].length; col++) {
               canvas_shape[row][col] = ' ';
            }
        }

        // drawing the canvas
        drawHorizontalLine(0, 0, width-1, HORIZONTAL_EDGE);
        drawHorizontalLine(height-1, 0, width-1, HORIZONTAL_EDGE);
        drawVerticalLine(0, 1, height-2, VERTICAL_EDGE);
        drawVerticalLine(width-1, 1, height-2, VERTICAL_EDGE);
    }

    public void drawRect(int x1, int y1, int x2, int y2) {

        // Validating the inputs
        checkAllPositive(x1, y1, x2, y2);
        checkHeight(y1, y2);
        checkWidht(x1, x2);

        // Validating given top left and bottom right
        checkLeftRight(y1, y2);
        checkLeftRight(x1, x2);

        drawHorizontalLine(y1, x1, x2, LINE);
        drawHorizontalLine(y2, x1, x2, LINE);
        drawVerticalLine(x1, y1+1, y2-1, LINE);
        drawVerticalLine(x2, y1+1, y2-1, LINE);
    }


    public void drawLine(int x1, int y1, int x2, int y2) {
        
        // validating values
        checkAllPositive(x1, y1, x2, y2);
        checkWidht(y1, y2);
        checkHeight(x1, x2);


        if (x1 == x2) {
            drawVerticalLine(x1, y1, y2, LINE);
        } else if (y1 == y2) {
            drawHorizontalLine(y1, x1, x2, LINE);
        } else {
            throw new IllegalArgumentException("Invalid draw line arguments");
        }
    }

    private void drawHorizontalLine(int y, int begin, int end, char symbol) {
        sketchLine(y, begin, end, symbol, true);
    }

    private void drawVerticalLine(int x, int begin, int end, char symbol) {
        sketchLine(x, begin, end, symbol, false);
    }

    private void sketchLine(int rec_coord, int begin, int end, char p, boolean is_horizontal) {
        if (begin > end) {
            // swap begin and end
            int temp = begin;
            begin = end;
            end = temp;
        }

        for(int i=begin; i<=end; i++) {
            if (is_horizontal) {
                canvas_shape[rec_coord][i] = p;
            } else {
                canvas_shape[i][rec_coord] = p;
            }

        }
    }


    private void checkAllPositive(int... vals) {
        for (int val : vals) {
            if (val <= 0) {
                throw new IllegalArgumentException("Value should be POSITIVE, and greater than 0, but given " + val);
            }
        }
    }

    private void checkHeight(int... vals) {
        for (int val : vals) {
            if (val > this.height) {
                throw new IllegalArgumentException("Value of height out of range. Passed Widht Value: "+val);
            }
        }
    }

    private void checkWidht(int... vals) {
        for (int val : vals) {
            if (val > this.width-2) {
                throw new IllegalArgumentException("Value of width out of range. Passed Widht Value: "+val);
            }
        }
    }

    private void checkLeftRight(int left, int right) {
        if (left >= right) {
            throw new IllegalArgumentException("Coordinates given in rectangle are invalid: (" + left + ", " + right + ")"+ " (Enaure that top left coordinates are smaller than bottom right coordinates)");
        }
    }

    // public int hashCode() {
    //     return Arrays.hashCode(pixels);
    // }

    // public boolean equals(Object o) {
    //     if (this == o) return true;
    //     if (o == null || getClass() != o.getClass()) return false;
    //     CanvasImpl canvas = (CanvasImpl) o;
    //     return Arrays.deepEquals(pixels, canvas.pixels);
    // }

    public void fillColor(int x, int y, char ref, char color){
        if (x<=0 || x>width || y<=0 || y>height || canvas_shape[y][x]!=ref){
            return;
        }

        canvas_shape[y][x]=color;


        fillColor(x+1, y,ref, color);
        fillColor(x-1, y,ref, color);
        fillColor(x, y+1,ref, color);
        fillColor(x, y-1,ref, color);

        return;
    }

    public void render(){

        for (char[] line: canvas_shape){
            for (char val : line){
                System.out.print(val);
            }
            System.out.println();
        }

    }
      
	

    
} 

