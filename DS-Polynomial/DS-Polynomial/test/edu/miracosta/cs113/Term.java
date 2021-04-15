package edu.miracosta.cs113;

public class Term implements Cloneable, Comparable<Term>{
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
    	int intCoefficient;
        int intExponent;

        if(term == ""){
          this.setAll(0,0);
        }

        if(term.contains("x")){ 

          if(term.indexOf("x") == 0 || term.indexOf("+") == 0 && term.indexOf("x") == 1){
            if(term.contains("^")){

              intExponent = Integer.parseInt(term.substring(term.indexOf("^") + 1, term.length()));
              
              this.setAll(1, intExponent);
            }else{
              this.setAll(1,1);
            }
 
          }else if(term.indexOf("-") == 0 && term.indexOf("x") == 1){

            if(term.contains("^")){
              
              intExponent = Integer.parseInt(term.substring(term.indexOf("^") + 1, term.length()));
              
              this.setAll(-1, intExponent);
            }else{
              this.setAll(-1,1);
            }
          }else if(term.length() - 1 == term.indexOf("x")){

              intCoefficient = Integer.parseInt(term.substring(0, term.indexOf("x")));

              this.setAll(intCoefficient, 1);
          }else if(term.contains("x") && term.contains("^")){
            intCoefficient = Integer.parseInt(term.substring(0, term.indexOf("x")));
            intExponent = Integer.parseInt(term.substring(term.indexOf("^") + 1, term.length()));

            this.setAll(intCoefficient, intExponent);

          }

        }else{
          intCoefficient = Integer.parseInt(term.substring(0, term.length()));

          this.setAll(intCoefficient,0);
        }
        
    	
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

    

    @Override
    public String toString(){

    	int coefficient = this.coefficient;
        int exponent = this.exponent;

        
        if(coefficient == 1 && exponent == 0){
          return "+1";
        }else if(coefficient >= 1 && exponent == 0){
          return "+" + coefficient;
        }else if(coefficient == 1 && exponent == 1){
          return "+x";
        }else if(coefficient == 1 && exponent >= 1){
          return "+x^" + exponent;
        }else if(coefficient == 1 && exponent <= -1){
          return "+x^" + exponent;
        }else if(coefficient >= 1 && exponent == 1){
          return "+" + coefficient + "x";
        } else if(coefficient >= 1 && exponent >= 1){
          return "+" + coefficient + "x^" + exponent;
        }else if(coefficient >= 1 && exponent <= -1){
          return "+" + coefficient + "x^" + exponent;
        }else if(coefficient == -1 && exponent == 0){
          return "-1";
        }else if(coefficient <= -1 && exponent == 0){
          return String.valueOf(coefficient);
        }else if(coefficient == -1 && exponent == 1){
          return "-x";
        }else if(coefficient <= -1 && exponent == 1){
          return String.valueOf(coefficient) + "x";
        }else if(coefficient == -1 && exponent >= 1){
          return "-x^" + exponent;
        }else if(coefficient == -1 && exponent <= -1){
          return "-x^" + exponent;
        }else if(coefficient <= -1 && exponent == -1){
          return String.valueOf(coefficient) + "x^" + exponent;
        }else if(coefficient == 0){
          return "";
        }
        
        
        return coefficient + "x^" + exponent;

    }
    
    //clone method
    @Override
    public Term clone(){
    	Term newTerm = new Term();
    	newTerm.setAll(this.coefficient, this.exponent);
    	return newTerm;
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

