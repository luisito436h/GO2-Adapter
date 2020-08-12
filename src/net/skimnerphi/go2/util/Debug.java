package net.skimnerphi.go2.util;

import java.lang.reflect.*;

/**
 * Takes any object and parses it into a readable string.
 * @author SkimnerPhi
 */
public class Debug {
  public static String jsonify(Object o) {
    if(o == null) {
      return "null";
    } else if(o instanceof Boolean) {
      return (Boolean)o ? "true":"false";
    } else if(o instanceof Byte) {
      return "" + o;
    } else if(o instanceof Short) {
      return "" + o;
    } else if(o instanceof Integer) {
      return "" + o;
    } else if(o instanceof Long) {
      return "" + o;
    } else if(o instanceof String) {
      String s = (String)o;
      
      //Escape required characters
      s = s.replace("\\", "\\\\"); //backslash
      s = s.replace("\f", "\\f");  //form feed
      s = s.replace("\n", "\\n");  //newline
      s = s.replace("\r", "\\r");  //carriage return
      s = s.replace("\t", "\\t");  //tab
      s = s.replace("\"", "\\\""); //double quote
      
      return "\"" + s + "\"";
    } else if(o.getClass().isArray()) {
      //iterate through o[] and stringify each entry recursively
      String s = "";
      
      for(int idx = 0; idx < Array.getLength(o); idx++) {
        s += "," + jsonify(Array.get(o, idx));
      }
      
      if(s.length() == 0) {
        return "[]";
      } else {
        return "[" + s.substring(1) + "]";
      }
    } else {
      //o is considered a genuine object at this point
      //check for fields and stringify each one recursively
      
      String s = "";
      
      Field[] fields = o.getClass().getFields();
      for(Field f : fields) {
        if(Modifier.isStatic(f.getModifiers())) {
          continue;
        }
        try {
          String subobj = ",\"" + f.getName() + "\":";
          s += subobj + jsonify(f.get(o));
        } catch(IllegalAccessException ex) {
          //do nothing
        }
      }
      
      if(s.length() == 0) {
        return "{}";
      } else {
        return "{" + s.substring(1) + "}";
      }
    }
  }
}
