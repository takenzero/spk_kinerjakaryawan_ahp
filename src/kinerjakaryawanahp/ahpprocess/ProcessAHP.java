package kinerjakaryawanahp.ahpprocess ;

import java.io.*;
import Jama.*;
import java.text.DecimalFormat;

public class ProcessAHP implements Serializable,Cloneable{
    public static double EXTREMELY=9.0;
    public static double BETWEEN_EXTREMELY_AND_VERY_STRONGLY=8.0;
    public static double VERY_STRONGLY=7.0;
    public static double BETWEEN_VERY_VERY_STRONGLY_AND_STRONGLY=6.0;
    public static double STRONGLY=5.0;
    public static double BETWEEN_STRONGLY_AND_SLIGHTLY=4.0;
    public static double SLIGHTLY=3.0;
    public static double BETWEEN_SLIGHTLY_EQUALLY=2.0;
    public static double EQUALLY=1.0;

    private Matrix A ;
    private int size;
    
    public void set(int i,int j, double value) {
        if (i>=getSize() && j>=getSize())
            throw new IllegalArgumentException("index of a single element should be like 0<=i,j<size");
        if (i==j && value!=EQUALLY)
            throw new IllegalArgumentException("Elements in the diagonal of the Pairwise Comparison Matrix shoulb be EQUALLY.");
        A.set(i,j,value);
        A.set(j,i,1.0/value);
    }

    public double get(int i,int j) {
        if (i>=getSize() && j>=getSize())
            throw new IllegalArgumentException("index of a single element should be like 0<=i,j<size");
        return A.get(i,j);
    }

    public Matrix getA() {
        return this.A;
    }

    public void setA(Matrix argA){
        this.A = argA;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int argSize){
        this.size = argSize;
    }

    public ProcessAHP(int size ){
        this.size=size;
        InitMatrix();
    }

    public void InitMatrix(){
        A =new Matrix(size,size, 1.0);
    }

    public void print(){
        A.print(this.size,this.size);
    }

    public double getInconsistencyIndex()  {
        if (getSize()<=1) return 0.0;
        return (getMaxEigenValue()- getSize())/ (getSize()-1.0); 
    }

    public double getRandomInconsistency(){
        switch (size){
            case 0 : return 0.00;
            case 1 : return 0.00;
            case 2 : return 0.00;
            case 3 : return 0.58;
            case 4 : return 0.90;
            case 5 : return 1.12;
            case 6 : return 1.24;
            case 7 : return 1.32;
            case 8 : return 1.41;
            case 9 : return 1.45;
            case 10: return 1.49;
            default : return 1.5; //take care
        }
    }

    public double getInconsistencyRatio(){
        if (getSize()<=2) return 0.0;
        return getInconsistencyIndex()/getRandomInconsistency();
    }

    public boolean isConsistency(){
        if (getInconsistencyRatio() <= 0.1) return true;
        else return false;
    }

    public double getMaxEigenValue(){
        EigenvalueDecomposition Eig = new EigenvalueDecomposition(A);
        double[] values = Eig.getRealEigenvalues() ;
        double max=0.0;

        for(int i=0;i<this.size;i++){
            if (values[i]>=max) max=values[i];
        }
        return max;
    }

    public Matrix getWeight(){
        Matrix Ab= new Matrix(getSize(), getSize());
        Matrix W=new Matrix (getSize(), 1, 1.0);
        double sum=0.00;
        
        for(int j=0;j < getSize();j++){
            sum=0.00;
            for (int i=0;i<getSize();i++){
                sum+=A.get(i,j);
            }
            
            for (int i=0;i<getSize();i++){
                try{Ab.set(i,j,A.get(i,j)/sum);}
                catch (ArrayIndexOutOfBoundsException e) { System.err.println("Error in setting Ab : ArrayIndexOutOfBoundsException"+e);}
            }
        }

        for(int i=0;i < getSize();i++){
            sum=0.00;
            for (int j=0;j<getSize();j++){
                sum+=A.get(i,j);
            }
            
            try{W.set(i,0,sum);}
            catch (ArrayIndexOutOfBoundsException e) { System.err.println("Error in setting W : ArrayIndexOutOfBoundsException"+e);}

        }
      
        sum=0.00;
        for (int i=0;i<getSize();i++){
            try{sum+=W.get(i,0);}
            catch (ArrayIndexOutOfBoundsException e) { System.err.println("Error in setting W : ArrayIndexOutOfBoundsException"+e);}
        }
        for (int i=0;i<getSize();i++){
            try{W.set(i,0,W.get(i,0)/sum);} 
            catch (ArrayIndexOutOfBoundsException e) { System.err.println("Error in setting W : ArrayIndexOutOfBoundsException"+e);}
        }
        return W;
    }

    public double getWeight(int i){
        Matrix W=new Matrix(getSize(),1);
        W=getWeight();
        return W.get(i,0);
    }

    @Override
    public String toString(){
        String s = new String();
        s="Matrix : \n";
        for (int i=0;i<getSize();i++){
            for (int j=0;j<getSize();j++){
                s+=" "+get(i,j)+" ";
            }
            s+="\n";
        }
        s+="Weights                   : \n";
        for(int i=0;i<getSize();i++) s+=" "+getWeight(i)+" ";
        s=s+"\n";
        s=s+"Inconsistency Ratio      : " +getInconsistencyRatio()+"\n";
        return s;
    }
    
    public void addElement(){
        setSize(getSize()+1);
        InitMatrix();

    }

    public void delElement(int index){
        Matrix B=new Matrix((size-1),(size-1),1.0);

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if (i<index && j<index){
                    B.set(i,j,A.get(i,j));
                }
                
                if (i<index && index<j){
                    B.set(i,j-1,A.get(i,j));
                }
                
                if (index <i && j<index){
                    B.set(i-1,j,A.get(i,j));
                }
                
                if (index<i && index<j){
                    B.set(i-1,j-1,A.get(i,j));
                }
            }
        }      
        B=A;;
        size--;
    }
/*
    public static void main(String args[]){
        ProcessAHP P=new ProcessAHP(3);

        P.set(0, 1, 0.3);
        P.set(0, 2, 3);
        P.set(1, 2, 2);

        P.print();
        
        System.out.println("");

        System.out.println("getMaxEigenValue() : "+ P.getMaxEigenValue());   
        System.out.println("getInconsistencyIndex() : "+ P.getInconsistencyIndex());
        System.out.println("getRandomInconsistency() : "+ P.getRandomInconsistency());
        System.out.println("getInconsistencyRatio() : " +P.getInconsistencyRatio());
        System.out.println("PairwiseComparisonMatrix is consistency : "+P.isConsistency());

        Matrix W = P.getWeight();
        //DecimalFormat df = new DecimalFormat("#.##");
        //System.out.println(df.format(W.get(1, 0)));
        W.print(P.getSize(),2);
    }
*/

}