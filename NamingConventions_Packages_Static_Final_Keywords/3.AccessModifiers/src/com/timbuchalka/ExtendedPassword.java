package com.timbuchalka;

public class ExtendedPassword extends Password{
    private int decryptedPassword;

    public ExtendedPassword(int password) {
        super(password);
        this.decryptedPassword = password;
    }

//    @Override
//    public void stroePassword() {
//        System.out.println("Saving password as " + this.decryptedPassword);
//    }
}
