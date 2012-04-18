/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

/**
 *
 * @author Andre
 */
public class Ord {
    int id;
    String grunnform;
    String fullform;
    String beskrivelse;
    
    public Ord (int id, String grunnform, String fullform, String beskrivelse){
        this.id = id;
        this.grunnform = grunnform;
        this.fullform = fullform;
        this.beskrivelse = beskrivelse;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }
    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }
    public String getFullform() {
        return fullform;
    }
    public void setFullform(String fullform) {
        this.fullform = fullform;
    }
    public String getGrunnform() {
        return grunnform;
    }
    public void setGrunnform(String grunnform) {
        this.grunnform = grunnform;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Ord{" + "id=" + id + ", grunnform=" + grunnform + ", fullform=" + fullform + ", beskrivelse=" + beskrivelse + '}';
    }
    
}
