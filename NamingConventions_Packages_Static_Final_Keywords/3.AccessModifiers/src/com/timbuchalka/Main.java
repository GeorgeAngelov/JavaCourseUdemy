package com.timbuchalka;

public class Main {

	//public static int multiplier = 7;

    public static void main(String[] args) {
//	Account timsAccount = new Account("Tim");
//	timsAccount.deposit(1000);
//	timsAccount.withdraw(500);
//	timsAccount.withdraw(-200);
//	timsAccount.deposit(-20);
//	timsAccount.calculateBalance();
//	timsAccount.balance = 5000;
//
//	System.out.println("Balance on account is " + timsAccount.getBalance());
//    timsAccount.transactions.add(4500);
//    timsAccount.calculateBalance();
/******************************************************/
//		StaticTest firstStaticTest = new StaticTest("1st Instance");
//		System.out.println(firstStaticTest.getName() + " is instance number " + StaticTest.getNumInstances());
//
//		StaticTest secondInstance = new StaticTest("2nd Instance");
//		System.out.println(secondInstance.getName() + " is instance number " + StaticTest.getNumInstances());
//
//		StaticTest thirdInstance = new StaticTest("3nd Instance");
//		System.out.println(thirdInstance.getName() + " is instance number " + StaticTest.getNumInstances());
//		int answer = multiply(6);
//		System.out.println("The answer is " + answer);
//		System.out.println("Multiplier is " + multiplier);
//    }
//
//    public static int multiply(int number){
//    	return number*multiplier;
	/************************************************************/
//
//	    SomeClass one = new SomeClass("one");
//	    SomeClass two = new SomeClass("two");
//	    SomeClass three = new SomeClass("three");
//
//	    System.out.println(one.getInstanceNumber());
//        System.out.println(two.getInstanceNumber());
//        System.out.println(three.getInstanceNumber());
//
//        System.out.println(Math.PI);
//      //  Math m = new Math();
//
//        int pw = 678415;
//        Password password = new ExtendedPassword(pw);
//        password.stroePassword();
//
//        password.letMeIn(1);
//        password.letMeIn(54845);
//        password.letMeIn(4458);
//        password.letMeIn(-1);
//        password.letMeIn(678415);
/**************************************************************/

        System.out.println("Main method called");
        SIBTest test = new SIBTest();
        test.someMethod();
        System.out.println("Owner is " + SIBTest.owner);

    }
}
