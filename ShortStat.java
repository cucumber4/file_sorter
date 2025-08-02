public class ShortStat {
    public void getShortStat(){
        System.out.println("\n    SHORT STATISTICS \n");

        System.out.println("Integers count : " + FileList.getIntegers().size());
        System.out.println("Float count : " + FileList.getFloats().size());
        System.out.println("String count : " + FileList.getStrings().size());
    }
}
