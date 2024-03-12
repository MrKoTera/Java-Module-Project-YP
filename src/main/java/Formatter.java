class Formatter {
    double rubles;
    public static String typeMoneyRub(double rubles) {
        double rublesFloor = Math.floor(rubles);
        String rub[] = new String[3];
        rub[0] = "рубль";
        rub[1] = "рубля";
        rub[2] = "рублей";
        String rublesOut;

        int rublesFloorInt = (int) rublesFloor % 100; // Преобразуем в int для switch/case
        if(rublesFloorInt > 19) {
            rublesFloorInt = rublesFloorInt % 10;
        }

        rublesOut = switch (rublesFloorInt) {
            case 1 ->  rub[0];
            case 2, 3, 4 -> rub[1];
            default -> rub[2];
        };
        return rublesOut;
    }
    public static String moneyCut(double rubles) {
        return String.format("%.2f", rubles);
    }

}