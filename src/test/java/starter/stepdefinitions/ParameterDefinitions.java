package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.DocStringType;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ParameterDefinitions {

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @ParameterType(".*")
    public User user(String userData){
        User user=new User();
        user.setEmail(userData.split(",")[0].trim());
        user.setPassword(userData.split(",")[1].trim());
        return user;
    }

    @DataTableType()
    public User userDefination(Map<String,String> entry)
    {
        return  new User(entry.get("email").trim(),entry.get("password"));
    }

    @DocStringType(contentType = "list_of_users")
    public List<User> userDefinationWithDocString(String docString){
        List<User> userList=new ArrayList<>();
        Arrays.stream(docString.split("\\n")).forEach(e->{
            final String[] split=e.split(",");
            userList.add(new User(split[0].trim(),split[1].trim()));
        });
        return userList;
    }

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }
}
