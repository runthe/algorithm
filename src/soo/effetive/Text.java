package soo.effetive;

import java.util.EnumSet;
import java.util.Set;

public class Text {

  public enum Style {
    BOLD,
    ITALIC,
    UNDERLINE,
    STRKIETHROUGH;

    //어떤Set객체로 인자로 전달할수 있으나 EnumSet이 최선
    public void applyStyles(Set<Style> styles) {

      //사용
      EnumSet.of(Style.BOLD, Style.ITALIC);
    }
  }
}
