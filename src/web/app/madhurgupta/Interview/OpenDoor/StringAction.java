package web.app.madhurgupta.Interview.OpenDoor;

/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: Java MockUp

# Problem Statement

# You are going to make a key-value store! In this store, keys are always strings and values are always integers. 
# Feel free to use any builtin data structure(s) (List, Array, Map,Set, etc.) to implement your store. 
# Your solution will need to be capable of parsing and executing these commands: 

# PUT k v
# This command should set the key (k) to hold a value (v). If the key already holds a value then it should be overwritten.

# GET k
# Get the value of the key and print it out. If the key does not exist then the command should print out "NOT FOUND".

# DEL k
# Removes the specified key from the store. If the key does not exist in the store then the command is ignored.

# EXPIRE k s
# This command sets a key’s time to live (TTL) in seconds. The command operates on this set of rules:
# If the key does not exist in the database then the command should print "NOT FOUND".
# If a GET command is performed on an expired key, then "NOT FOUND" should be printed.
# If a PUT command is performed on a key with a timeout, then the timeout should be cleared.
# If an EXPIRE command is performed on an expired key, then "NOT FOUND" should be printed.
# If an EXPIRE command is performed on a non-expired key, then it should update the TTL.
 
# TTL k
# This command prints out the remaining time to live (in seconds) of a key that has a timeout. The rules for this command are:
# If the key does not exist in the database then the command should print "NOT FOUND".
# If the key exists in the database but it does not have a timeout then the command should print "NONE".
# If the key exists in the database and it has expired then the command should print "NOT FOUND".
# The printed out value should be an integer.

# SLEEP s
# Delay the evaluation of the next command for the given number of seconds

*/

import java.io.*;
import java.util.*;

public class StringAction {

    static HashMap<String, Date> timerHashMap = new HashMap<String, Date>();
    static HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        String[] inputArr = {
                "PUT a 10",
                "GET a",
                "DEL a",
                "GET a",
                "EXPIRE b 12",
                "EXPIRE a 12",
                "TTL 10",
                "TTL a",
                "SLEEP 2"
        };
        for (int i = 0; i < inputArr.length; i++) {
            StringAction.executeCommand(inputArr[i]);
        }
    }

    public static String executeCommand(String input) {
        String res = "";
        Date date = new Date();
        String[] st = input.split(" ");
        String action = st[0].trim();
        String key = st[1];

        if ("PUT".equals(action)) {
            if (hashMap.containsKey(key)) {
                hashMap.remove(key);
            }
            hashMap.put(key, Integer.parseInt(st[2]));
        } else if ("GET".equals(action)) {
            if (hashMap.containsKey(key)) {
                res = String.valueOf(hashMap.get(key));
            } else {
                res = "NOT FOUND";
            }
        } else if ("DEL".equals(action)) {
            if (hashMap.containsKey(key)) {
                hashMap.remove(key);
            }
        } else if ("EXPIRE".equals(action)) {
            if (timerHashMap.containsKey(key)) {
                Date time = timerHashMap.get(key);
                if (time.before(date)) {
                    timerHashMap.replace(key, new Date(Integer.parseInt(st[2])));
                } else {
                    res = "NOT FOUND";
                }
            } else {
                res = "NOT FOUND";
            }
        } else if ("TTL".equals(action)) {
            if (hashMap.containsKey(key)) {
                if (timerHashMap.containsKey(key)) {
                    Date time = timerHashMap.get(key);
                    if (time.before(date)) {
                        res = time.toString();
                    } else {
                        res = "NOT FOUND";
                    }
                } else {
                    res = "NONE";
                }
            } else {
                res = "NOT FOUND";
            }
        } else if ("SLEEP".equals(action)) {
            try {
                Thread.sleep(Integer.parseInt(key) * 1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(res);

        return res;
    }
}
