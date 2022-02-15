package interpreter;

import java.io.*;
import java.util.*;
import parser.ParserWrapper;
import ast.Program;
import ast.TableStack;

public class Interpreter {

    // Process return codes
    public static final int EXIT_SUCCESS = 0;
    public static final int EXIT_PARSING_ERROR = 1;
    public static final int EXIT_STATIC_CHECKING_ERROR = 2;
    public static void main(String[] args) {
        String filename = args[0];
        Program astRoot = null;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filename));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        try {
	    astRoot = ParserWrapper.parse(reader);
        } catch (Exception ex) {
            Interpreter.fatalError("Uncaught parsing error: " + ex, Interpreter.EXIT_PARSING_ERROR);
        }
	// for debugging
	astRoot.print(System.out);
    // Map<String, Integer> globalSingleTable = new HashMap<>();
    TableStack globalTableStack = new TableStack();
    globalTableStack.newTable();
    astRoot.check(globalTableStack);
    }
    public static void fatalError(String message, int processReturnCode) {
        System.out.println(message);
        System.exit(processReturnCode);
    }
}
