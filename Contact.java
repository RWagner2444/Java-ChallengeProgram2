
/**
 * Object class for the challenge program
 * 3-23-2021
 * Ryan Wagner
 */
public class Contact
{
    private String name;
    private String relation;
    private String birthday;
    private String phoneNumber;
    private String email;
    
    public Contact(String name, String relation, String birthday, String phoneNumber, String email){
        this.name = name;
        this.relation = relation;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getRelation(){
        return relation;
    }
    
    public void setRelation(String relation){
        this.relation = relation;
    }
    
    public String getBirthday(){
        return birthday;
    }
    
    public void setBirthday(String birthday){
        this.birthday = birthday;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber){
        this.name = name;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String toString(){
        return String.format("%-10s %-10s %-10s %-15s %s", name, relation, birthday, phoneNumber, email);
    }
}
