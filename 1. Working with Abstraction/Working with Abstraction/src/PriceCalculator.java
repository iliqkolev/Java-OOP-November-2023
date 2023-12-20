public class PriceCalculator {
    private final double pricePerDay;
    private final int numberOfDays;
    private final Season season;
    private final DiscountType discountType;

    public PriceCalculator(double pricePerDay, int numberOfDays, Season season, DiscountType discount) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discountType = discount;
    }

    public double calculate() {
        return pricePerDay * numberOfDays * season.getFactor() * discountType.getDiscount();
    }

//    private double getDiscount() {
//        if (discount.equals("VIP")){
//            return 0.80;
//        }else if (discount.equals("SecondVisit")){
//            return 0.90;
//        }
//
//            return 1;
//    }
//
//    private double getSeasonFactor() {
//        if (season.equals("Spring")){
//            return 2;
//        }else if (season.equals("Winter")){
//            return 3;
//        }else if (season.equals("Summer")){
//            return 4;
//        }
//
//            return 1;
//    }
// }
}