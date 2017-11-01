package soo.solid.srp;

public class Guitar {

  private String serialNumber;

  private GuitarSpec guitarSpec;

  public Guitar(String serialNumber, GuitarSpec guitarSpec) {
    this.serialNumber = serialNumber;
    this.guitarSpec = guitarSpec;
  }
}
