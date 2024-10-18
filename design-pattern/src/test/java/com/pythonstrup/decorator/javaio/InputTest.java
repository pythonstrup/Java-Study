package com.pythonstrup.decorator.javaio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

class InputTest {

  @Test
  void test() {
    int c;
    try {

      InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream(
          "src/test/java/com/pythonstrup/decorator/javaio/text.txt")));
      while ((c = in.read()) >= 0) {
        System.out.println((char)c);
      }
      in.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}