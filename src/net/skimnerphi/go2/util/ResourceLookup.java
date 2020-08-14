package net.skimnerphi.go2.util;

import java.awt.Image;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Wrapper for getting name strings and sprites from the res directory
 * @author SkimnerPhi
 */
public class ResourceLookup {
  private static final String DIR_STRING = "/res/string/";
          
  private static final String DIR_ICON_PORTRAIT = "/res/icon/portrait/";
  private static final String DIR_ICON_PROP = "/res/icon/prop/";
  private static final String DIR_ICON_PROPCOMMANDER = "/res/icon/prop/commander/";
  
  //prop (item) names, except for commander cards
  private static HashMap<Integer, String> namesProp;
  //commander card names (as in bag)
  private static HashMap<Integer, String> namesPropCommander;
  //commander names (as in command center)
  private static HashMap<Integer, String> namesCommander;
  //ship hull names
  private static HashMap<Integer, String> namesHulls;
  //debug names for network messages
  private static HashMap<Integer, String> namesMsgtype;
  
  static {
    namesProp = readStringLookupFile("props.txt");
    namesPropCommander = readStringLookupFile("propscommander.txt");
    namesCommander = readStringLookupFile("commander.txt");
    namesMsgtype = readStringLookupFile("msgtypes.txt");
    namesHulls = readStringLookupFile("hull.txt");
  }
  
  private static HashMap<Integer, String> readStringLookupFile(String filename) {
    InputStream stream = ResourceLookup.class.getResourceAsStream(DIR_STRING + filename);
    Scanner reader = new Scanner(stream);
    
    HashMap<Integer, String> ret = new HashMap<>();
    
    while(reader.hasNextLine()) {
      String[] nextLine = reader.nextLine().split("=");
      ret.put(Integer.parseInt(nextLine[0]), nextLine[1]);
    }
    
    return ret;
  }
  
  /**
   * Lookup the name for a bag item
   * @param id Prop ID
   * @return Name of the item, or a generic description if not found.
   */
  public static String getPropName(int id) {
    if(namesProp.containsKey(id)) {
      return namesProp.get(id);
    }
    
    int star = id % 9 + 1;
    id -= id % 9;
    
    if(namesPropCommander.containsKey(id)) {
      return namesPropCommander.get(id) + "(" + star + "★)";
    }
    return "Unknown item #" + id;
  }
  
  /**
   * Lookup the name for a recruited commander
   * @param id Commander ID
   * @return Name of the commander, or a generic description if not found.
   */
  public static String getCommanderName(int id) {
    if(namesCommander.containsKey(id)) {
      return namesCommander.get(id);
    }
    return "Unknown commander #" + id;
  }
  
  /**
   * Lookup the name for a ship hull
   * @param id Ship body ID
   * @return Name of the hull, or a generic description if not found.
   */
  public static String getHullName(int id) {
    if(namesHulls.containsKey(id)) {
      return namesHulls.get(id);
    }
    return "Unknown hull #" + id;
  }
  
  /**
   * Lookup the name for a message type ID
   * @param id Message ID
   * @return Name of the MsgType, or a generic description if not found.
   */
  public static String getMessageName(int id) {
    if(namesMsgtype.containsKey(id)) {
      return namesMsgtype.get(id);
    }
    return "Unknown message type #" + id;
  }
  
  /**
   * Lookup the sprite for a bag item
   * @param id Prop ID
   * @return The sprite if it exists, otherwise null.
   */
  public static Image getPropIcon(int id) {
    throw new UnsupportedOperationException("Not implemented yet");
  }
  
  /**
   * Lookup the portrait icon for a recruited commander
   * @param id Commander ID
   * @return The icon if it exists, otherwise null.
   */
  public static Image getCommanderIcon(int id) {
    throw new UnsupportedOperationException("Not implemented yet");
  }
}
