package soo.effetive;

public enum PayrollDay {

  MONDAY(PayType.WEEKDAY),
  TUESDAY(PayType.WEEKDAY),
  WEDNESDAY(PayType.WEEKDAY),
  THURSDAY(PayType.WEEKDAY),
  FRIDAY(PayType.WEEKDAY),
  SATURDAY(PayType.WEEKEND),
  SUNDAY(PayType.WEEKEND);

  private final PayType payType;

  PayrollDay(PayType payType) {
    this.payType = payType;
  }

  double pay(double hoursWorked, double payRate) {
    return payType.pay(hoursWorked, payRate);
  }

  //정책 enum
  private enum PayType {
    WEEKDAY {
      @Override
      double overtimePay(double hrs, double payRate) {
        return 0;
      }
    },
    WEEKEND {
      @Override
      double overtimePay(double hrs, double payRate) {
        return 0;
      }
    };

    private static final int HOURS_PER_SHIFT = 8;

    abstract double overtimePay(double hrs, double payRate);

    double pay(double hoursWorked, double payRate) {
      double basePay = hoursWorked * payRate;
      return basePay + overtimePay(hoursWorked, payRate);
    }
  }
}

