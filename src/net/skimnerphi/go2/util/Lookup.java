package net.skimnerphi.go2.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Lookup {
  public static File idDir = new File("src\\ids");
  
  public static HashMap<Short, String> props;
  public static HashMap<Short, String> commander;
  public static HashMap<Integer, String> skill;
  public static HashMap<Short, String> msgtypes;
  
  static {
    try {
      Scanner reader = new Scanner(new File(idDir, "props.txt"));
      props = new HashMap<>();
      while(reader.hasNext()) {
        String[] str = reader.nextLine().split("=");
        props.put(Short.parseShort(str[0]), str[1]);
      }
      reader = new Scanner(new File(idDir, "propscommander.txt"));
      commander = new HashMap<>();
      while(reader.hasNext()) {
        String[] str = reader.nextLine().split("=");
        commander.put(Short.parseShort(str[0]), str[1]);
      }
      reader = new Scanner(new File(idDir, "commander.txt"));
      skill = new HashMap<>();
      while(reader.hasNext()) {
        String[] str = reader.nextLine().split("=");
        skill.put(Integer.parseInt(str[0]), str[1]);
      }
      reader = new Scanner(new File(idDir, "msgtypes.txt"));
      msgtypes = new HashMap<>();
      while(reader.hasNext()) {
        String[] str = reader.nextLine().split("=");
        msgtypes.put(Short.parseShort(str[0]), str[1]);
      }
    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
      System.exit(-1);
    }
  }
  
  public static String getProp(short id) {
    if(props.containsKey(id)) {
      return props.get(id);
    }
    int star = id % 9 + 1;
    id -= id % 9;
    if(commander.containsKey(id)) {
      return commander.get(id) + "(" + star + "★)";
    }
    return "Unknown item " + id;
  }
  
  public static String getComm(int id) {
    if(skill.containsKey(id)) {
      return skill.get(id);
    }
    return "Unknown commander " + id;
  }
  
  public static String getMsgType(short id) {
    if(msgtypes.containsKey(id)) {
      return msgtypes.get(id);
    }
    return "Unknown message type " + id;
  }
}
