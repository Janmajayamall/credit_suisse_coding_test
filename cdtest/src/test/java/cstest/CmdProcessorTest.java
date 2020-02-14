package cstest;

import static org.junit.Assert.*;
import org.junit.Test;
// import org.junit.internal.runners.statements.ExpectException;
import java.util.Arrays;

import cstest.CmdProcessor;


public class CmdProcessorTest{

    @Test
    public void getCanvas(){
        CmdProcessor cmd = new CmdProcessor();
        String[] inp = {"C", "20", "4"};
        cmd.input_process(inp);
        
        char[][] expected_val  = {{'-','-','-','-','-', '-','-','-','-','-', '-','-','-','-','-', '-','-','-','-','-', '-', '-'},
                                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', ' ', ' ','|'},
                                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', ' ', ' ','|'},
                                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', ' ', ' ','|'},
                                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', ' ', ' ','|'},
                                    {'-','-','-','-','-', '-','-','-','-','-', '-','-','-','-','-', '-','-','-','-','-', '-', '-'}};           
        assertEquals(Arrays.deepToString(cmd.getCanvas().canvas_shape), Arrays.deepToString(expected_val));
    }

    
    @Test (expected = IllegalArgumentException.class)
    public void testCreate(){
        CmdProcessor cmd = new CmdProcessor();
        String[] inp = {"C", "1"};
        cmd.input_process(inp);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testLine(){
        CmdProcessor cmd = new CmdProcessor();
        String[] inp = {"l", "1", "3", "1"};
        cmd.input_process(inp);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testRectangle(){
        CmdProcessor cmd = new CmdProcessor();
        String[] inp = {"r", "1", "2", "1"};
        cmd.input_process(inp);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testFill(){
        CmdProcessor cmd = new CmdProcessor();
        String[] inp = {"B", "4"};
        cmd.input_process(inp);

    }

}
