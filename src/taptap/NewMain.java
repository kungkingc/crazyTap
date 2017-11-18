/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taptap;

/**
 *
 * @author Macbook Pro
 */

import java.sql.*;
import java.util.ArrayList;

public class NewMain {

    ArrayList<Integer> arrayPos1 = new ArrayList<Integer>();
    ArrayList<Integer> arrayPos2 = new ArrayList<Integer>();
    ArrayList<Integer> arrayPos3 = new ArrayList<Integer>();
    ArrayList<Integer> arrayPos4 = new ArrayList<Integer>();
    private Connection connect1;
    private Statement stat1;
    private ResultSet rs;
    private int time;

    public NewMain() throws SQLException, ClassNotFoundException {
        connect1 = DriverManager.getConnection("jdbc:ucanaccess://C://Users//Macbook Pro//Documents/tapNodes.accdb");
        stat1 = connect1.createStatement();
        rs = stat1.executeQuery("select col1, col2, col3,col4 from book");
        while (rs.next()) {
            int pos1 = rs.getInt(1);
            int pos2 = rs.getInt(2);
            int pos3 = rs.getInt(3);
            int pos4 = rs.getInt(4);
            arrayPos1.add(pos1);
            arrayPos2.add(pos2);
            arrayPos3.add(pos3);
            arrayPos4.add(pos4);
        }
    }


    public void checkDrop(ArrayList blue, ArrayList green, ArrayList pink, ArrayList purple) {
        for (time = 0; time < 17; time++) {
            if (arrayPos1.get(time) == 1) {
                System.out.print("1");
            } else {
                System.out.print(" ");
            }
            if (arrayPos2.get(time) == 1) {
                System.out.print("1");
            } else {
                System.out.print(" ");
            }
            if (arrayPos3.get(time) == 1) {
                System.out.print("1");
            } else {
                System.out.print(" ");
            }
            if (arrayPos4.get(time) == 1) {
                System.out.print("1");
            } else {
                System.out.print(" ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        NewMain out = new NewMain();
        // for (int i = 0; i < out.arrayPos4.size(); i++) {
        //     System.out.println(out.arrayPos4.get(i));
        // }
        out.checkDrop(out.arrayPos1, out.arrayPos2, out.arrayPos3, out.arrayPos4);
    }

}
