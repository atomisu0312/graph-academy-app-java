package sandbox;

import org.neo4j.driver.*;

import neoflix.AppUtils;

public class JavaDriverChack {
  static String username = "neo4j";
  static String password = "letmein!";
  static Driver driver = GraphDatabase.driver("bolt://neo4j:7687",
      AuthTokens.basic(username, password));

  public static void main(String[] args) {
    System.out.println(AppUtils.getNeo4jUri());
    System.out.println(AppUtils.getNeo4jUsername());
    System.out.println(AppUtils.getNeo4jPassword());
    driver.verifyConnectivity();
  }

}
