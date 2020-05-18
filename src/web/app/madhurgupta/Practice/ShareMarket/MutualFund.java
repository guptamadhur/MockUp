package web.app.madhurgupta.Practice.ShareMarket;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: MockUp
# Created on: 19-05-2020 01:44
*/

import web.app.madhurgupta.Helper.Node.SingleNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MutualFund {
    private static final String file_Path = "src\\web\\app\\madhurgupta\\Practice\\ShareMarket\\MutualFundReport.csv";
    private static SingleNode head, tail;
    private static Double totalUnits = 0.0, holdingUnits = 0.0;

    public static void main(String[] args) {
        MutualFund ob = new MutualFund();
        ob.readCSV(file_Path);
        SingleNode node;
        node = head;
        while (node != null) {
            holdingUnits = holdingUnits + node.getValue();
            node = node.getNext();
        }
        System.out.print("Total Units: " + totalUnits + "  Holding Units: " + holdingUnits + "  Selling Units: " + (totalUnits - holdingUnits));
    }

    private void readCSV(String file_Path) {
        Path pathtoFile = Paths.get(file_Path);
        try (BufferedReader br = Files.newBufferedReader(pathtoFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            line = br.readLine(); //Header of File
            while (line != null) {
                String[] dataRow = line.split(",");
                dataAnalytics(dataRow);
                //System.out.println(dataRow[0] + " " + dataRow[4]);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void dataAnalytics(String[] dataRow) {
        Double value = Double.parseDouble(dataRow[5]);
        if (value > 0) {//Buy
            SingleNode newNode = new SingleNode();
            newNode.setValue(value);
            totalUnits += value;
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.setNext(newNode);
                tail = newNode;
            }
        } else {//Sell
            //Check not selling ore then total Cost
            sellUnits(value);
        }
    }

    private void sellUnits(Double value) {
        Double val = head.getValue() - value;
        if (val == 0) {
            head = head.getNext();
            return;
        } else if (val > 0) {
            head.setValue(val);
        } else if (val < 0) {
            head = head.getNext();
            sellUnits(Math.abs(val));
        }
    }
}
