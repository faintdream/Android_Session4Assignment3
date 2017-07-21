/*
 * Problem statement : Assume that class A extends class B, which extends class C. Also all the three classes implement
 * the method test(). How can a method in a class A invoke the test() method defined in class C
 * (without creating a new instance of class C).
 *
 * As per assignment question, only one of these shall be the answer :-
 * a. test();

 * b. super.test();

 * c. super.super.test();

 * d. ::test();

 * e. C.test();

 * f. It is not possible to invoke test() method defined in C from a method in A.

 My Answer : based on given choices only option 'f' can be the answer, 
 because (1) java does not support multiple inheritance through extends keyword. 
 (2)  if were hypothetically be able to call super.super.test() from A, we would by violating the encapsulation principle of Java.
 
Alternate solution : However if i call constructor of each  class starting A>B
 and then in B's constructor if i call super.test(), eventually i can call test() method from C
 my observation is depicted in code below
 */
package inheritanceexample;

public class InheritanceExample {                                                   // this is our main class

    public static void main(String[] args) {                                        // main section
        A objA = new A();                                                           // declared object of A and called default constructor of A

    }
}

class C {                                                                           // class C declaration

    void test() {                                                                   //test method of class C
        System.out.println("test() method from C");
    }
}

class B extends C {                                                                 // class B declaration, it inherits C

    B() {                                                                           //default constructor of B calling C's test method
        super.test();
    }

    void test() {                                                                   // test method of class B
        System.out.println("test() method from B");
    }
}

class A extends B {                                                                 // class A declaration, it inherits B

    A() {                                                                            // default construct of A

        super();                                                                    // calling default constructor of B
        // reason i had to call super() here is  java by design does not allow
    }                                                                               // super keyword usage anywhere but first statement of constructor 
    //in child class

    void test() {                                                                   // test method of class A                
        System.out.println("test() method from A");

    }

}
