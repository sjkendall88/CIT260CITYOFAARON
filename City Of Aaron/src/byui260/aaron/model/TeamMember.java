/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui260.aaron.model;

/**
 *
 * @author Sterling
 */
public enum TeamMember {
    
    one("James Rasmussen","Man with no Sleep"),
    two("JJ Hugh","Man with no Time"),
    three("Sterling Kendall","Man of frustrations");
        
    private String memberName;
    private String memberTitle;

    TeamMember(String memberName, String memberTitle){
        this.memberName = memberName;
        this.memberTitle = memberTitle;
    }
    
    public String getMemberName() {
        return memberName;
    }

    public String getMemberTitle() {
        return memberTitle;
    }    
    
}
