/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinerjakaryawanahp.model;

/**
 *
 * @author taken
 */
public class ModelValues {
    private Double MaxEigenValue;
    private Double InconsistencyIndex;
    private Double RandomInconsistency;
    private Double InconsistencyRatio;
    private Integer Flag;
    private Integer Id;
    
    public void setMaxEigenValue(Double MaxEigenValue){
        this.MaxEigenValue = MaxEigenValue;
    }
    
    public Double getMaxEigenValue(){
        return MaxEigenValue;
    }
    
    public void setInconsistencyIndex(Double InconsistencyIndex){
        this.InconsistencyIndex = InconsistencyIndex;
    }
    
    public Double getInconsistencyIndex(){
        return InconsistencyIndex;
    }
    
    public void setRandomInconsistency(Double RandomInconsistency){
        this.RandomInconsistency = RandomInconsistency;
    }
    
    public Double getRandomInconsistency(){
        return RandomInconsistency;
    }
    
    public void setInconsistencyRatio(Double InconsistencyRatio){
        this.InconsistencyRatio = InconsistencyRatio;
    }
    
    public Double getInconsistencyRatio(){
        return InconsistencyRatio;
    }
    
    public void setFlag(int Flag){
        this.Flag = Flag;
    }
    
    public Integer getFlag(){
        return Flag;
    }
    
    public void setId(int Id){
        this.Id = Id;
    }
    
    public Integer getId(){
        return Id;
    }
}
