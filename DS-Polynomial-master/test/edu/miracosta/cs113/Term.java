package edu.miracosta.cs113;

public class Term implements Comparable<Term>{
    public static int DEFAULT_COEFFICIENT = 1;
    public static int DEFAULT_EXPONENT = 1;


    private int coefficient;
    private int exponent;

    //Full Constructor
    public Term(int coefficient, int exponent){
        this.setAll(coefficient, exponent);
    }

    //Default constructor
    public Term(){
        this(DEFAULT_COEFFICIENT, DEFAULT_EXPONENT);
    }

    //Copy constructor
    public Term(Term original){
        if(original == null){
            System.exit(0);
        }else{
            this.setAll(original.coefficient, original.exponent);
        }

    }

    //String Constructor
    public Term(String term){



    }

    //SETTERS
    public boolean setCoefficient(int coefficient){
        this.coefficient = coefficient;
        return true;
    }

    public boolean setExponent(int exponent){

        this.exponent = exponent;
        return true;
    }

    //GETTERS
    public int getCoefficient(){
        return this.coefficient;
    }

    public int getExponent(){
        return this.exponent;
    }

    //SET ALL
    public boolean setAll(int coefficient, int exponent){
        return this.setCoefficient(coefficient) && this.setExponent(exponent);
    }


    public Term clone(){
        return this.clone();
    }

    @Override
    public String toString(){
        return "Coefficient: " + this.coefficient + "\nExponent: " + this.exponent;
    }

    //still have to do
    @Override
    public int compareTo(Term other) {
        if(other.exponent == this.exponent){
            return 0;
        }else if(other.exponent < this.exponent){
            return 1;
        }else{
            return -1;
        }
    }


    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }else{
            Term newTerm = (Term) obj;
            return this.coefficient == newTerm.coefficient && this.exponent == newTerm.exponent;
        }
    }

}