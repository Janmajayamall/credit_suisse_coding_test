package cstest;

import static org.junit.Assert.*;
import org.junit.Test;
// import org.junit.internal.runners.statements.ExpectException;
import java.util.Arrays;

import cstest.Commands;;


public class CommandsTest{
    
    @Test
    public void testConstructor(){
        Commands commands = new Commands(20, 4);

        char[][] expected_val  = {{'-','-','-','-','-', '-','-','-','-','-', '-','-','-','-','-', '-','-','-','-','-', '-', '-'},
                                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', ' ', ' ','|'},
                                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', ' ', ' ','|'},
                                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', ' ', ' ','|'},
                                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', ' ', ' ','|'},
                                    {'-','-','-','-','-', '-','-','-','-','-', '-','-','-','-','-', '-','-','-','-','-', '-', '-'}};           
    
        assertEquals(Arrays.deepToString(commands.canvas_shape), Arrays.deepToString(expected_val));
    }

    @Test
    public void testDrawLine(){
        Commands commands = new Commands(20, 4);
        commands.drawLine(1, 2, 6, 2);

        char[][] expected_val  = {{'-','-','-','-','-', '-','-','-','-','-', '-','-','-','-','-', '-','-','-','-','-', '-', '-'},
                                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', ' ', ' ','|'},
                                    {'|', 'x', 'x', 'x', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', ' ', ' ','|'},
                                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', ' ', ' ','|'},
                                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', ' ', ' ','|'},
                                    {'-','-','-','-','-', '-','-','-','-','-', '-','-','-','-','-', '-','-','-','-','-', '-', '-'}};           
    
        assertEquals(Arrays.deepToString(commands.canvas_shape), Arrays.deepToString(expected_val));
    }

    @Test
    public void testDrawRectangle(){
        Commands commands = new Commands(20, 4);
        commands.drawLine(1, 2, 6, 2);
        commands.drawRect(14, 1, 18, 3);

        char[][] expected_val  = {{'-','-','-','-','-', '-','-','-','-','-', '-','-','-','-','-', '-','-','-','-','-', '-', '-'},
                                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x','x', 'x', 'x', ' ', ' ','|'},
                                    {'|', 'x', 'x', 'x', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ',' ', ' ', 'x', ' ', ' ','|'},
                                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x','x', 'x', 'x', ' ', ' ','|'},
                                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', ' ', ' ','|'},
                                    {'-','-','-','-','-', '-','-','-','-','-', '-','-','-','-','-', '-','-','-','-','-', '-', '-'}};           
    
        assertEquals(Arrays.deepToString(commands.canvas_shape), Arrays.deepToString(expected_val));
    }

    @Test
    public void testFill(){
        Commands commands = new Commands(20, 4);
        commands.drawLine(1, 2, 6, 2);
        commands.drawLine(6, 3, 6, 4);
        commands.drawRect(14, 1, 18, 3);
        commands.fillColor(10, 3, commands.canvas_shape[3][10], 'o');

        char[][] expected_val  = {{'-','-','-','-','-', '-','-','-','-','-', '-','-','-','-','-', '-','-','-','-','-', '-', '-'},
                                    {'|', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x','x', 'x', 'x', 'o', 'o','|'},
                                    {'|', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', ' ',' ', ' ', 'x', 'o', 'o','|'},
                                    {'|', ' ', ' ', ' ', ' ', ' ', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x','x', 'x', 'x', 'o', 'o','|'},
                                    {'|', ' ', ' ', ' ', ' ', ' ', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o','o', 'o', 'o', 'o', 'o','|'},
                                    {'-','-','-','-','-', '-','-','-','-','-', '-','-','-','-','-', '-','-','-','-','-', '-', '-'}};           
    
        assertEquals(Arrays.deepToString(commands.canvas_shape), Arrays.deepToString(expected_val));
    }


}
