package lesson7;

public class MyTest {
    private Calculations mtd;
    @BeforeSuit(description = "create object of calculations ")

    public void executeBefore(){
        mtd = new Calculations();
    }

    @Test(description = "run sum test1 ", prioritet = 2)
    public void sumTest1(){
        int a = 10;
        if (mtd.sum(2,8) == a){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
    }

    @Test(description = "run sum test2 ",prioritet = 1)
    public void sumTest2(){
        int a = 10;
        if (mtd.sum(12,-2) == a){
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
        }


    }
    @Test(prioritet = 5)
    public void multTest(){
        int m = 12;
        if (mtd.mult(4,3) == m){
            System.out.println("multTest passed");
        }else {
            System.out.println("multTest failed");
        }
    }
    @Test(prioritet = 4)
    public void multTest2(){
        int m = 15;
        if (mtd.mult(-5,-3) == m){
            System.out.println("multTest2 passed");
        }else {
            System.out.println("multTest2 failed");
        }
    }
}
