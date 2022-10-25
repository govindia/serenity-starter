package starter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

import static io.restassured.RestAssured.requestSpecification;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.notNullValue;

public class Screenplay {



    @Step("{0} has ability to call rest api")
    public void actorHasCapability(Actor actor) {
        actor.can(CallAnApi.at("https://reqres.in/api"));
    }
    @Step("{0} makes a get call")
    public void makegetrequest(Actor actor) {
        actor.attemptsTo(
                Get.resource("/users")
        );
    }
    @Step("{0} verify expected response")
    public void seeExpectedResponse(Actor actor) {
        actor.should(
                seeThatResponse("all the expected users should be returned",
                        response -> response.body("data.first_name", hasItems("George", "Janet")))
        );
    }
    @Step("{0} makes a post call")
    public void makePostCallWithEndPoint(Actor actor,String endpoint,User user) {
        actor.attemptsTo(Post.to(endpoint).with(requestSpecification -> {
                    return requestSpecification.contentType(ContentType.JSON).body(user);
        }));
    }

    @Step("{0} makes a post call")
    public void makePostCall(Actor actor,User user) {
        actor.attemptsTo(Post.to("/user").with(requestSpecification -> {
            return requestSpecification.contentType(ContentType.JSON).body(user);
        }));
        actor.should(seeThatResponse("User id is generated",response -> response.statusCode(201).body("id",notNullValue())));
    }
    @Step("verify that user id is generated")
    public void verifythatIdIsGenerated(Actor actor) {
        actor.should(seeThatResponse("User id is generated",response -> response.statusCode(201).body("id",notNullValue())));
    }
}
