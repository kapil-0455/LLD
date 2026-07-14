package Lect6_SOLID.LSP_Rules.Method_Rules;

// satisfy before method can be executed
// preCondition can weaken the condition but not strengthen the condition


class User{
    public void setPass(String password){
        if(password.length() < 8){
            throw new IllegalArgumentException("Password must be long than 8 character");
        }

        System.out.println("Password saved Succesfully");
    }
}

class AdminUser extends User{
    public void setPass(String password){
        if(password.length() < 6){
            throw new IllegalArgumentException("Password must be long than 6 character");
        }

        System.out.println("Password saved Succesfully");
    }

}
public class PreCondition {

    public static void main(String[] args) {
        User user = new User();
        user.setPass("Admin");
    }
}
