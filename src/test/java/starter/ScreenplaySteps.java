package starter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class ScreenplaySteps {

    @Steps
    Screenplay screenplay;

    @Given("{actor} has capability to call rest api")
    public void govinda_has_capability_to_call_rest_api(Actor actor) {
        screenplay.actorHasCapability(actor);
    }
    @When("{actor} makes a get request")
    public void he_makes_a_get_request(Actor actor) {
        screenplay.makegetrequest(actor);
    }
    @Then("{actor} see the expected data is returned")
    public void he_see_the_expected_data_is_returned(Actor actor) {
        screenplay.seeExpectedResponse(actor);
    }

    @When("{actor} makes post call with endpoint {string}")
    public void he_makes_post_call_with_endpoint(Actor actor,String endpoint) {
        User user=new User();
        user.setEmail("govinda.gupta@test.com");
        user.setPassword("Test1234");
        screenplay.makePostCallWithEndPoint(actor,endpoint,user);
    }

    @Then("{actor} verify that user is created and Id is generated")
    public void he_verify_that_user_is_created_and_id_is_generated(Actor actor) {
       screenplay.verifythatIdIsGenerated(actor);
    }

    @When("{actor} creates a user {user}")
    public void he_creates_a_user_with_endpoint(Actor actor,User user) {
        screenplay.makePostCall(actor,user);
    }


    @When("{actor} makes post call with endpoint {string} to create users")
    public void heMakesPostCallWithEndpointToCreateUsers(Actor actor, String endpoint ,List<User> userList) {
        for (User user:userList) {
            screenplay.makePostCallWithEndPoint(actor,endpoint,user);
        }
    }

    @When("{actor} makes post call with endpoint {string} with user data")
    public void he_makes_post_call_with_endpoint_with_user_data(Actor actor,String endpoint,List<User> userList) {
        for (User user:userList) {
            screenplay.makePostCallWithEndPoint(actor,endpoint,user);
        }
    }
}
