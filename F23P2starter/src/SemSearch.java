
/**
 * {Project Description Here}
 */

/**
 * The class containing the main method.
 *
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 2023-19-09
 */

// On my honor:
// - I have not used source code obtained from another current or
// former student, or any other unauthorized source, either
// modified or unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
// anyone other than my partner (in the case of a joint
// submission), instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.

public class SemSearch {
    /**
     * @param args
     *            Command line parameters
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // This is the main file for the program.
        if (args == null) {
            throw new Exception("No Args");
        }
        int worldSize = Integer.parseInt(args[0]);
        
        
        if (powerOfTwo(worldSize) == false) {
            throw new Exception("World Size Not A Power of 2");
        }
        String file = args[1];
        new FileReader(worldSize, file);
    }


    /**
     * 
     * Checks whether or not the memory and hash size is a power of 2
     * 
     * @param num
     *            representing world size inputed
     * @return true or false whether the param is a power of two
     */
    public static boolean powerOfTwo(int num) {
        while (num % 2 == 0) {
            num = num / 2;
        }
        if (num == 1) {
            return true;
        }
        else {
            return false;
        }
    }
}
