package com.fpt.drawingapp;

import com.fpt.drawingapp.exception.InvalidParameterException;
import com.fpt.drawingapp.exception.QuitProgramException;
import com.fpt.drawingapp.model.Canvas;
import com.fpt.drawingapp.service.CommandService;
import com.fpt.drawingapp.service.impl.CommandServiceImpl;

import java.util.Scanner;

public class Main {

    public static final CommandService COMMAND_SERVICE = new CommandServiceImpl();

    public static void main(String[] args) {
        showCommandDescription();

        final Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        final Canvas canvas = new Canvas(10, 2);

        do {
            try {
                System.out.print("enter command: ");
                String inputValue = scanner.nextLine();
                COMMAND_SERVICE.handle(inputValue, canvas);

                System.out.println(canvas.toString());
            } catch (QuitProgramException e) {
                isExit = true;
            } catch (InvalidParameterException e) {
                System.out.println("**** Application Exception: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("**** General Exception was raise: " + e.getMessage());
            }
        } while (!isExit);
    }

    private static void showCommandDescription() {
        System.out.println("Command \t\t\tDescription\n" +
                "C w h           \tShould create a new canvas of width w and height h.\n" +
                "L x1 y1 x2 y2   \tShould create a new line from (x1,y1) to (x2,y2). Currently only\n" + "                \thorizontal or vertical lines are supported. Horizontal and vertical lines\n" + "                \twill be drawn using the 'x' character.\n" +
                "R x1 y1 x2 y2   \tShould create a new rectangle, whose upper left corner is (x1,y1) and\n" + "                \tlower right corner is (x2,y2). Horizontal and vertical lines will be drawn\n" + "                \tusing the 'x' character.\n" +
                "B x y c         \tShould fill the entire area connected to (x,y) with \"colour\" c. The\n" + "                \tbehaviour of this is the same as that of the \"bucket fill\" tool in paint\n" + "                \tprograms.\n" +
                "Q               \tShould quit the program.\n");
    }
}
